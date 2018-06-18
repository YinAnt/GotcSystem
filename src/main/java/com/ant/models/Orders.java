package com.ant.models;

import java.util.Objects;

public class Orders {
    private int id;
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
    private String ordComment;  // 订单评价
    private String ordReply;    // 订单回复
    private Long ordTimeTag;
    private String ordNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Long getOrdTimeTag() {
        return ordTimeTag;
    }

    public void setOrdTimeTag(Long ordTimeTag) {
        this.ordTimeTag = ordTimeTag;
    }

    public String getOrdNoteTag() {
        return ordNoteTag;
    }

    public void setOrdNoteTag(String ordNoteTag) {
        this.ordNoteTag = ordNoteTag;
    }

    public String getOrdComment() {
        return ordComment;
    }

    public void setOrdComment(String ordComment) {
        this.ordComment = ordComment;
    }

    public String getOrdReply() {
        return ordReply;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordNo=" + ordNo +
                ", ordUser='" + ordUser + '\'' +
                ", ordAlias='" + ordAlias + '\'' +
                ", ordTel='" + ordTel + '\'' +
                ", ordEmail='" + ordEmail + '\'' +
                ", ordCreateTime=" + ordCreateTime +
                ", ordPayTime=" + ordPayTime +
                ", ordStartTime=" + ordStartTime +
                ", ordEndTime=" + ordEndTime +
                ", ordAdultNum=" + ordAdultNum +
                ", ordChildNum=" + ordChildNum +
                ", ordMeal='" + ordMeal + '\'' +
                ", ordBudget=" + ordBudget +
                ", ordPay=" + ordPay +
                ", ordAgent=" + ordAgent +
                ", ordAgentName='" + ordAgentName + '\'' +
                ", ordState=" + ordState +
                ", ordComment='" + ordComment + '\'' +
                ", ordReply='" + ordReply + '\'' +
                ", ordTimeTag=" + ordTimeTag +
                ", ordNoteTag='" + ordNoteTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                Objects.equals(ordNo, orders.ordNo) &&
                Objects.equals(ordUser, orders.ordUser) &&
                Objects.equals(ordAlias, orders.ordAlias) &&
                Objects.equals(ordTel, orders.ordTel) &&
                Objects.equals(ordEmail, orders.ordEmail) &&
                Objects.equals(ordCreateTime, orders.ordCreateTime) &&
                Objects.equals(ordPayTime, orders.ordPayTime) &&
                Objects.equals(ordStartTime, orders.ordStartTime) &&
                Objects.equals(ordEndTime, orders.ordEndTime) &&
                Objects.equals(ordAdultNum, orders.ordAdultNum) &&
                Objects.equals(ordChildNum, orders.ordChildNum) &&
                Objects.equals(ordMeal, orders.ordMeal) &&
                Objects.equals(ordBudget, orders.ordBudget) &&
                Objects.equals(ordPay, orders.ordPay) &&
                Objects.equals(ordAgent, orders.ordAgent) &&
                Objects.equals(ordAgentName, orders.ordAgentName) &&
                Objects.equals(ordState, orders.ordState) &&
                Objects.equals(ordComment, orders.ordComment) &&
                Objects.equals(ordReply, orders.ordReply) &&
                Objects.equals(ordTimeTag, orders.ordTimeTag) &&
                Objects.equals(ordNoteTag, orders.ordNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ordNo, ordUser, ordAlias, ordTel, ordEmail, ordCreateTime, ordPayTime, ordStartTime, ordEndTime, ordAdultNum, ordChildNum, ordMeal, ordBudget, ordPay, ordAgent, ordAgentName, ordState, ordComment, ordReply, ordTimeTag, ordNoteTag);
    }

    public void setOrdReply(String ordReply) {
        this.ordReply = ordReply;
    }
}
