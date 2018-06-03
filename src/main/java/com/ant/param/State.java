package com.ant.param;

public class State {

    // 用户类型：职员、顾客、管理员
    public static final int USER_YTPE_EMPLOYEE = 1; // 职员
    public static final int USER_YTPE_CUSTOMER = 2; // 访客
    public static final int USER_YTPE_ADMIN = 3;    // 管理员

    // 部门类型：总经理、副总经理、行政部、财务部、导游部、计调部、宣传部、综合部
    public static final int DEPT_NO_MANAGER = 2001; // 总经理
    public static final int DEPT_NO_ASSISTANT_MANAGER = 2002; // 副总经理
    public static final int DEPT_NO_ADMINISTRATIVE = 2003;   // 财务部
    public static final int DEPT_NO_FINANCE = 2004; // 财务部
    public static final int DEPT_NO_GUIDE = 2005;   // 导游部
    public static final int DEPT_NO_OPERATOR = 2006;   // 计调部 operator
    public static final int DEPT_NO_ADVERTISE = 2007;   // 宣传部、广告部
    public static final int DEPT_NO_SYNTHESIZE = 2008;  // 综合部

    // 签到类型
    public static final int SIGN_FLAG_IN = 1;   // 签到
    public static final int SIGN_FLAG_OUT = 2;  // 签退

    // 请假工单状态
    public static final int HLD_STATE_WAIT = 1;     // 待处理
    public static final int HLD_STATE_FINISH = 2;   // 已处理

    // 请假审批结果
    public static final String HLD_FINISH_AGREE = "同意";     // 待处理
    public static final String HLD_FINISH_DISAGREE = "不同意";   // 已处理

    // 订单状态
    public static final int ORD_STATE_WAIT = 1;     // 待处理
    public static final int ORD_STATE_HANDLE = 2;   // 已处理（待付款）
    public static final int ORD_STATE_PAY = 3;   // 已付款

    // 订单内容品类类型
    public static final int CONT_TYPE_SCENIC = 1;   // 景区
    public static final int CONT_TYPE_HOTEL = 2;    // 酒店
    public static final int CONT_TYPE_VEHICLE = 3;  // 车辆

    // 订单内容处理状态
    public static final int CONT_STATE_WAIT = 1;    // 待处理
    public static final int CONT_STATE_FINISH = 2;  // 已处理

    // 酒店房型
    public static final int HTL_TYPE_SINGLE = 1;
    public static final int HTL_TYPE_DOUBLE = 2;
    public static final int HTL_TYPE_THRID = 3;
    public static final int HTL_TYPE_FAMILY = 4;
    public static final int HTL_TYPE_BIG = 5;

    // 车辆状态
    public static final String VHC_STATE_FREE = "空闲中";
    public static final String VHC_STATE_WORD = "使用中";
    public static final String VHC_STATE_UPKEEP = "维修中";
    public static final String VHC_STATE_OTHER = "其他";

    // 公告类型
    public static final String ANC_TYPE_WORD = "部门工作";
    public static final String ANC_TYPE_STA_INFO = "站内通知";
    public static final String ANC_TYPE_MEETINT = "会议通知";
    public static final String ANC_TYPE_GUIDE = "旅游攻略";
    public static final String ANC_TYPE_OTHERS = "其他";

}
