package com.ant.DAOImpl;

import com.ant.DAO.EmployeeDAO;
import com.ant.exception.SqlException;
import com.ant.models.Employee;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends BaseDAOImpl<Employee> implements EmployeeDAO {
    @Override
    public List<Employee> findAllForContactByIdAsc() throws SqlException {
        List<Employee> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Employee.class);
            //设置投影集合,但只保存字段内容，不含字段名
//            ProjectionList proList = Projections.projectionList();
//            proList.add(Projections.groupProperty(Parm.EMP_NAME));
//            proList.add(Projections.groupProperty(Parm.EMP_DEPT_NO));
//            proList.add(Projections.groupProperty(Parm.EMP_TEL));
//            proList.add(Projections.groupProperty(Parm.EMP_EMAIL));
//            criteria.setProjection(proList);

            // 升序
            criteria.addOrder(Order.asc(Parm.ID));
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
    public Employee getEmpByEmpName(String empName) throws SqlException {
        Employee emp = new Employee();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq(Parm.EMP_NAME,empName));
            emp = (Employee) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return emp;
    }

    @Override
    public Employee getEmpByEmpNo(Integer empNo) throws SqlException {
        Employee emp = new Employee();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq(Parm.EMP_NO,empNo));
            emp = (Employee) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return emp;
    }

    @Override
    public List<Employee> findAllEmpGuide() throws SqlException {
        List<Employee> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq(Parm.EMP_DEPT_NO,State.DEPT_NO_GUIDE));    // 导游类型
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
