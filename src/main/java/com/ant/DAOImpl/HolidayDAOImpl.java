package com.ant.DAOImpl;

import com.ant.DAO.HolidayDAO;
import com.ant.exception.SqlException;
import com.ant.models.Holiday;
import com.ant.models.Signin;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.util.HibernateUtil;
import com.ant.util.Tools;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class HolidayDAOImpl extends BaseDAOImpl<Holiday> implements HolidayDAO {
    @Override
    public List<Holiday> doFindAllByEmpNo(Integer hldEmpNo) throws SqlException {
        List<Holiday> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Holiday.class).add(Restrictions.eq(Parm.HLD_EMP_NO, hldEmpNo));
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
    public List<Holiday> dofindMyHandleHolidayByEmpNo(String hldHandleName) throws SqlException {
        List<Holiday> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Holiday.class).add(Restrictions.eq(Parm.HLD_HANDLE_NAME, hldHandleName));
//            criteria.add(Restrictions.eq(Parm.HLD_STATE,State.HLD_STATE_WAIT));   // 待处理的请假工单
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
    public List<Holiday> dofindWaitForMyHandleHolidayByEmpNo(String hldHandleName) throws SqlException {
        List<Holiday> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Holiday.class).add(Restrictions.eq(Parm.HLD_HANDLE_NAME, hldHandleName));
            criteria.add(Restrictions.eq(Parm.HLD_STATE, State.HLD_STATE_WAIT));   // 待处理的请假工单
            list = criteria.list();
            System.out.println("list dao:" + list.toString());
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
    public Holiday doFindByHldNo(Long hldNo) throws SqlException {
        Holiday holiday = new Holiday();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Holiday.class).add(Restrictions.eq(Parm.HLD_NO, hldNo));
//            criteria.add(Restrictions.eq(Parm.HLD_STATE,State.HLD_STATE_WAIT));   // 待处理的请假工单
            holiday = (Holiday) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return holiday;
    }

    /**
     * 根据工号查询 当月 的请假记录
     *
     * @param hldEmpNo
     * @return
     * @throws SqlException
     */
    @Override
    public List<Holiday> doFindMonthByEmpNo(Integer hldEmpNo) throws SqlException {
        List<Holiday> list = new ArrayList<>();

        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Holiday.class).add(Restrictions.eq(Parm.HLD_EMP_NO, hldEmpNo));
            // 处理日期
            long firstTime = Tools.getMonthFirstDay();   // 获取今天 所在月1号的零点的毫秒数
            long lastTime = Tools.getNextMonthFirstDay();    // 获取今天所在月的 下个月1号的零点的毫秒数

            // 请假起始有其中一个在本月 或 起止时间包含本月
            criteria.add(Restrictions.or(Restrictions.between(Parm.HLD_START_TIME, firstTime, lastTime),
                    Restrictions.or(Restrictions.between(Parm.HLD_END_TIME, firstTime, lastTime),
                            Restrictions.and(Restrictions.gt(Parm.HLD_END_TIME, lastTime), Restrictions.lt(Parm.HLD_START_TIME, firstTime)))));
            list = criteria.list();
            System.out.println("根据工号查询 当月 的请假记录" + list.toString());
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
