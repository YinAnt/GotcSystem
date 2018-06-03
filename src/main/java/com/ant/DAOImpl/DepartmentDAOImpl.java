package com.ant.DAOImpl;

import com.ant.DAO.DepartmentDAO;
import com.ant.exception.SqlException;
import com.ant.models.Department;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DepartmentDAOImpl extends BaseDAOImpl<Department> implements DepartmentDAO {

    @Override
    public Department getDeptByDeptNo(Integer deptNo) throws SqlException {
        Department dept = null;
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 这里使用的应该是Bean类（如UserName）对应的名字而非数据库中的字段名
            Criteria criteria = session.createCriteria(Department.class).add(Restrictions.eq(Parm.DEPT_NO, deptNo));
            dept = (Department) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return dept;
    }
}
