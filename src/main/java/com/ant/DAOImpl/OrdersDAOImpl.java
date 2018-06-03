package com.ant.DAOImpl;

import com.ant.DAO.OrdersDAO;
import com.ant.exception.SqlException;
import com.ant.models.Orders;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.util.HibernateUtil;
import com.ant.util.Tools;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class OrdersDAOImpl extends BaseDAOImpl<Orders> implements OrdersDAO {
    @Override
    public List<Orders> doFindAllDesc() throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Orders.class).addOrder(Order.desc(Parm.ORD_START_TIME));
            list = criteria.list();
            System.out.println("criteria list:" + list.toString());
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
    public List<Orders> doFindHldedDesc() throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Orders.class).addOrder(Order.desc(Parm.ORD_START_TIME));
            criteria.add(Restrictions.ne(Parm.ORD_STATE, State.ORD_STATE_WAIT)); // 订单状态不是 待处理
            list = criteria.list();
            System.out.println("criteria list:" + list.toString());
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
    public List<Orders> doFindWaitAllDesc() throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq(Parm.ORD_STATE, State.ORD_STATE_WAIT)).addOrder(Order.desc(Parm.ORD_START_TIME));
            System.out.println("criteria:" + criteria.toString());
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
    public List<Orders> doFindMonthWaitAllDesc() throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            // 处理日期
            long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
            long lastTime = Tools.getNextMonthFirstDay();    // 获取今天所在月的 下个月1号的零点的毫秒数

            Criteria criteria = session.createCriteria(Orders.class);
            // 创建时间或出行时间均在本月的记录
            criteria.add(Restrictions.eq(Parm.ORD_STATE, State.ORD_STATE_WAIT));    // 待处理
            criteria.add(Restrictions.or(Restrictions.between(Parm.ORD_CREATE_TIME, firstTime, lastTime), Restrictions.between(Parm.ORD_START_TIME, firstTime, lastTime)));
            criteria.addOrder(Order.desc(Parm.ORD_START_TIME));
            System.out.println("criteria:" + criteria.toString());
            list = criteria.list();
            System.out.println("doFindMonthWaitAllDesc list:" + list.toString());
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
    public List<Orders> doFindMonthHldedAllDesc() throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            // 处理日期
            long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
            long lastTime = Tools.getNextMonthFirstDay();    // 获取今天所在月的 下个月1号的零点的毫秒数

            Criteria criteria = session.createCriteria(Orders.class);
            // 创建时间或出行时间均在本月的记录
            criteria.add(Restrictions.eq(Parm.ORD_STATE, State.ORD_STATE_HANDLE));  // 已处理
            criteria.add(Restrictions.or(Restrictions.between(Parm.ORD_CREATE_TIME, firstTime, lastTime), Restrictions.between(Parm.ORD_START_TIME, firstTime, lastTime)));
            criteria.addOrder(Order.desc(Parm.ORD_START_TIME));
            System.out.println("criteria:" + criteria.toString());
            list = criteria.list();
            System.out.println("doFindMonthWaitAllDesc list:" + list.toString());
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
    public Orders doFindOrderByOrdNo(Long ordNo) throws SqlException {
        Orders orders = new Orders();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Orders.class);
            criteria.add(Restrictions.eq(Parm.ORD_NO, ordNo));
            orders = (Orders) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public List<Orders> doFindOrdByUserNameDesc(String userName) throws SqlException {
        List<Orders> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Orders.class);
            criteria.add(Restrictions.eq(Parm.ORD_USER, userName));
            criteria.addOrder(Order.desc(Parm.ORD_START_TIME));
            System.out.println("criteria:" + criteria.toString());
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
    public Orders setOrdAgentByOrdNo(Long ordNo, Integer ordAgentNo, String ordAgentName) throws SqlException {
        Orders orders = new Orders();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 使用HQL，更新
            Query q = session.createQuery("update Orders o set o.ordAgent  = :ordAgentNo,o.ordAgentName  = :ordAgentName  where o.ordNo = :ordNo");
            q.setInteger("ordAgentNo", ordAgentNo);
            q.setString("ordAgentName", ordAgentName);
            q.setLong("ordNo", ordNo);
            q.executeUpdate();
            // 查询
            Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq(Parm.ORD_NO, ordNo));
            orders = (Orders) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Orders freshTotalPay(Long ordNo, float pay) throws SqlException {
        Orders orders = new Orders();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 查询订单
            Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq(Parm.ORD_NO, ordNo));
            orders = (Orders) criteria.uniqueResult();
            // 使用HQL，更新
            Query q = session.createQuery("update Orders o set o.ordPay  = :pay  where o.ordNo = :ordNo");
            q.setLong("ordNo", ordNo);
            q.setFloat("pay", pay);
            q.executeUpdate();
            // 再查询
            orders = (Orders) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Orders setOrdHlded(Long ordNo) throws SqlException {
        System.out.println("setOrdHlded:");
        Orders orders = new Orders();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 使用HQL，更新
            Query q = session.createQuery("update Orders o set o.ordState  = :ordState  where o.ordNo = :ordNo");
            q.setLong("ordNo", ordNo);
            q.setInteger("ordState",2); // 设置为 已处理（待付款）
            q.executeUpdate();
            // 再查询
            Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq(Parm.ORD_NO, ordNo));
            orders = (Orders) criteria.uniqueResult();
            System.out.println("orders:" + orders.toString());
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Orders setOrdPayed(Long ordNo) throws SqlException {
        System.out.println("setOrdPayed:");
        Orders orders = new Orders();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 使用HQL，更新
            Query q = session.createQuery("update Orders o set o.ordState  = :ordState  where o.ordNo = :ordNo");
            q.setLong("ordNo", ordNo);
            q.setInteger("ordState",3); // 设置为 已付款
            q.executeUpdate();
            // 再查询
            Criteria criteria = session.createCriteria(Orders.class).add(Restrictions.eq(Parm.ORD_NO, ordNo));
            orders = (Orders) criteria.uniqueResult();
            System.out.println("orders:" + orders.toString());
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return orders;
    }
}
