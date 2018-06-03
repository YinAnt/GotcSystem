package com.ant.DAOImpl;

import com.ant.DAO.ContentDAO;
import com.ant.exception.SqlException;
import com.ant.models.Content;
import com.ant.models.Hotel;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.util.HibernateUtil;
import com.ant.util.Tools;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class ContentDAOImpl extends BaseDAOImpl<Content> implements ContentDAO {
    /**
     * 根据订单号查询订单内容
     *
     * @param contOrdNo
     * @return
     * @throws SqlException
     */
    @Override
    public List<Content> doFindAllByOrdNo(Long contOrdNo) throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class).add(Restrictions.eq(Parm.CONT_ORD_NO, contOrdNo));
            list = criteria.list();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Content> doFindAllWaitByOrdNo(Long contOrdNo) throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_ORD_NO, contOrdNo));  // 订单号
            criteria.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 未处理状态
            list = criteria.list();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Content> doFindAllWait() throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 未处理状态
            list = criteria.list();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Content> doFindAllWaitForScn() throws SqlException {
        System.out.println("doFindAllWaitForScn");
        List<Content> list = new ArrayList<>();
        List<Content> tmpList = new ArrayList<>();
        List<Integer> scnNoList = new ArrayList<>();
        List<Long> dateList = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 根据景区拿到时间分组
            Criteria criteria1 = session.createCriteria(Content.class);
            criteria1.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));    // 未处理订单
            criteria1.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_SCENIC));  // 景区类型
            criteria1.addOrder(Order.asc(Parm.CONT_SCN_DATE));                      // 时间升序
            criteria1.setProjection(Projections.groupProperty(Parm.CONT_SCN_DATE));
            dateList = criteria1.list();
            System.out.println("dateList:" + dateList.toString());

            // 根据时间获取景区
            for (int i = 0; i < dateList.size(); i++) {
                Criteria criteria2 = session.createCriteria(Content.class);
                criteria2.add(Restrictions.eq(Parm.CONT_SCN_DATE, dateList.get(i)));   // 时间
                criteria2.setProjection(Projections.groupProperty(Parm.CONT_SCN_NO));   // 多个group by 会被覆盖
                scnNoList = criteria2.list();
                System.out.println(dateList.get(i) + "--scnNoList:" + scnNoList.toString());

                // 根据景区+时间分组 求和
                for (int j = 0; j < scnNoList.size(); j++) {
                    int sumAdult = 0, sumChild = 0;
                    Criteria criteria3 = session.createCriteria(Content.class);
                    criteria3.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));    // 未处理订单
                    criteria3.add(Restrictions.and(Restrictions.eq(Parm.CONT_SCN_NO, scnNoList.get(j)), Restrictions.eq(Parm.CONT_SCN_DATE, dateList.get(i))));
                    tmpList = criteria3.list();

                    // 注意，某时间下不一定有该景区需要预定门票，做空值判断
                    if (!tmpList.isEmpty()) {
                        //  由于JAVA的对象引用，更改值的话数据库的值也跟着更改，需要将数组重新分到新的地址
                        // ArrayList<Content> contentArrayList = (ArrayList<Content>) new ArrayList<>(tmpList).clone();  // 浅复制，仅复制对象
                        List<Content> cloneList = Content.clone(tmpList);   // 克隆一个列表

                        Content content = cloneList.get(0);
                        for (int k = 0; k < cloneList.size(); k++) {
                            sumAdult += tmpList.get(k).getContScnNumAdult();
                            sumChild += tmpList.get(k).getContScnNumChild();
                        }
                        content.setContScnNumAdult(sumAdult);
                        content.setContScnNumChild(sumChild);
                        list.add(content);
                    }
                }
            }
            System.out.println("list:" + list.toString());

            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Content> doFindAllWaitForHtl() throws SqlException {
        List<Content> list = new ArrayList<>();
        List<Long> tlist = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例

        long startTime = System.currentTimeMillis();
        long now = startTime;
        long time = startTime;

        try {
            // TODO 方法三，分组查询
            Query q = session.createQuery("select cont.contHtlName,cont.contHtlRoom,cont.contHtlCheckIn,count(*) from Content cont where cont.contState = :contState and cont.contType = :contType group by cont.contHtlName,cont.contHtlRoom,cont.contHtlCheckIn");
            q.setInteger(Parm.CONT_STATE, State.CONT_STATE_WAIT);
            q.setInteger(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL);
//            q.executeUpdate();
            List<Object> oList = q.list();
//            for (Object o : oList) {
//                Object[] objects = (Object[]) o;
//                System.out.println("class:" + objects[0].getClass().getSimpleName() + ",o:" + objects[0]);
//            }
            for (Object o : oList) {
                now = System.currentTimeMillis();
                System.out.println("查询一条记录：" + (now - time));
                time = now;

                Object[] objects = (Object[]) o;
                Criteria criteria = session.createCriteria(Content.class);
                criteria.add(Restrictions.eq(Parm.CONT_HLT_NAME, objects[0]));
                criteria.add(Restrictions.eq(Parm.CONT_HLT_ROOM, objects[1]));
                criteria.add(Restrictions.eq(Parm.CONT_HLT_CHECK_IN, objects[2]));
                List<Content> tmpList = criteria.list();

                // 克隆
                if (!tmpList.isEmpty()) {
                    //  由于JAVA的对象引用，更改值的话数据库的值也跟着更改，需要将数组重新分到新的地址
                    // ArrayList<Content> contentArrayList = (ArrayList<Content>) new ArrayList<>(tmpList).clone();  // 浅复制，仅复制对象
                    List<Content> cloneList = Content.clone(tmpList);   // 克隆一个列表
                    int cnt = cloneList.size();         // 房间数即 记录数
                    Content content = cloneList.get(0);
                    content.setContNoteTag(cnt + ""); // 需要订购的数量 暂存在contNoteTag
                    list.add(content);
                }
            }
            tx.commit(); // 提交事务


            // TODO 方法二，时间花销太大
            // 获取待处理订单中的最大离店时间
//            Criteria criteria1 = session.createCriteria(Content.class);
//            criteria1.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 待处理状态
//            criteria1.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//            criteria1.setProjection(Projections.max(Parm.CONT_HLT_CHECK_OUT));  // 投影
//            tlist = criteria1.list(); // tlist 里只会有一个值
////            for (int i = 0; i < tlist.size(); i++) {
////                Object o = tlist.get(i);  // 可以输出类型属性
////                System.out.println("o:" + o.getClass().getSimpleName());
////            }
//            Long maxTime = tlist.get(0);
//            System.out.println("maxTime:" + Tools.formatDateTime(maxTime));
//
//            now = System.currentTimeMillis();
//            System.out.println("获取待处理订单中的最大离店时间：" + (now-startTime));
//            startTime = now;
//
//            // 获取待处理订单中的最小入住时间
//            Criteria criteria2 = session.createCriteria(Content.class);
//            criteria2.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 待处理状态
//            criteria2.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//            criteria2.setProjection(Projections.min(Parm.CONT_HLT_CHECK_IN));   // 投影
//            tlist = criteria2.list();   // tlist 里只会有一个值
//            Long minTime = tlist.get(0);
//            System.out.println("minTime:" + Tools.formatDateTime(minTime));
//
//            now = System.currentTimeMillis();
//            System.out.println("获取待处理订单中的最小入住时间：" + (now-startTime));
//            startTime = now;
//
//            // 获取待处理订单中出现的酒店名
//            Criteria criteria3 = session.createCriteria(Content.class);
//            criteria3.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 待处理状态
//            criteria3.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//            criteria3.setProjection(Projections.groupProperty(Parm.CONT_HLT_NAME));     // 酒店名
//            List<String> htlNameList = criteria3.list();
//            System.out.println("htlNameList:" + htlNameList.toString());
//
//            now = System.currentTimeMillis();
//            System.out.println("获取待处理订单中出现的酒店名：" + (now-startTime));
//            startTime = now;
//
//            // 获取待处理订单中所有的房型
//            Criteria criteria4 = session.createCriteria(Content.class);
//            criteria4.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 待处理状态
//            criteria4.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//            criteria4.setProjection(Projections.groupProperty(Parm.CONT_HLT_ROOM)); // 房型
//            List<String> htlRoomList = criteria4.list();
//            System.out.println("htlRoomList:" + htlRoomList.toString());
//
//            now = System.currentTimeMillis();
//            System.out.println("获取待处理订单中所有的房型：" + (now-startTime));
//            startTime = now;
//
//            Long oneDay = Tools.TIME_SIZE_DAY;  // 一天的毫秒数
//            Long halfDay = Tools.TIME_SIZE_DAY / 2; // 半天的毫秒数
//            for (Long i = minTime; i < maxTime + halfDay; i += oneDay) {
//                for (int j = 0; j < htlNameList.size(); j++) {
//                    for (int k = 0; k < htlRoomList.size(); k++) {
//                        System.out.println("时间" + Tools.formatDateTime(minTime) + ",酒店名：" + htlNameList.get(j) + "，房型" + htlRoomList.get(k));
//                        Criteria criteria5 = session.createCriteria(Content.class);
//                        criteria5.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));   // 待处理状态
//                        criteria5.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//                        criteria5.add(Restrictions.eq(Parm.CONT_HLT_NAME, htlNameList.get(j)));  // 酒店名
//                        criteria5.add(Restrictions.eq(Parm.CONT_HLT_ROOM, htlRoomList.get(k)));  // 房型
////                        criteria5.add(Restrictions.or(Restrictions.between(Parm.CONT_HLT_CHECK_IN,i,i+oneDay),Restrictions.and(Restrictions.lt(Parm.CONT_HLT_CHECK_IN,i),Restrictions.gt(Parm.CONT_HLT_CHECK_OUT,i+oneDay))));
//                        criteria5.add(Restrictions.eq(Parm.CONT_HLT_CHECK_IN, i));
//                        List<Content> tmpList = criteria5.list();
//                        System.out.println("匹配酒店和房间tmpList:" + tmpList.toString());
//
//
//                        if (!tmpList.isEmpty()) {
//                            System.out.println("htlName:" + htlNameList.get(j) + ",htlRoom:" + htlRoomList.get(k));
//                            //  由于JAVA的对象引用，更改值的话数据库的值也跟着更改，需要将数组重新分到新的地址
//                            // ArrayList<Content> contentArrayList = (ArrayList<Content>) new ArrayList<>(tmpList).clone();  // 浅复制，仅复制对象
//                            List<Content> cloneList = Content.clone(tmpList);   // 克隆一个列表
//                            int cnt = cloneList.size();         // 房间数即 记录数
//                            Content content = cloneList.get(0);
//                            content.setContHtlCheckIn(i);
//                            content.setContHtlCheckOut(i + oneDay);
//                            content.setContNoteTag(cnt + ""); // 需要订购的数量 暂存在contNoteTag
//                            list.add(content);
//                        }
//
//                        now = System.currentTimeMillis();
//                        System.out.println("匹配一次记录：" + (now-startTime));
//                        startTime = now;
//                    }
//                }
//            }
//            System.out.println("list:" + list.toString());
//            tx.commit(); // 提交事务


            // 方法一，不分组计数
//            Criteria criteria = session.createCriteria(Content.class);
//            criteria.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));
//            criteria.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_HOTEL));
//            criteria.addOrder(Order.asc(Parm.CONT_HLT_CHECK_IN));
//            list = criteria.list();
//            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }

        now = System.currentTimeMillis();
        System.out.println("总时间：" + (now - startTime));
        return list;
    }

    @Override
    public List<Content> doFindAllWaitForVhc() throws SqlException {
        System.out.println("doFindAllWaitForVhc");
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_TYPE, State.CONT_TYPE_VEHICLE));
            criteria.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_WAIT));
            list = criteria.list();
            System.out.println("list:" + list.toString());
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }


    @Override
    public void doChangeStateForScn(String contScnName, Long contScnDate) throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_SCN_NAME, contScnName));
            criteria.add(Restrictions.eq(Parm.CONT_SCN_DATE, contScnDate));
            list = criteria.list();

            for (int i = 0; i < list.size(); i++) {
                Long contTimeTag = System.currentTimeMillis();
                Query q = session.createQuery("update Content cont set cont.contState =:contState,cont.contTimeTag =:contTimeTag where cont.contScnName = :contScnName and cont.contScnDate = :contScnDate");
                q.setInteger(Parm.CONT_STATE, State.CONT_STATE_FINISH);
                q.setString(Parm.CONT_SCN_NAME, contScnName);
                q.setLong(Parm.CONT_SCN_DATE, contScnDate);
                q.setLong(Parm.CONT_TIME_TAG, contTimeTag);
                q.executeUpdate();
            }
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
    }

    @Override
    public void doChangeStateForHtl(Content content) throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_HLT_NAME, content.getContHtlName()));
            criteria.add(Restrictions.eq(Parm.CONT_HLT_ROOM, content.getContHtlRoom()));
            criteria.add(Restrictions.eq(Parm.CONT_HLT_CHECK_IN, content.getContHtlCheckIn()));
            criteria.add(Restrictions.eq(Parm.CONT_HLT_CHECK_OUT, content.getContHtlCheckOut()));
            list = criteria.list();

            for (int i = 0; i < list.size(); i++) {
                Long contTimeTag = System.currentTimeMillis();  // 订单内容处理时间
                Query q = session.createQuery("update Content cont set cont.contState =:contState,cont.contTimeTag =:contTimeTag where cont.contHtlName = :contHtlName and cont.contHtlRoom = :contHtlRoom and cont.contHtlCheckIn = :contHtlCheckIn and cont.contHtlCheckOut = :contHtlCheckOut");
                q.setInteger(Parm.CONT_STATE, State.CONT_STATE_FINISH);
                q.setString(Parm.CONT_HLT_NAME, content.getContHtlName());
                q.setString(Parm.CONT_HLT_ROOM, content.getContHtlRoom());
                q.setLong(Parm.CONT_HLT_CHECK_IN, content.getContHtlCheckIn());
                q.setLong(Parm.CONT_HLT_CHECK_OUT, content.getContHtlCheckOut());
                q.setLong(Parm.CONT_TIME_TAG, contTimeTag);
                q.executeUpdate();
            }
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
    }

    @Override
    public void doChangeStateForVhc(Content content) throws SqlException {
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 更新信息
            Long contTimeTag = System.currentTimeMillis();  // 订单内容处理时间
            Query q = session.createQuery("update Content cont set cont.contState =:contState,cont.contTimeTag =:contTimeTag where cont.contNo = :contNo and cont.contOrdNo = :contOrdNo");
            q.setInteger(Parm.CONT_STATE, State.CONT_STATE_FINISH);
            q.setLong(Parm.CONT_TIME_TAG, contTimeTag);
            q.setLong(Parm.CONT_ORD_NO, content.getContOrdNo());
            q.setLong(Parm.CONT_NO, content.getContNo());
            q.executeUpdate();

            // 查询
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_NO, content.getContNo()));   // 已处理状态
            content = (Content) criteria.uniqueResult();
            System.out.println("content:" + content.toString());
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
    }


    /**
     * 加载所有已处理的订单内容
     *
     * @return
     * @throws SqlException
     */
    @Override
    public List<Content> showAllFinishContent() throws SqlException {
        List<Content> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Content.class);
            criteria.add(Restrictions.eq(Parm.CONT_STATE, State.CONT_STATE_FINISH));   // 已处理状态
            list = criteria.list();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return list;
    }
}
