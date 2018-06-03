package com.ant.DAOImpl;

import com.ant.DAO.ScenicDAO;
import com.ant.exception.SqlException;
import com.ant.models.Scenic;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ScenicDAOImpl  extends BaseDAOImpl<Scenic> implements ScenicDAO {
    @Override
    public Scenic doFindOrderByScnNo(Integer scnNo) throws SqlException {
        Scenic scenic = new Scenic();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Scenic.class);
            criteria.add(Restrictions.eq(Parm.SCN_NO, scnNo));
            scenic = (Scenic) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return scenic;
    }
}
