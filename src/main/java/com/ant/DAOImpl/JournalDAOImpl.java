package com.ant.DAOImpl;

import com.ant.DAO.JournalDAO;
import com.ant.exception.SqlException;
import com.ant.models.Journal;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class JournalDAOImpl extends BaseDAOImpl<Journal> implements JournalDAO {
    /**
     * 根据员工号返回请假记录
     * @param empNo
     * @return
     * @throws SqlException
     */
    @Override
    public List<Journal> doFindJournalByEmpNo(Integer empNo) throws SqlException {
        List<Journal> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Journal.class).add(Restrictions.eq(Parm.JNL_EMP_NO, empNo));
            list = criteria.list();
            System.out.println("journal:" +list.toString());
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

    /**
     * 根据员工名返回请假记录
     * @param empName
     * @return
     * @throws SqlException
     */
    @Override
    public List<Journal> doFindJournalByEmpName(String empName) throws SqlException {
        List<Journal> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Journal.class).add(Restrictions.eq(Parm.JNL_EMP_NAME, empName));
            list = criteria.list();
            System.out.println("journal:" +list.toString());
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
