package com.ant.DAOImpl;

import com.ant.DAO.UserDAO;
import com.ant.exception.SqlException;
import com.ant.models.User;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    public User getUserByEmail(String email) throws SqlException {
        User user = null;
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 这里使用的应该是Bean类（如UserName）对应的名字而非数据库中的字段名
            Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(Parm.FILE_NAME, email));
            user = (User) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User getUserByName(String name) throws SqlException {
        User user = null;
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 这里使用的应该是Bean类（如UserName）对应的名字而非数据库中的字段名
            Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(Parm.USER_NAME, name));
            user = (User) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User getUserByNameAndPsw(User user) throws SqlException {
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 这里使用的应该是Bean类（如UserName）对应的名字而非数据库中的字段名
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq(Parm.USER_NAME, user.getUserName()));
            criteria.add(Restrictions.eq(Parm.USER_PASSWORD, user.getUserPassword()));
            user = (User) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return user;
    }


    /**
     * 重置密码
     *
     * @param user
     * @param rePassword
     * @return
     * @throws SqlException
     */
    public User updatePasswordById(User user, String rePassword) throws SqlException {
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 使用HQL，更新
            Query q = session.createQuery("update User u set u.userPassword  = :userPassword  where u.id = :id");
            q.setInteger("id", user.getId());
            q.setString("userPassword", rePassword);
            q.executeUpdate();
            // 查询
            Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(Parm.ID, user.getId()));
            user = (User) criteria.uniqueResult();
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User changePersonInfoButPsw(User user) throws SqlException {
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 使用HQL，更新
            Query q = session.createQuery("update User u set u.userAlias  = :userAlias,u.userEmail  = :userEmail, u.userTel  = :userTel where u.id = :id");
            q.setInteger("id", user.getId());
            q.setString("userAlias", user.getUserAlias());
            q.setString("userEmail", user.getUserEmail());
            q.setString("userTel", user.getUserTel());
            q.executeUpdate();
            // 查询
            Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(Parm.ID, user.getId()));
            user = (User) criteria.uniqueResult();
            System.out.println("IMPL:" + user.toString());
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return user;
    }

}
