package com.ant.DAOImpl;

import com.ant.DAO.VehicleDAO;
import com.ant.exception.SqlException;
import com.ant.models.Vehicle;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class VehicleDAOImpl extends BaseDAOImpl<Vehicle> implements VehicleDAO {
    @Override
    public Vehicle findMinVehicleByNum(Integer num) throws SqlException {
        Vehicle vehicle = null;
        Session session = HibernateUtil.getSession(); // 生成session实例
        Transaction tx = session.beginTransaction(); // 创建transaction实例
        try {
            // 这里使用的应该是Bean类（如UserName）对应的名字而非数据库中的字段名
            Criteria criteria = session.createCriteria(Vehicle.class).addOrder(Order.asc(Parm.VHC_SEAT));   // 座位数升序
            criteria.add(Restrictions.eq(Parm.VHC_STATE,State.VHC_STATE_FREE)); // 空闲中
            List<Vehicle> list = criteria.list();
            for (Vehicle v : list) {
                if (v.getVhcSeat() >= num){
                    vehicle = v;
                }
            }
            tx.commit(); // 提交事务;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); // 回滚事务
            throw new SqlException("sql execute fail !");
        } finally {
            session.close();
        }
        return vehicle;
    }
}
