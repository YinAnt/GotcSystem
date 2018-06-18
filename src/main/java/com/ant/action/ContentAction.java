package com.ant.action;


import com.ant.exception.SqlException;
import com.ant.models.Content;
import com.ant.param.Parm;
import com.ant.param.State;
import com.ant.server.OrdersServer;
import com.ant.util.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContentAction extends BaseAction {
    private Long contOrdNo;             // 订单号
    private String contName;            // 品类名
    private Double contFare;            // 品类价格
    private String contDetails;         // 描述
    private Integer contType;           // 类型： 景区，酒店，车辆
    private Long contNo; // 流水号
    private Integer contState;//订单处理状态

    private Integer contScnNo;          // 景区号
    private String contScnName;         // 景区名
    private Integer contScnNumAdult;    // 成人数量
    private Integer contScnNumChild;    // 儿童数量
    private Float contScnPrice;         // 售价单价
    private Long contScnDate;           // 游览日期
    private String contScnStartTime;    // 开始时间
    private String contScnEndTime;      // 结束时间

    private Integer contHtlNo;          // 酒店编号
    private String contHtlName;         // 酒店名
    private String contHtlRoom;         // 房型
    private Long contHtlCheckIn;        // 入住日期
    private Long contHtlCheckOut;       // 离店日期
    private Integer contHtlDays;        // 入住天数

    private Integer contVhcNo;          // 车辆编号
    private String contVhcNum;          // 车牌号
    private String contVhcModel;        // 车型
    private Integer contVhcSeat;        // 座位数
    private Long contVhcStartTime;      // 车辆使用开始时间
    private Long contVhcEndTime;        // 车辆使用结束时间

    private Long contTimeTag;   // 处理时间
    private String contNoteTag;
    private Long contTimeSort;  // 时间排序用

    private String contScnDateStr;      // 景区游览日期Str
    private String contHtlCheckInStr;   // 酒店入住时间Str
    private String contHtlCheckOutStr;  // 酒店离店时间Str


    /**
     * 设置订单状态为已处理
     *
     * @return
     */
    public String changeContState() {

        try {
            if (contType == State.CONT_TYPE_SCENIC) {
                // 景区，一次性可购买所有，不以流水号为区分
                // 处理时间
                if (contScnDateStr != null) {
                    try {
                        // 这里是特别的，在JSP页面日期格式已经处理过，注意JSP页面对应的日期格式
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = dateFormat.parse(contScnDateStr);
                        contScnDate = date.getTime();
                    } catch (ParseException e) {
                        System.out.println("date error:");
                        e.printStackTrace();
                    }
                }
                Content content = new Content();
                content.setContScnDate(contScnDate);
                content.setContScnName(contScnName);
                OrdersServer.handleScnCont(content);
            } else if (contType == State.CONT_TYPE_HOTEL) {
                // 酒店，一次性预定所有，不以流水号为区分
                if (contHtlCheckInStr != null && contHtlCheckOutStr != null) {
                    try {
                        // 这里是特别的，在JSP页面日期格式已经处理过，注意JSP页面对应的日期格式
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date startDate = dateFormat.parse(contHtlCheckInStr);
                        Date endDate = dateFormat.parse(contHtlCheckOutStr);
                        contHtlCheckIn = startDate.getTime();
                        contHtlCheckOut = endDate.getTime();
                    } catch (ParseException e) {
                        System.out.println("date error:");
                        e.printStackTrace();
                    }

                    Content content = new Content();
                    content.setContHtlCheckIn(contHtlCheckIn);
                    content.setContHtlCheckOut(contHtlCheckOut);
                    content.setContHtlRoom(contHtlRoom);
                    content.setContHtlName(contHtlName);
                    OrdersServer.handleHtlCont(content);
                }
            } else if (contType == State.CONT_TYPE_VEHICLE) {
                // 车辆，以流水号 + 订单号区分
                Content content = new Content();
                content.setContNo(contNo);
                content.setContOrdNo(contOrdNo);
                OrdersServer.handleVhcCont(content);
            }
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有  已处理（订购）的订单内容
     *
     * @return
     */
    public String showFinishCont() {
        try {
            List<Content> list = OrdersServer.showAllFinishContent();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有待处理（订购）的订单内容
     *
     * @return
     */
    public String showWaitCont() {
        try {
            List<Content> list = null;
            if (contType == State.CONT_TYPE_SCENIC) {
                list = OrdersServer.showAllWaitContentForDateAndScnName();
            } else if (contType == State.CONT_TYPE_HOTEL) {
                list = OrdersServer.showAllWaitContentForDateAndHldName();
            } else if (contType == State.CONT_TYPE_VEHICLE) {
                list = OrdersServer.showAllWaitContentForVhc();
            }
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载该订单下所有待处理（订购）的订单内容
     *
     * @return
     */
    public String showWaitContByOrdNo() {
        try {
            List<Content> list = OrdersServer.showAllWaitContentByOrdNo(getContOrdNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载所有的订单内容
     *
     * @return
     */
    public String showAllContent() {
        try {
            List<Content> list = OrdersServer.showAllContent();
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 加载某订单下的所有订单内容
     *
     * @return
     */
    public String showContentByOrdNo() {
        try {
            List<Content> list = OrdersServer.showAllContentByOrdNo(getContOrdNo());
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", list);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    /**
     * 为一个订单添加订单的内容（服务内容）
     *
     * @return
     */
    public String addContent() {

        Content content = null;
        try {
            if (contType == State.CONT_TYPE_SCENIC) {
                content = initScenic();
                content = OrdersServer.addContent(content);
            } else if (contType == State.CONT_TYPE_HOTEL) {
                content = initHotel();
                content = OrdersServer.addContent(content);
            } else if (contType == State.CONT_TYPE_VEHICLE) {
                content = initVehicle();
                content = OrdersServer.addContent(content);
            }
            getResponseMsgMap().clear();
            getResponseMsgMap().put("content", content);
        } catch (SqlException e) {
            e.printStackTrace();
            getResponseMsgMap().clear();
            getResponseMsgMap().put(Parm.MSG_MEAN, e.getMessage());
        }
        return SUCCESS;
    }

    private Content initVehicle() {
        System.out.println("initVehicle");
        Content content = new Content();
        content.setContNo(System.currentTimeMillis());  // 流水号
        content.setContState(State.CONT_STATE_WAIT);    // 待处理
        content.setContOrdNo(contOrdNo);    // 订单号
        content.setContName("用车");
        content.setContType(State.CONT_TYPE_VEHICLE);   // 品类类型
        System.out.println("initHotel:" + content.toString());
        return content;
    }

    private Content initHotel() {
        System.out.println("initHotel");
        Content content = new Content();
        content.setContNo(System.currentTimeMillis());  // 流水号
        content.setContState(State.CONT_STATE_WAIT);    // 待处理
        content.setContType(State.CONT_TYPE_HOTEL);  // 品类类型
        content.setContOrdNo(contOrdNo);    // 订单号
        content.setContName(contHtlName + "," + contHtlRoom);   // 品类名称：酒店名+房型
        // 未设置价格
        content.setContDetails(contDetails);


        if (contHtlCheckInStr != null && contHtlCheckOutStr != null) {
            System.out.println("contHtlCheckInStr:" + contHtlCheckInStr);
            System.out.println("endTimeStr:" + contHtlCheckOutStr);

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = dateFormat.parse(contHtlCheckInStr);
                Date endDate = dateFormat.parse(contHtlCheckOutStr);
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

                contHtlCheckIn = startDate.getTime();
                contHtlCheckOut = endDate.getTime();

            } catch (ParseException e) {
                System.out.println("date error:");
                e.printStackTrace();
            }
//        System.out.println("-----------------------------------------------:");
        }

        content.setContHtlNo(contHtlNo);
        content.setContHtlName(contHtlName);
        content.setContHtlRoom(contHtlRoom);
        content.setContHtlCheckIn(contHtlCheckIn);
        content.setContHtlCheckOut(contHtlCheckOut);
        content.setContTimeSort(contHtlCheckIn); // 行程先后顺序
        if (contHtlCheckIn != null && contHtlCheckOut != null) {
            float days = Tools.differentDaysByMillisecond(contHtlCheckIn, contHtlCheckOut);
            content.setContHtlDays((int) (days)); // 入住天数
        }
        System.out.println("initHotel:" + content.toString());
        return content;
    }

    private Content initScenic() {
        System.out.println("initScenic");
        Content content = new Content();

        if (contScnDateStr != null) {
            System.out.println("contScnDateStr:" + contScnDateStr);

            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = dateFormat.parse(contScnDateStr);
                // 验证date
                System.out.println("startDate:" + startDate.toString());
                // 验证日期
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println("startDate format:" + dateFormat2.format(startDate));
                // 毫秒数
                System.out.println("startDate:" + startDate.getTime());

                contScnDate = startDate.getTime();  // 保存到游览景点的日期

                // HH:mm
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date startTimeDate = timeFormat.parse(contScnStartTime); // 行程开始时间
                System.out.println("startTimeDate:" + startTimeDate.toString());
                System.out.println("timeFormat format:" + dateFormat2.format(startTimeDate));
                System.out.println("startTimeDate long:" + startTimeDate.getTime());

                //两个与运算
                contTimeSort = startDate.getTime() + ((startTimeDate.getTime() + 8 * 60 * 60 * 1000) % (24 * 60 * 60 * 1000));  // 游览景点的日期+时间，保存到备用字段contTimeTag
                System.out.println("timeFormat format:" + dateFormat2.format(contTimeSort));

            } catch (ParseException e) {
                System.out.println("date error:");
                e.printStackTrace();
            }
//        System.out.println("-----------------------------------------------:");
        }

        content.setContOrdNo(contOrdNo);    // 订单号
        content.setContDetails(contDetails);
        content.setContType(State.CONT_TYPE_SCENIC);  // 品类类型
        content.setContNo(System.currentTimeMillis());  // 流水号
        content.setContState(State.CONT_STATE_WAIT);    // 待处理

        content.setContScnNo(contScnNo);
        content.setContScnName(contScnName);
        content.setContScnDate(contScnDate);
        content.setContScnNumAdult(contScnNumAdult);
        content.setContScnNumChild(contScnNumChild);
        content.setContScnPrice(contScnPrice);  // 单价
        content.setContScnStartTime(contScnStartTime);
        content.setContScnEndTime(contScnEndTime);
        content.setContTimeSort(contTimeSort);
        System.out.println("initScenic:" + content.toString());
        return content;
    }


    public Long getContOrdNo() {
        return contOrdNo;
    }

    public void setContOrdNo(Long contOrdNo) {
        this.contOrdNo = contOrdNo;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public Double getContFare() {
        return contFare;
    }

    public void setContFare(Double contFare) {
        this.contFare = contFare;
    }

    public String getContDetails() {
        return contDetails;
    }

    public void setContDetails(String contDetails) {
        this.contDetails = contDetails;
    }

    public Integer getContType() {
        return contType;
    }

    public void setContType(Integer contType) {
        this.contType = contType;
    }

    public Integer getContScnNo() {
        return contScnNo;
    }

    public void setContScnNo(Integer contScnNo) {
        this.contScnNo = contScnNo;
    }

    public String getContScnName() {
        return contScnName;
    }

    public void setContScnName(String contScnName) {
        this.contScnName = contScnName;
    }

    public Integer getContScnNumAdult() {
        return contScnNumAdult;
    }

    public void setContScnNumAdult(Integer contScnNumAdult) {
        this.contScnNumAdult = contScnNumAdult;
    }

    public Float getContScnPrice() {
        return contScnPrice;
    }

    public void setContScnPrice(Float contScnPrice) {
        this.contScnPrice = contScnPrice;
    }

    public Integer getContScnNumChild() {
        return contScnNumChild;
    }

    public void setContScnNumChild(Integer contScnNumChild) {
        this.contScnNumChild = contScnNumChild;
    }


    public Long getContScnDate() {
        return contScnDate;
    }

    public void setContScnDate(Long contScnDate) {
        this.contScnDate = contScnDate;
    }

    public String getContScnStartTime() {
        return contScnStartTime;
    }

    public void setContScnStartTime(String contScnStartTime) {
        this.contScnStartTime = contScnStartTime;
    }

    public String getContScnEndTime() {
        return contScnEndTime;
    }

    public void setContScnEndTime(String contScnEndTime) {
        this.contScnEndTime = contScnEndTime;
    }

    public Integer getContHtlNo() {
        return contHtlNo;
    }

    public void setContHtlNo(Integer contHtlNo) {
        this.contHtlNo = contHtlNo;
    }

    public String getContHtlName() {
        return contHtlName;
    }

    public void setContHtlName(String contHtlName) {
        this.contHtlName = contHtlName;
    }

    public String getContHtlRoom() {
        return contHtlRoom;
    }

    public void setContHtlRoom(String contHtlRoom) {
        this.contHtlRoom = contHtlRoom;
    }

    public Long getContHtlCheckIn() {
        return contHtlCheckIn;
    }

    public void setContHtlCheckIn(Long contHtlCheckIn) {
        this.contHtlCheckIn = contHtlCheckIn;
    }

    public Long getContHtlCheckOut() {
        return contHtlCheckOut;
    }

    public void setContHtlCheckOut(Long contHtlCheckOut) {
        this.contHtlCheckOut = contHtlCheckOut;
    }

    public Integer getContHtlDays() {
        return contHtlDays;
    }

    public void setContHtlDays(Integer contHtlDays) {
        this.contHtlDays = contHtlDays;
    }

    public Integer getContVhcNo() {
        return contVhcNo;
    }

    public void setContVhcNo(Integer contVhcNo) {
        this.contVhcNo = contVhcNo;
    }

    public Long getContVhcEndTime() {
        return contVhcEndTime;
    }

    public void setContVhcEndTime(Long contVhcEndTime) {
        this.contVhcEndTime = contVhcEndTime;
    }

    public String getContVhcNum() {
        return contVhcNum;
    }

    public void setContVhcNum(String contVhcNum) {
        this.contVhcNum = contVhcNum;
    }

    public String getContVhcModel() {
        return contVhcModel;
    }

    public void setContVhcModel(String contVhcModel) {
        this.contVhcModel = contVhcModel;
    }

    public Integer getContVhcSeat() {
        return contVhcSeat;
    }

    public void setContVhcSeat(Integer contVhcSeat) {
        this.contVhcSeat = contVhcSeat;
    }

    public String getContScnDateStr() {
        return contScnDateStr;
    }

    public void setContScnDateStr(String contScnDateStr) {
        this.contScnDateStr = contScnDateStr;
    }

    public String getContHtlCheckInStr() {
        return contHtlCheckInStr;
    }

    public void setContHtlCheckInStr(String contHtlCheckInStr) {
        this.contHtlCheckInStr = contHtlCheckInStr;
    }

    public String getContHtlCheckOutStr() {
        return contHtlCheckOutStr;
    }

    public void setContHtlCheckOutStr(String contHtlCheckOutStr) {
        this.contHtlCheckOutStr = contHtlCheckOutStr;
    }

    public Long getContNo() {
        return contNo;
    }

    public void setContNo(Long contNo) {
        this.contNo = contNo;
    }

    public Integer getContState() {
        return contState;
    }

    public void setContState(Integer contState) {
        this.contState = contState;
    }

    public Long getContTimeTag() {
        return contTimeTag;
    }

    public void setContTimeTag(Long contTimeTag) {
        this.contTimeTag = contTimeTag;
    }

    public String getContNoteTag() {
        return contNoteTag;
    }

    public void setContNoteTag(String contNoteTag) {
        this.contNoteTag = contNoteTag;
    }

    public Long getContTimeSort() {
        return contTimeSort;
    }

    public void setContTimeSort(Long contTimeSort) {
        this.contTimeSort = contTimeSort;
    }

    public Long getContVhcStartTime() {
        return contVhcStartTime;
    }

    public void setContVhcStartTime(Long contVhcStartTime) {
        this.contVhcStartTime = contVhcStartTime;
    }
}
