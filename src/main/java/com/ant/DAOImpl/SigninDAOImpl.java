package com.ant.DAOImpl;

import com.ant.DAO.SigninDAO;
import com.ant.exception.SqlException;
import com.ant.models.Signin;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import com.ant.util.Tools;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class SigninDAOImpl extends BaseDAOImpl<Signin> implements SigninDAO {


    /**
     * 查找一个人所有的签到记录
     *
     * @return
     * @throws SqlException
     */
    public List<Signin> doFindAllByEmpNo(Integer signEmpNo) throws SqlException {
        List<Signin> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Signin.class).add(Restrictions.eq(Parm.SIGN_EMP_NO, signEmpNo));
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
    public Signin doFindByEmpAndSignDay(Integer signEmpNo, Long time) throws SqlException {
        Signin s = new Signin();

        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria = session.createCriteria(Signin.class).add(Restrictions.eq(Parm.SIGN_EMP_NO, signEmpNo));
            // 处理日期
            long earlyTime = Tools.getTheSameDayZore(time); // 当天零点的毫秒数
//            long laterTime = Tools.getTheSameDayFinal(time);
            long laterTime = earlyTime + Tools.TIME_SIZE_DAY; // 第二天零点的毫秒数
            criteria.add(Restrictions.between(Parm.SIGN_DAY, earlyTime, laterTime));
            s = (Signin) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return s;
    }

    @Override
    public List<Signin> doFindAllSignInByEmpNo(Integer signEmpNo) throws SqlException {
        List<Signin> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Signin.class).add(Restrictions.eq(Parm.SIGN_EMP_NO, signEmpNo));
            criteria.add(Restrictions.gt(Parm.SIGN_IN_TIME,0L));
            System.out.println("criteria:"+criteria.toString());
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
    public List<Signin> doFindAllSignOutByEmpNo(Integer signEmpNo) throws SqlException {
        List<Signin> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Signin.class).add(Restrictions.eq(Parm.SIGN_EMP_NO, signEmpNo));
            criteria.add(Restrictions.gt(Parm.SIGN_OUT_TIME,0L));
            list = criteria.list();
            System.out.println("sign out:" +list.toString());
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
    public List<Signin> doFindMonthSignOutByEmpNo(Integer signEmpNo) throws SqlException {
        List<Signin> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            long startTime = Tools.getMonthFirstDay(); // 获取当月 1号 0点的毫秒数
            long endTime = Tools.getNextMonthFirstDay(); // 获取次月 1号 0点的毫秒数
            System.out.println("signEmpNo:" +signEmpNo);
            Criteria criteria = session.createCriteria(Signin.class).add(Restrictions.eq(Parm.SIGN_EMP_NO, signEmpNo));
            criteria.add(Restrictions.between(Parm.SIGN_IN_TIME,startTime,endTime));
            list = criteria.list();
            System.out.println("sign out:" +list.toString());
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
