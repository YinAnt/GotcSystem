package com.ant.server;

import com.ant.DAO.OrdersDAO;
import com.ant.DAO.ScenicDAO;
import com.ant.DAO.VehicleDAO;
import com.ant.DAOImpl.*;
import com.ant.exception.SqlException;
import com.ant.models.*;
import com.ant.param.State;
import com.ant.util.Tools;
import com.sun.corba.se.impl.orb.ORBDataParserImpl;
import com.sun.corba.se.impl.orb.ORBImpl;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class OrdersServer {
    /**
     * 加载所有景区列表
     *
     * @return
     * @throws SqlException
     */
    public static List<Scenic> showAllScenic() throws SqlException {
        ScenicDAOImpl scenicDAO = new ScenicDAOImpl();
        List<Scenic> list = scenicDAO.doFindAll();
        return list;
    }

    /**
     * 添加景区
     *
     * @return
     * @throws SqlException
     */
    public static Scenic addScenic(Scenic scenic) throws SqlException {
        ScenicDAOImpl scenicDAO = new ScenicDAOImpl();
        scenicDAO.doSave(scenic);
        return scenic;
    }

    /**
     * 加载所有酒店列表
     *
     * @return
     * @throws SqlException
     */
    public static List<Hotel> showAllHotel() throws SqlException {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        List<Hotel> list = hotelDAO.doFindAll();
        return list;
    }


    /**
     * 添加酒店
     *
     * @return
     * @throws SqlException
     */
    public static Hotel addHotel(Hotel hotel) throws SqlException {
        HotelDAOImpl hotelDAO = new HotelDAOImpl();
        hotelDAO.doSave(hotel);
        return hotel;
    }


    /**
     * 加载所有车辆列表
     *
     * @return
     * @throws SqlException
     */
    public static List<Vehicle> showAllVehicle() throws SqlException {
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        List<Vehicle> list = vehicleDAO.doFindAll();
        return list;
    }

    /**
     * 添加车辆
     *
     * @return
     * @throws SqlException
     */
    public static Vehicle addVehicle(Vehicle vehicle) throws SqlException {
        VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();
        vehicleDAO.doSave(vehicle);
        return vehicle;
    }

    /**
     * 添加订单
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders addOrders(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        ordersDAO.doSave(orders);
        return orders;
    }


    /**
     * 加载所有订单（预计出行时间 时间逆序）
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindAllDesc();
        return list;
    }

    /**
     * 加载本月所有订单（预计出行时间 时间逆序）
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllMonthOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindWaitAllDesc();
        return list;
    }

    /**
     * 加载本月所有待处理的订单（ 创建时间 和 预计出行时间 时间逆序）
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllMonthWaitOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindMonthWaitAllDesc();
        return list;
    }

    /**
     * 加载本月所有已处理的订单（ 创建时间 和 预计出行时间 时间逆序）
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllMonthHldedOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindMonthHldedAllDesc();
        return list;
    }

    /**
     * 加载所有 待处理 订单
     * 订单状态：待处理，已处理（待付款），已结束
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllWaitOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindWaitAllDesc();
        return list;
    }


    /**
     * 加载所有 已处理 订单
     * 订单状态：待处理，已处理（待付款），已结束
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllHldedOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindHldedDesc();
        return list;
    }

    /**
     * 加载所有 已付款 订单
     * 订单状态：待处理，已处理（待付款），已付款
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> showAllPayedOrders() throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> list = ordersDAO.doFindPayedDesc();
        return list;
    }

    /**
     * 根据订单号查询订单
     *
     * @param ordNo
     * @return
     * @throws SqlException
     */
    public static Orders findOrderByOrdNo(Long ordNo) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        Orders orders = ordersDAO.doFindOrderByOrdNo(ordNo);
        return orders;
    }

    /**
     * 查询用户名下所有订单
     *
     * @return
     * @throws SqlException
     */
    public static List<Orders> findOrdByUserName(String userName) throws SqlException {
        List<Orders> list = new ArrayList<>();
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        if (!Tools.isEmpty(userName)) {
            list = ordersDAO.doFindOrdByUserNameDesc(userName);
        }
        return list;
    }


    /**
     * 设置订单评价
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders addOrdComment(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        orders = ordersDAO.addOrdComment(orders.getOrdNo(), orders.getOrdComment());
        return orders;
    }

    /**
     * 设置订单评价后的客服回复
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders addOrdReply(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        orders = ordersDAO.addOrdReply(orders.getOrdNo(), orders.getOrdReply());
        return orders;
    }

    /**
     * 设置导游
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders setAgentByOrdNo(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        // 匹配导游信息
        if (orders.getOrdAgent() == null) {
            EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
            Employee emp = employeeDAO.getEmpByEmpName(orders.getOrdAgentName());
            orders.setOrdAgent(emp.getEmpNo());
        }
        orders = ordersDAO.setOrdAgentByOrdNo(orders.getOrdNo(), orders.getOrdAgent(), orders.getOrdAgentName());
        return orders;
    }

    /**
     * 设置订单为已处理
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders setOrdHlded(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        orders = ordersDAO.setOrdHlded(orders.getOrdNo());
        return orders;
    }

    /**
     * 设置订单为已付款
     *
     * @param orders
     * @return
     * @throws SqlException
     */
    public static Orders setOrdPayed(Orders orders) throws SqlException {
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        orders = ordersDAO.setOrdPayed(orders.getOrdNo());
        return orders;
    }

    /**
     * 更新所有订单的总价
     *
     * @param
     * @return
     * @throws SqlException
     */
    public static List<Orders> freshAllOrdTotalPay() throws SqlException {
        // 查询所有订单
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        List<Orders> ordList = ordersDAO.doFindAll();
        if (ordList != null) {
            for (Orders o : ordList) {
                // 根据订单查所有订单内容
                ContentDAOImpl contentDAO = new ContentDAOImpl();
                List<Content> contList = contentDAO.doFindAllByOrdNo(o.getOrdNo());
                float sum = 0;
                for (Content c : contList) {
                    if (c.getContFare() != null) {
                        sum += c.getContFare();
                    }
                }
                // 为订单更新总价
                ordersDAO.freshTotalPay(o.getOrdNo(), sum);
            }
        }
        // 重新获取订单
        ordList = ordersDAO.doFindAll();
        return ordList;
    }

    /**
     * 更新某个订单的总价
     *
     * @param
     * @return
     * @throws SqlException
     */
    public static Orders freshOrdTotalPayByOrdNo(Orders orders) throws SqlException {
        // 查询所有订单
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        // 根据订单查所有订单内容
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> contList = contentDAO.doFindAllByOrdNo(orders.getOrdNo());
        float sum = 0;
        for (Content c : contList) {
            if (c.getContFare() != null) {
                sum += c.getContFare();
            }
        }
        // 为订单更新总价
        ordersDAO.freshTotalPay(orders.getOrdNo(), sum);
        // 重新获取订单
        orders = ordersDAO.doFindOrderByOrdNo(orders.getOrdNo());
        return orders;
    }

    /**
     * 更新某个订单的总价
     *
     * @param ordNo
     * @return
     * @throws SqlException
     */
    public static Orders freshTotalPay(Long ordNo) throws SqlException {
        Orders orders = new Orders();
        // 根据订单查所有订单内容
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllByOrdNo(ordNo);
        float sum = 0;
        for (Content c : list) {
            if (c.getContFare() != null) {
                sum += c.getContFare();
            }
        }
        // 为订单更新总价
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        orders = ordersDAO.freshTotalPay(ordNo, sum);
        return orders;
    }

    /**
     * 添加订单内容
     *
     * @param content
     * @return
     * @throws SqlException
     */
    public static Content addContent(Content content) throws SqlException {

        if (content.getContType() == State.CONT_TYPE_SCENIC) {
            ScenicDAOImpl scenicDAO = new ScenicDAOImpl();
            Scenic scenic = scenicDAO.doFindOrderByScnNo(content.getContScnNo());
            content.setContScnPrice(scenic.getScnPrice());
            // 匹配订单信息
            Orders orders = new Orders();
            OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
            orders = ordersDAO.doFindOrderByOrdNo(content.getContOrdNo());
            content.setContScnNumAdult(orders.getOrdAdultNum());
            content.setContScnNumChild(orders.getOrdChildNum());
            content.setContDetails(scenic.getScnNoteTag());
            // 设置景区相关信息
            content.setContScnName(scenic.getScnName());
            content.setContScnPrice(scenic.getScnPrice());
            content.setContNoteTag(scenic.getScnImgPath()); // 图片路径
            // 总价
            float totlePrice = 0;
            totlePrice = (content.getContScnNumAdult() + content.getContScnNumChild()) * content.getContScnPrice();
            // 人数备注
            int num = 0;
            if (content.getContScnNumAdult() != null) {
                num += content.getContScnNumAdult();
            }
            if (content.getContScnNumChild() != null) {
                num += content.getContScnNumChild();
            }
            content.setContName(content.getContScnName() + "门票 *" + num);   // 品类名称：景区名+"门票 *"+人数，例如 象山公园门票 *2
            content.setContFare(totlePrice);
        } else if (content.getContType() == State.CONT_TYPE_HOTEL) {
            Hotel hotel = new Hotel();
            HotelDAOImpl hotelDAO = new HotelDAOImpl();
            hotel = hotelDAO.doFindOrderByHtlNo(content.getContHtlNo());
            // 匹配酒店信息
            content.setContHtlName(hotel.getHtlName());
            content.setContHtlRoom(hotel.getHtlRoom());
            // 设置总价
            content.setContFare(hotel.getHtlPrice());
            // 总信息
            content.setContName(hotel.getHtlName() + "," + hotel.getHtlRoom());    // 品类名称： 酒店名 + 房型
            content.setContDetails(hotel.getHtlNoteTag());
        } else if (content.getContType() == State.CONT_TYPE_VEHICLE) {
            // 根据订单号查使用时间
            Orders orders = new Orders();
            OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
            orders = ordersDAO.doFindOrderByOrdNo(content.getContOrdNo());
            // 设置使用时间
            content.setContVhcStartTime(orders.getOrdStartTime());
            content.setContVhcEndTime(orders.getOrdEndTime());
            float days = Tools.differentDaysByMillisecond(orders.getOrdStartTime(), orders.getOrdEndTime());
            // 设置用车人数
            int num = orders.getOrdAdultNum() + orders.getOrdChildNum();
            content.setContVhcSeat(num);
            // 根据人数假定 用车价格
            float fare = num * days * 50;   // 一人一天50
            content.setContFare(fare);
        }

        ContentDAOImpl contentDAO = new ContentDAOImpl();
        contentDAO.doSave(content);
        // 添加订单内容后，更新订单总价
        freshTotalPay(content.getContOrdNo());
        return content;
    }


    /**
     * 加载所有的订单内容
     *
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllContent() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAll();
        return list;
    }

    /**
     * 加载所有 待处理 的订单内容
     *
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllWaitContent() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllWait();
        return list;
    }

    /**
     * 根据订单号加载所有的订单内容
     *
     * @param contOrdNo
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllContentByOrdNo(Long contOrdNo) throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllByOrdNo(contOrdNo);
        return list;
    }

    /**
     * 根据订单号加载所有 待处理 的订单内容
     *
     * @param contOrdNo
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllWaitContentByOrdNo(Long contOrdNo) throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllWaitByOrdNo(contOrdNo);
        return list;
    }

    /**
     * 根据订单号加载所有 待处理 的景区 订单内容
     * 分组：日期 + 景区名
     *
     * @param
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllWaitContentForDateAndScnName() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllWaitForScn();
        return list;
    }

    /**
     * 根据 景区名 和 日期，设置订单内容为已处理状态
     *
     * @param content
     * @throws SqlException
     */
    public static void handleScnCont(Content content) throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        contentDAO.doChangeStateForScn(content.getContScnName(), content.getContScnDate());
    }


    /**
     * 根据 酒店名、房型、入住日期、离店日期，设置订单内容为已处理状态
     *
     * @param content
     * @throws SqlException
     */
    public static void handleHtlCont(Content content) throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        contentDAO.doChangeStateForHtl(content);
    }

    /**
     * 设置 订单内容 车辆 为已处理
     *
     * @param content
     * @throws SqlException
     */
    public static void handleVhcCont(Content content) throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        contentDAO.doChangeStateForVhc(content);
    }

    /**
     * 根据订单号加载所有 待处理 的酒店 订单内容
     * 分组：日期 + 景区名
     *
     * @param
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllWaitContentForDateAndHldName() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllWaitForHtl();
        return list;
    }

    /**
     * 根据订单号加载所有 待处理 的车辆 订单内容
     * 分组：日期 + 景区名
     *
     * @param
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllWaitContentForVhc() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.doFindAllWaitForVhc();
        return list;
    }

    /**
     * 加载所有已处理的订单内容
     *
     * @return
     * @throws SqlException
     */
    public static List<Content> showAllFinishContent() throws SqlException {
        ContentDAOImpl contentDAO = new ContentDAOImpl();
        List<Content> list = contentDAO.showAllFinishContent();
        return list;
    }

}
