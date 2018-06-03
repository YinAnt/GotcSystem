package com.ant.models;

import java.util.Objects;

public class Scenic {
    private int id;
    private Integer scnNo;  // 编号
    private String scnName; // 景区名
    private String scnEnName; // 景区英文名
    private String scnAddr; // 景区地址
    private String scnImgPath;  // 图片地址
    private String scnDescribe; // 描述
    private Float scnFareAdult; // 合作成人票价
    private Float scnFareChile; // 合作儿童票价
    private Float scnOfficalFareAdult; // 门市价（成人）
    private Float scnOfficalFareChild; // 门市价（儿童）
    private Float scnPrice; // 公司售价
    private String scnTel; // 联系电话
    private String scnNet; // 官网网址
    private String scnOpenTime; // 开放时间
    private Long scnCreateTime; // 创建（更新）时间
    private Long scnTimeTag; //
    private String scnNoteTag; //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getScnNo() {
        return scnNo;
    }

    public void setScnNo(Integer scnNo) {
        this.scnNo = scnNo;
    }

    public String getScnName() {
        return scnName;
    }

    public void setScnName(String scnName) {
        this.scnName = scnName;
    }

    public String getScnEnName() {
        return scnEnName;
    }

    public void setScnEnName(String scnEnName) {
        this.scnEnName = scnEnName;
    }

    public String getScnAddr() {
        return scnAddr;
    }

    public void setScnAddr(String scnAddr) {
        this.scnAddr = scnAddr;
    }

    public String getScnDescribe() {
        return scnDescribe;
    }

    public void setScnDescribe(String scnDescribe) {
        this.scnDescribe = scnDescribe;
    }

    public Float getScnFareAdult() {
        return scnFareAdult;
    }

    public void setScnFareAdult(Float scnFareAdult) {
        this.scnFareAdult = scnFareAdult;
    }

    public Float getScnFareChile() {
        return scnFareChile;
    }

    public void setScnFareChile(Float scnFareChile) {
        this.scnFareChile = scnFareChile;
    }

    public Float getScnOfficalFareAdult() {
        return scnOfficalFareAdult;
    }

    public void setScnOfficalFareAdult(Float scnOfficalFareAdult) {
        this.scnOfficalFareAdult = scnOfficalFareAdult;
    }

    public Float getScnOfficalFareChild() {
        return scnOfficalFareChild;
    }

    public void setScnOfficalFareChild(Float scnOfficalFareChild) {
        this.scnOfficalFareChild = scnOfficalFareChild;
    }

    public String getScnTel() {
        return scnTel;
    }

    public void setScnTel(String scnTel) {
        this.scnTel = scnTel;
    }

    public String getScnNet() {
        return scnNet;
    }

    public void setScnNet(String scnNet) {
        this.scnNet = scnNet;
    }

    public String getScnOpenTime() {
        return scnOpenTime;
    }

    public void setScnOpenTime(String scnOpenTime) {
        this.scnOpenTime = scnOpenTime;
    }

    public Long getScnCreateTime() {
        return scnCreateTime;
    }

    public void setScnCreateTime(Long scnCreateTime) {
        this.scnCreateTime = scnCreateTime;
    }

    public Long getScnTimeTag() {
        return scnTimeTag;
    }

    public void setScnTimeTag(Long scnTimeTag) {
        this.scnTimeTag = scnTimeTag;
    }

    public String getScnNoteTag() {
        return scnNoteTag;
    }

    public void setScnNoteTag(String scnNoteTag) {
        this.scnNoteTag = scnNoteTag;
    }

    public Float getScnPrice() {
        return scnPrice;
    }

    public void setScnPrice(Float scnPrice) {
        this.scnPrice = scnPrice;
    }

    public String getScnImgPath() {
        return scnImgPath;
    }

    public void setScnImgPath(String scnImgPath) {
        this.scnImgPath = scnImgPath;
    }

    @Override
    public String toString() {
        return "Scenic{" +
                "id=" + id +
                ", scnNo=" + scnNo +
                ", scnName='" + scnName + '\'' +
                ", scnEnName='" + scnEnName + '\'' +
                ", scnAddr='" + scnAddr + '\'' +
                ", scnImgPath='" + scnImgPath + '\'' +
                ", scnDescribe='" + scnDescribe + '\'' +
                ", scnFareAdult=" + scnFareAdult +
                ", scnFareChile=" + scnFareChile +
                ", scnOfficalFareAdult=" + scnOfficalFareAdult +
                ", scnOfficalFareChild=" + scnOfficalFareChild +
                ", scnPrice=" + scnPrice +
                ", scnTel='" + scnTel + '\'' +
                ", scnNet='" + scnNet + '\'' +
                ", scnOpenTime='" + scnOpenTime + '\'' +
                ", scnCreateTime=" + scnCreateTime +
                ", scnTimeTag=" + scnTimeTag +
                ", scnNoteTag='" + scnNoteTag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scenic scenic = (Scenic) o;
        return id == scenic.id &&
                Objects.equals(scnNo, scenic.scnNo) &&
                Objects.equals(scnName, scenic.scnName) &&
                Objects.equals(scnEnName, scenic.scnEnName) &&
                Objects.equals(scnAddr, scenic.scnAddr) &&
                Objects.equals(scnImgPath, scenic.scnImgPath) &&
                Objects.equals(scnDescribe, scenic.scnDescribe) &&
                Objects.equals(scnFareAdult, scenic.scnFareAdult) &&
                Objects.equals(scnFareChile, scenic.scnFareChile) &&
                Objects.equals(scnOfficalFareAdult, scenic.scnOfficalFareAdult) &&
                Objects.equals(scnOfficalFareChild, scenic.scnOfficalFareChild) &&
                Objects.equals(scnPrice, scenic.scnPrice) &&
                Objects.equals(scnTel, scenic.scnTel) &&
                Objects.equals(scnNet, scenic.scnNet) &&
                Objects.equals(scnOpenTime, scenic.scnOpenTime) &&
                Objects.equals(scnCreateTime, scenic.scnCreateTime) &&
                Objects.equals(scnTimeTag, scenic.scnTimeTag) &&
                Objects.equals(scnNoteTag, scenic.scnNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, scnNo, scnName, scnEnName, scnAddr, scnImgPath, scnDescribe, scnFareAdult, scnFareChile, scnOfficalFareAdult, scnOfficalFareChild, scnPrice, scnTel, scnNet, scnOpenTime, scnCreateTime, scnTimeTag, scnNoteTag);
    }
}
