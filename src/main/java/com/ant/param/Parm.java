package com.ant.param;

public class Parm {
    public static final String MSG_MEAN = "mean";
    public static final String MSG_CODE = "code";


    public static final String ID = "id";
    // User 属性
    public static final String USER_NAME = "userName"; // 用户名
    public static final String USER_PASSWORD = "userPassword"; // 用户密码
    public static final String USER_TYPE = "userType"; // 用户类型：1 职员；2 顾客；3 管理员
    public static final String USER_ALIAS = "userAlias"; // 用户别名（昵称）
    public static final String USER_TEL = "userTel"; // 电话
    public static final String USER_EMAIL = "userEmail"; // 邮箱

    // Announce 属性
    public static final String ANC_CREATE_TIME = "ancCreateTime";
    public static final String ANC_POSTER = "ancPoster";
    public static final String ANC_POSTER_NAME = "ancPosterName";
    public static final String ANC_TYPE = "ancType";
    public static final String ANC_CONTENT = "ancContent";

    // Employee 属性
    public static final String EMP_NO = "empNo";
    public static final String EMP_NAME = "empName";
    public static final String EMP_SEX = "empSex";
    public static final String EMP_BIRTHDAY = "empBirthday";
    public static final String EMP_TEL = "empTel";
    public static final String EMP_EMAIL = "empEmail";
    public static final String EMP_IDCARD = "empIdcard";
    public static final String EMP_DEPT_NO = "empDeptNo";
    public static final String EMP_DEPT_NAME = "empDeptName";
    public static final String EMP_ROLE = "empRole";
    public static final String EMP_LANGUAGE = "empLanguage";
    public static final String EMP_ENTRY = "empEntry";
    public static final String EMP_STATE = "empState";

    // Department 属性
    public static final String DEPT_NO = "deptNo"; // 部门号
    public static final String DEPT_NAME = "deptName"; // 部门名
    public static final String DEPT_LEADER = "deptLeader"; // 部门经理

    // Sign 属性
    public static final String SIGN_EMP_NO = "signEmpNo";
    public static final String SIGN_EMP_NAME = "signEmpName";
    public static final String SIGN_DAY = "signDay";
    public static final String SIGN_IN_TIME = "signInTime";
    public static final String SIGN_IN_IP = "signInIp";
    public static final String SIGN_OUT_TIME = "signOutTime";
    public static final String SIGN_OUT_IP = "signOutIp";
    public static final String SIGN_FLAG = "signFlag";

    // Holiday 请假工单 属性
    public static final String HLD_NO = "hldNo";   // 工单号
    public static final String HLD_EMP_NO = "hldEmpNo";   // 申请人
    public static final String HLD_EMP_NAME = "signEmpName";
    public static final String HLD_CREATE_TIME = "hldCreateTime"; // 创建时间
    public static final String HLD_START_TIME = "hldStartTime"; // 开始时间
    public static final String HLD_END_TIME = "hldEndTime"; // 结束时间
    public static final String HLD_DAYS = "hldDays"; // 请假天数
    public static final String HLD_TYPE = "hldType"; // 请假类型
    public static final String HLD_REASON = "hldReason"; // 请假原因
    public static final String HLD_HANDLE = "hldHandle"; // 处理人
    public static final String HLD_HANDLE_NAME = "hldHandleName"; // 处理人姓名
    public static final String HLD_HANDLE_TIME = "hldHandleTime"; // 处理时间
    public static final String HLD_HANDLE_DAYS = "hldHandleDays"; // 处理时长
    public static final String HLD_STATE = "hldState"; // 工单状态


    // Journal 日报工单属性
    public static final String JNL_NO = "jnlNo";    //工单号
    public static final String JNL_EMP_NO = "jnlEmpNo";   // 工号
    public static final String JNL_EMP_NAME = "jnlEmpName";  // 姓名
    public static final String JNL_CREATE_TIME = "jnlCreateTime"; // 创建时间
    public static final String JNL_CONTENT = "jnlContent";  // 日报内容
    public static final String JNL_DUTY_TYPE = "jnlDutyType"; // 值班类型 ：在岗、请假、出差


    // Orders 订单表属性
    public static final String ORD_NO = "ordNo";         // 订单号
    public static final String ORD_USER = "ordUser";    // 用户名
    public static final String ORD_ALIAS = "ordAlias";    // 别名
    public static final String ORD_TEL = "ordTel";    // 联系方式
    public static final String ORD_EMAIL = "ordEmail";    // 邮箱
    public static final String ORD_CREATE_TIME = "ordCreateTime";     // 创建时间
    public static final String ORD_PAY_TIME = "ordPayTime";     // 付款时间
    public static final String ORD_START_TIME = "ordStartTime";     // 开始时间
    public static final String ORD_END_TIME = "ordEndTime";     // 结束时间
    public static final String ORD_ADULT_NUM = "ordAdultNum";    // 成人数
    public static final String ORD_CHILD_NUM = "ordChildNum";    // 儿童数
    public static final String ORD_MEAL = "ordMeal";    // 含餐否
    public static final String ORD_BUDGET = "ordBudget";    // 预算
    public static final String ORD_PAY = "ordPay";    // 订单实付
    public static final String ORD_AGENT = "ordAgent";    // 责任人
    public static final String ORD_AGENT_NAME = "ordAgentName";    // 责任人姓名
    public static final String ORD_STATE = "ordState";    // 订单状态

    // Content 订单内容 主属性
    public static final String CONT_NO = "contNo";   // 流水号
    public static final String CONT_ORD_NO = "contOrdNo";   // 订单号
    public static final String CONT_NAME = "contName";  // 品类名
    public static final String CONT_FARE = "contFare";  // 品类价格
    public static final String CONT_DETAILS = "contDetails";    // 描述
    public static final String CONT_TYPE = "contType";  // 类型： 景区，酒店，车辆
    public static final String CONT_STATE = "contState";  // 状态：已处理待处理
    public static final String CONT_TIME_TAG = "contTimeTag";   // 处理时间

    public static final String CONT_SCN_NO = "contScnNo";//景区号
    public static final String CONT_SCN_NAME = "contScnName";//景区名
    public static final String CONT_SCN_NUM_ADULT = "contScnNumAdult";//成人数量
    public static final String CONT_SCN_FARE_ADULT = "contScnFareAdult";
    public static final String CONT_SCN_NUM_CHILD = "contScnNumChild";//儿童数量
    public static final String CONT_SCN_FARE_CHILD = "contScnFareChild";
    public static final String CONT_SCN_PRICE = "contScnPrice";//售价单价
    public static final String CONT_SCN_DATE = "contScnDate";//游览日期
    public static final String CONT_SCN_START_TIME = "contScnStartTime";//开始时间
    public static final String CONT_SCN_END_TIME = "contScnEndTime";//结束时间

    public static final String CONT_HLT_NO = "contHtlNo";//酒店编号
    public static final String CONT_HLT_NAME = "contHtlName";//酒店名
    public static final String CONT_HLT_ROOM = "contHtlRoom";//房型
    public static final String CONT_HLT_CHECK_IN = "contHtlCheckIn";//入住日期
    public static final String CONT_HLT_CHECK_OUT = "contHtlCheckOut";//离店日期
    public static final String CONT_HLT_DAYS = "contHtlDays";//入住天数

    public static final String CONT_VHC_NO = "contVhcNo";//车辆编号
    public static final String CONT_VHC_NUM = "contVhcNum";//车牌号
    public static final String CONT_VHC_MODEL = "contVhcModel";//车型
    public static final String CONT_VHC_SEAT = "contVhcSeat";//座位数


    // Scenic 景区属性
    public static final String SCN_NO = "scnNo"; // 景区编号
    public static final String SCN_NAME = "scnName"; // 景区名
    public static final String SCN_EN_NAME = "scnEnName"; // 景区英文名
    public static final String SCN_ADDR = "scnAddr"; // 景区地址
    public static final String SCN_DESCRIBE = "scnDescribe"; // 描述
    public static final String SCN_FARE_ADULT = "scnFareAdult"; // 合作成人票价
    public static final String SCN_FARE_CHILE = "scnFareChile"; // 合作儿童票价
    public static final String SCN_OFF_FARE_ADULT = "scnOfficalFareAdult"; // 门市价（成人）
    public static final String SCN_OFF_FARE_CHILD = "scnOfficalFareChild"; // 门市价（儿童）
    public static final String SCN_PRICE = "scnPrice"; // 公司售价
    public static final String SCN_TEL = "scnTel"; // 联系电话
    public static final String SCN_NET = "scnNet"; // 官网网址
    public static final String SCN_OPEN_TIME = "scnOpenTime"; // 开放时间
    public static final String SCN_CREATE_TIME = "scnCreateTime"; // 创建（更新）时间

    // Hotel 酒店属性
    public static final String HTL_NO = "htlNo";  // 编号
    public static final String HTL_NAME = "htlName"; // 酒店名
    public static final String HTL_LEVEL = "htlLevel";   // 酒店星级
    public static final String HTL_ADDR = "htlAddr"; // 酒店地址
    public static final String HTL_ROOM = "htlRoom";    // 房型
    public static final String HTL_FARE = "htlFare";  // 合作价格
    public static final String HTL_OFF_FARE = "htlOfficalFare";  // 门市价
    public static final String HTL_TEL = "htlTel";  // 电话
    public static final String HTL_NET = "htlNet";  // 网址
    public static final String HTL_CREATE_TIME = "htlCreateTime"; // 创建（更新）时间

    // 车辆属性
    public static final String VHC_NO = "vhcNo"; // 编号
    public static final String VHC_NUM = "vhcNum";  // 车牌号
    public static final String VHC_MODEL = "vhcModel";    // 车型
    public static final String VHC_SEAT = "vhcSeat";    // 座位数
    public static final String VHC_AGENT = "vhcAgent";    // 责任人
    public static final String VHC_DESCRIBE = "vhcDescribe"; // 描述
    public static final String VHC_STATE = "vhcState";    // 状态
    public static final String VHC_CREATE_TIME = "vhcCreateTime"; // 创建（更新）

    // Files 文件属性
    public static final String FILE_TITLE = "filesTitle"; // 标题
    public static final String FILE_NAME = "filesName"; // 文件名
    public static final String FILE_DESCRIBE = "filesDescribe"; // 描述
    public static final String FILE_PATH = "filesPath"; // 路径
    public static final String FILE_TYPE = "filesType"; // 文件类型
    public static final String FILE_POSTER = "filesPoster"; // 发布者工号
    public static final String FILE_POSTER_NAME = "filesPosterName"; // 发布者姓名
    public static final String FILE_TIME = "filesTime"; // 发布时间

}
