package com.ant.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Content implements Cloneable {
    private int id;
    private Long contOrdNo;// 订单号
    private Long contNo; // 流水号
    private Integer contState;//订单处理状态
    private String contName;// 品类名
    private Float contFare;// 品类价格
    private String contDetails;// 描述
    private Integer contType;// 类型： 景区，酒店，车辆

    private Integer contScnNo;// 景区号
    private String contScnName;// 景区名
    private Integer contScnNumAdult;// 成人数量
    private Float contScnFareAdult;
    private Integer contScnNumChild;// 儿童数量
    private Float contScnFareChild;
    private Float contScnPrice;// 售价单价
    private Long contScnDate;// 游览日期
    private String contScnStartTime;// 开始时间
    private String contScnEndTime;// 结束时间

    private Integer contHtlNo;// 酒店编号
    private String contHtlName;// 酒店名
    private String contHtlRoom;// 房型
    private Long contHtlCheckIn;// 入住日期
    private Long contHtlCheckOut;// 离店日期
    private Integer contHtlDays;// 入住天数

    private Integer contVhcNo; // 车辆编号
    private String contVhcNum; // 车牌号
    private String contVhcModel; // 车型
    private Integer contVhcSeat; // 座位数
    private Long contVhcStartTime; // 车辆使用开始时间
    private Long contVhcEndTime;    // 车辆使用结束时间

    private Long contTimeTag;   // 处理时间
    private String contNoteTag;
    private Long contTimeSort;  // 时间排序用

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static List<Content> clone(List<Content> contentList) {
        if (contentList == null) {
            return null;
        }
        ArrayList<Content> arrayList = new ArrayList<>();
        for (Content c : contentList) {
            try {
                arrayList.add((Content) c.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Float getContFare() {
        return contFare;
    }

    public void setContFare(Float contFare) {
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

    public Float getContScnFareAdult() {
        return contScnFareAdult;
    }

    public void setContScnFareAdult(Float contScnFareAdult) {
        this.contScnFareAdult = contScnFareAdult;
    }

    public Integer getContScnNumChild() {
        return contScnNumChild;
    }

    public void setContScnNumChild(Integer contScnNumChild) {
        this.contScnNumChild = contScnNumChild;
    }

    public Float getContScnFareChild() {
        return contScnFareChild;
    }

    public void setContScnFareChild(Float contScnFareChild) {
        this.contScnFareChild = contScnFareChild;
    }

    public Float getContScnPrice() {
        return contScnPrice;
    }

    public void setContScnPrice(Float contScnPrice) {
        this.contScnPrice = contScnPrice;
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

    public Long getContVhcEndTime() {
        return contVhcEndTime;
    }

    public void setContVhcEndTime(Long contVhcEndTime) {
        this.contVhcEndTime = contVhcEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return id == content.id &&
                Objects.equals(contOrdNo, content.contOrdNo) &&
                Objects.equals(contNo, content.contNo) &&
                Objects.equals(contState, content.contState) &&
                Objects.equals(contName, content.contName) &&
                Objects.equals(contFare, content.contFare) &&
                Objects.equals(contDetails, content.contDetails) &&
                Objects.equals(contType, content.contType) &&
                Objects.equals(contScnNo, content.contScnNo) &&
                Objects.equals(contScnName, content.contScnName) &&
                Objects.equals(contScnNumAdult, content.contScnNumAdult) &&
                Objects.equals(contScnFareAdult, content.contScnFareAdult) &&
                Objects.equals(contScnNumChild, content.contScnNumChild) &&
                Objects.equals(contScnFareChild, content.contScnFareChild) &&
                Objects.equals(contScnPrice, content.contScnPrice) &&
                Objects.equals(contScnDate, content.contScnDate) &&
                Objects.equals(contScnStartTime, content.contScnStartTime) &&
                Objects.equals(contScnEndTime, content.contScnEndTime) &&
                Objects.equals(contHtlNo, content.contHtlNo) &&
                Objects.equals(contHtlName, content.contHtlName) &&
                Objects.equals(contHtlRoom, content.contHtlRoom) &&
                Objects.equals(contHtlCheckIn, content.contHtlCheckIn) &&
                Objects.equals(contHtlCheckOut, content.contHtlCheckOut) &&
                Objects.equals(contHtlDays, content.contHtlDays) &&
                Objects.equals(contVhcNo, content.contVhcNo) &&
                Objects.equals(contVhcNum, content.contVhcNum) &&
                Objects.equals(contVhcModel, content.contVhcModel) &&
                Objects.equals(contVhcSeat, content.contVhcSeat) &&
                Objects.equals(contVhcStartTime, content.contVhcStartTime) &&
                Objects.equals(contVhcEndTime, content.contVhcEndTime) &&
                Objects.equals(contTimeTag, content.contTimeTag) &&
                Objects.equals(contNoteTag, content.contNoteTag) &&
                Objects.equals(contTimeSort, content.contTimeSort);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contOrdNo, contNo, contState, contName, contFare, contDetails, contType, contScnNo, contScnName, contScnNumAdult, contScnFareAdult, contScnNumChild, contScnFareChild, contScnPrice, contScnDate, contScnStartTime, contScnEndTime, contHtlNo, contHtlName, contHtlRoom, contHtlCheckIn, contHtlCheckOut, contHtlDays, contVhcNo, contVhcNum, contVhcModel, contVhcSeat, contVhcStartTime, contVhcEndTime, contTimeTag, contNoteTag, contTimeSort);
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", contOrdNo=" + contOrdNo +
                ", contNo=" + contNo +
                ", contState=" + contState +
                ", contName='" + contName + '\'' +
                ", contFare=" + contFare +
                ", contDetails='" + contDetails + '\'' +
                ", contType=" + contType +
                ", contScnNo=" + contScnNo +
                ", contScnName='" + contScnName + '\'' +
                ", contScnNumAdult=" + contScnNumAdult +
                ", contScnFareAdult=" + contScnFareAdult +
                ", contScnNumChild=" + contScnNumChild +
                ", contScnFareChild=" + contScnFareChild +
                ", contScnPrice=" + contScnPrice +
                ", contScnDate=" + contScnDate +
                ", contScnStartTime='" + contScnStartTime + '\'' +
                ", contScnEndTime='" + contScnEndTime + '\'' +
                ", contHtlNo=" + contHtlNo +
                ", contHtlName='" + contHtlName + '\'' +
                ", contHtlRoom='" + contHtlRoom + '\'' +
                ", contHtlCheckIn=" + contHtlCheckIn +
                ", contHtlCheckOut=" + contHtlCheckOut +
                ", contHtlDays=" + contHtlDays +
                ", contVhcNo='" + contVhcNo + '\'' +
                ", contVhcNum='" + contVhcNum + '\'' +
                ", contVhcModel='" + contVhcModel + '\'' +
                ", contVhcSeat=" + contVhcSeat +
                ", contVhcStartTime=" + contVhcStartTime +
                ", contVhcEndTime=" + contVhcEndTime +
                ", contTimeTag=" + contTimeTag +
                ", contNoteTag='" + contNoteTag + '\'' +
                ", contTimeSort=" + contTimeSort +
                '}';
    }
}
