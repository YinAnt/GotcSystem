package com.ant.DAOImpl;

import com.ant.DAO.AnnounceDAO;
import com.ant.exception.SqlException;
import com.ant.models.Announce;
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

public class AnnounceDAOImpl extends BaseDAOImpl<Announce> implements AnnounceDAO {
    @Override
    public List<Announce> findAllForTimeDesc() throws SqlException {
        List<Announce> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria =session.createCriteria(Announce.class);
            // 降序
            criteria.addOrder(Order.desc(Parm.ID));
            list = criteria.list();
            System.out.println("list:"+list.toString());
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
    public List<Announce> findAllGuideForTimeDesc() throws SqlException {
        List<Announce> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria =session.createCriteria(Announce.class);
            criteria.add(Restrictions.eq(Parm.ANC_TYPE,State.ANC_TYPE_GUIDE));
            // 降序
            criteria.addOrder(Order.desc(Parm.ID));
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
    public Announce findLastestAnnounceButGuide() throws SqlException {
        Announce announce = new Announce();
        List<Announce> list = new ArrayList<>();
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            Criteria criteria =session.createCriteria(Announce.class);
            criteria.add(Restrictions.ne(Parm.ANC_TYPE, State.ANC_TYPE_GUIDE));
            // 降序
            criteria.addOrder(Order.desc(Parm.ID));
            list = criteria.list();
            if (list!=null && !list.isEmpty()){
                announce = list.get(0);
            }
            tx.commit(); // 提交事务
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return announce;
    }
}
