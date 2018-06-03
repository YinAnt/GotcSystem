package com.ant.action;

import com.ant.exception.SqlException;
import com.ant.models.Content;
import com.ant.models.Orders;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.server.OrdersServer;
import com.ant.util.Tools;

import javax.tools.Tool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrdersAction extends BaseAction {
    private Long ordNo;         // 订单号
    private String ordUser;     // 用户名
    private String ordAlias;    // 别名
    private String ordTel;      // 联系方式
    private String ordEmail;    // 邮箱
    private Long ordCreateTime; // 创建时间
    private Long ordPayTime;    // 付款时间
    private Long ordStartTime;  // 开始时间
    private Long ordEndTime;    // 结束时间
    private Integer ordAdultNum;// 成人数
    private Integer ordChildNum;// 儿童数
    private String ordMeal;     // 含餐否
    private Float ordBudget;    // 预算
    private Float ordPay;       // 订单实付
    private Integer ordAgent;   // 责任人
    private String ordAgentName;// 责任人姓名
    private Integer ordState;   // 订单状态
    private String ordNoteTag;  // 描述

    private String startTimeStr; // 开始时间
    private String endTimeStr; // 结束时间

    /**
     * 设置订单为已付款状态
     *
     * @return
     */
    public String setOrdPayed() {
        Orders orders = new Orders();
        orders.setOrdNo(ordNo);
        try {
            orders = OrdersServer.setOrdPayed(orders);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 设置订单为已处理状态
     *
     * @return
     */
    public String setOrdHlded() {
        Orders orders = new Orders();
        orders.setOrdNo(ordNo);
        try {
            orders = OrdersServer.setOrdHlded(orders);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 更新所有订单的总价
     *
     * @return
     */
    public String freshAllOrdTotalPay() {
        try {
            List<Orders> list = OrdersServer.freshAllOrdTotalPay();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 为订单设置导游
     *
     * @return
     */
    public String setOrdAgentByOrdNo() {
        Orders orders = new Orders();
        orders.setOrdNo(ordNo);
        orders.setOrdAgent(ordAgent);
        orders.setOrdAgentName(ordAgentName);
        try {
            orders = OrdersServer.setAgentByOrdNo(orders);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据用户名查找名下所有订单记录
     *
     * @return
     */
    public String findAllOrdByUserName() {
        try {
            List<Orders> list = OrdersServer.findOrdByUserName(getOrdUser());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载正在处理的订单
     *
     * @return
     */
    public String findHldOrdAndConts() {
        try {
            Orders orders = OrdersServer.findOrderByOrdNo(getOrdNo());
            List<Content> list = OrdersServer.showAllWaitContentByOrdNo(getOrdNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 根据订单号加载订单详情
     *
     * @return
     */
    public String findNowHldOrders() {
        try {
            Orders orders = OrdersServer.findOrderByOrdNo(getOrdNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有订单
     *
     * @return
     */
    public String showAllOrders() {
        try {
            List<Orders> list = OrdersServer.showAllOrders();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有已处理的订单
     *
     * @return
     */
    public String showAllHldedOrders() {
        try {
            List<Orders> list = OrdersServer.showAllHldedOrders();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载本月所有订单
     *
     * @return
     */
    public String showMonthOrders() {

        try {
            List<Orders> list = OrdersServer.showAllMonthOrders();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载本月所有待处理的订单
     *
     * @return
     */
    public String showMonthWaitOrders() {

        try {
            List<Orders> list = OrdersServer.showAllMonthWaitOrders();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载本月所有已处理的订单
     *
     * @return
     */
    public String showAllMonthHldedOrders() {

        try {
            List<Orders> list = OrdersServer.showAllMonthHldedOrders();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 添加订单
     *
     * @return
     */
    public String addOrders() {
        Orders orders = init();
        try {
            orders = OrdersServer.addOrders(orders);
            getResponseMsgMap().clear();
            getResponseMsgMap().put("orders", orders);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }


    public Orders init() {
        Orders orders = new Orders();

        if (!Tools.isEmpty(startTimeStr) && !Tools.isEmpty(endTimeStr)) {
            System.out.println("startTimeStr:" + startTimeStr);
            System.out.println("endTimeStr:" + endTimeStr);

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = dateFormat.parse(startTimeStr);
                Date endDate = dateFormat.parse(endTimeStr);
                // 验证date
                System.out.println("startDate:" + startDate.toString());
                System.out.println("endDate:" + endDate.toString());
                // 验证日期
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("startDate format:" + dateFormat2.format(startDate));
                System.out.println("endDate format:" + dateFormat2.format(endDate));
                // 毫秒数
                System.out.println("startDate:" + startDate.getTime());
                System.out.println("endDate:" + endDate.getTime());

                ordStartTime = startDate.getTime();
                ordEndTime = endDate.getTime();

            } catch (ParseException e) {
                System.out.println("date error:");
                e.printStackTrace();
            }
//        System.out.println("-----------------------------------------------:");
        }

        orders.setOrdNo(System.currentTimeMillis());
        orders.setOrdCreateTime(System.currentTimeMillis());
        orders.setOrdUser(ordUser);
        orders.setOrdAlias(ordAlias);
        orders.setOrdTel(ordTel);
        orders.setOrdEmail(ordEmail);
        orders.setOrdStartTime(ordStartTime);
        orders.setOrdEndTime(ordEndTime);
        orders.setOrdAdultNum(ordAdultNum);
        orders.setOrdChildNum(ordChildNum);
        orders.setOrdMeal(ordMeal);
        orders.setOrdBudget(ordBudget);
        orders.setOrdState(State.ORD_STATE_WAIT);
        orders.setOrdNoteTag(ordNoteTag);   // 描述字段
        System.out.println("init:" + orders.toString());
        return orders;
    }

    public Long getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(Long ordNo) {
        this.ordNo = ordNo;
    }

    public String getOrdUser() {
        return ordUser;
    }

    public void setOrdUser(String ordUser) {
        this.ordUser = ordUser;
    }

    public String getOrdAlias() {
        return ordAlias;
    }

    public void setOrdAlias(String ordAlias) {
        this.ordAlias = ordAlias;
    }

    public String getOrdTel() {
        return ordTel;
    }

    public void setOrdTel(String ordTel) {
        this.ordTel = ordTel;
    }

    public String getOrdEmail() {
        return ordEmail;
    }

    public void setOrdEmail(String ordEmail) {
        this.ordEmail = ordEmail;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public Long getOrdCreateTime() {
        return ordCreateTime;
    }

    public void setOrdCreateTime(Long ordCreateTime) {
        this.ordCreateTime = ordCreateTime;
    }

    public Long getOrdPayTime() {
        return ordPayTime;
    }

    public void setOrdPayTime(Long ordPayTime) {
        this.ordPayTime = ordPayTime;
    }

    public Long getOrdStartTime() {
        return ordStartTime;
    }

    public void setOrdStartTime(Long ordStartTime) {
        this.ordStartTime = ordStartTime;
    }

    public Long getOrdEndTime() {
        return ordEndTime;
    }

    public void setOrdEndTime(Long ordEndTime) {
        this.ordEndTime = ordEndTime;
    }

    public Integer getOrdAdultNum() {
        return ordAdultNum;
    }

    public void setOrdAdultNum(Integer ordAdultNum) {
        this.ordAdultNum = ordAdultNum;
    }

    public Integer getOrdChildNum() {
        return ordChildNum;
    }

    public void setOrdChildNum(Integer ordChildNum) {
        this.ordChildNum = ordChildNum;
    }

    public String getOrdMeal() {
        return ordMeal;
    }

    public void setOrdMeal(String ordMeal) {
        this.ordMeal = ordMeal;
    }

    public Float getOrdBudget() {
        return ordBudget;
    }

    public void setOrdBudget(Float ordBudget) {
        this.ordBudget = ordBudget;
    }

    public Float getOrdPay() {
        return ordPay;
    }

    public void setOrdPay(Float ordPay) {
        this.ordPay = ordPay;
    }

    public Integer getOrdAgent() {
        return ordAgent;
    }

    public void setOrdAgent(Integer ordAgent) {
        this.ordAgent = ordAgent;
    }

    public String getOrdAgentName() {
        return ordAgentName;
    }

    public void setOrdAgentName(String ordAgentName) {
        this.ordAgentName = ordAgentName;
    }

    public Integer getOrdState() {
        return ordState;
    }

    public void setOrdState(Integer ordState) {
        this.ordState = ordState;
    }

    public String getOrdNoteTag() {
        return ordNoteTag;
    }

    public void setOrdNoteTag(String ordNoteTag) {
        this.ordNoteTag = ordNoteTag;
    }
}
