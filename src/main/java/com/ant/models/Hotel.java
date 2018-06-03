package com.ant.models;

import java.util.Objects;

public class Hotel {
    private int id;
    private Integer htlNo;  // 编号
    private String htlName; // 酒店名
    private Integer htlLevel;   // 酒店星级
    private String htlAddr; // 酒店地址
    private String htlRoom;    // 房型
    private Float htlFare;  // 合作价格
    private Float htlOfficalFare;  // 门市价
    private Float htlPrice; // 售价
    private String htlTel;  // 电话
    private String htlNet;  // 网址
    private Long htlCreateTime; // 创建（更新）时间
    private Long htlTimeTag;
    private String htlNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getHtlNo() {
        return htlNo;
    }

    public void setHtlNo(Integer htlNo) {
        this.htlNo = htlNo;
    }

    public String getHtlName() {
        return htlName;
    }

    public void setHtlName(String htlName) {
        this.htlName = htlName;
    }

    public Integer getHtlLevel() {
        return htlLevel;
    }

    public void setHtlLevel(Integer htlLevel) {
        this.htlLevel = htlLevel;
    }

    public String getHtlAddr() {
        return htlAddr;
    }

    public void setHtlAddr(String htlAddr) {
        this.htlAddr = htlAddr;
    }

    public String getHtlRoom() {
        return htlRoom;
    }

    public void setHtlRoom(String htlRoom) {
        this.htlRoom = htlRoom;
    }

    public Float getHtlFare() {
        return htlFare;
    }

    public void setHtlFare(Float htlFare) {
        this.htlFare = htlFare;
    }

    public Float getHtlOfficalFare() {
        return htlOfficalFare;
    }

    public void setHtlOfficalFare(Float htlOfficalFare) {
        this.htlOfficalFare = htlOfficalFare;
    }

    public String getHtlTel() {
        return htlTel;
    }

    public void setHtlTel(String htlTel) {
        this.htlTel = htlTel;
    }

    public String getHtlNet() {
        return htlNet;
    }

    public void setHtlNet(String htlNet) {
        this.htlNet = htlNet;
    }

    public Long getHtlCreateTime() {
        return htlCreateTime;
    }

    public void setHtlCreateTime(Long htlCreateTime) {
        this.htlCreateTime = htlCreateTime;
    }

    public Long getHtlTimeTag() {
        return htlTimeTag;
    }

    public void setHtlTimeTag(Long htlTimeTag) {
        this.htlTimeTag = htlTimeTag;
    }

    public String getHtlNoteTag() {
        return htlNoteTag;
    }

    public void setHtlNoteTag(String htlNoteTag) {
        this.htlNoteTag = htlNoteTag;
    }

    public Float getHtlPrice() {
        return htlPrice;
    }

    public void setHtlPrice(Float htlPrice) {
        this.htlPrice = htlPrice;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", htlNo=" + htlNo +
                ", htlName='" + htlName + '\'' +
                ", htlLevel=" + htlLevel +
                ", htlAddr='" + htlAddr + '\'' +
                ", htlRoom='" + htlRoom + '\'' +
                ", htlFare=" + htlFare +
                ", htlOfficalFare=" + htlOfficalFare +
                ", htlPrice=" + htlPrice +
                ", htlTel='" + htlTel + '\'' +
                ", htlNet='" + htlNet + '\'' +
                ", htlCreateTime=" + htlCreateTime +
                ", htlTimeTag=" + htlTimeTag +
                ", htlNoteTag='" + htlNoteTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id &&
                Objects.equals(htlNo, hotel.htlNo) &&
                Objects.equals(htlName, hotel.htlName) &&
                Objects.equals(htlLevel, hotel.htlLevel) &&
                Objects.equals(htlAddr, hotel.htlAddr) &&
                Objects.equals(htlRoom, hotel.htlRoom) &&
                Objects.equals(htlFare, hotel.htlFare) &&
                Objects.equals(htlOfficalFare, hotel.htlOfficalFare) &&
                Objects.equals(htlPrice, hotel.htlPrice) &&
                Objects.equals(htlTel, hotel.htlTel) &&
                Objects.equals(htlNet, hotel.htlNet) &&
                Objects.equals(htlCreateTime, hotel.htlCreateTime) &&
                Objects.equals(htlTimeTag, hotel.htlTimeTag) &&
                Objects.equals(htlNoteTag, hotel.htlNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, htlNo, htlName, htlLevel, htlAddr, htlRoom, htlFare, htlOfficalFare, htlPrice, htlTel, htlNet, htlCreateTime, htlTimeTag, htlNoteTag);
    }
}
