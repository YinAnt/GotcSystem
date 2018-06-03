package com.ant.DAOImpl;

import com.ant.DAO.HotelDAO;
import com.ant.exception.SqlException;
import com.ant.models.Hotel;
import com.ant.param.Parm;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class HotelDAOImpl extends BaseDAOImpl<Hotel> implements HotelDAO {
    @Override
    public Hotel doFindOrderByHtlNo(Integer htlNo) throws SqlException {
        Hotel hotel = new Hotel();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            /**
             * 使用session对象的createCriteria方法创建criteria对象。
             * 使用criteria对象的list方法获取数据集合
             * 使用该对象不需要写hql语句，只需要指定实体类
             */
            Criteria criteria = session.createCriteria(Hotel.class);
            criteria.add(Restrictions.eq(Parm.HTL_NO, htlNo));
            hotel = (Hotel) criteria.uniqueResult();
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return hotel;
    }
}
