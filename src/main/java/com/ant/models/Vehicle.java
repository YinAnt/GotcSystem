package com.ant.models;

import java.util.Objects;

public class Vehicle {
    private int id;
    private Integer vhcNo; // 编号
    private String vhcNum;  // 车牌号
    private String vhcModel;    // 车型
    private Integer vhcSeat;    // 座位数
    private String vhcAgent;    // 责任人
    private String vhcDescribe; // 描述
    private String vhcState;    // 状态
    private Long vhcCreateTime; // 创建（更新）时间
    private Long vhcTimeTag;
    private String vhcNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVhcNo() {
        return vhcNo;
    }

    public void setVhcNo(Integer vhcNo) {
        this.vhcNo = vhcNo;
    }

    public String getVhcNum() {
        return vhcNum;
    }

    public void setVhcNum(String vhcNum) {
        this.vhcNum = vhcNum;
    }

    public String getVhcModel() {
        return vhcModel;
    }

    public void setVhcModel(String vhcModel) {
        this.vhcModel = vhcModel;
    }

    public Integer getVhcSeat() {
        return vhcSeat;
    }

    public void setVhcSeat(Integer vhcSeat) {
        this.vhcSeat = vhcSeat;
    }

    public String getVhcAgent() {
        return vhcAgent;
    }

    public void setVhcAgent(String vhcAgent) {
        this.vhcAgent = vhcAgent;
    }

    public String getVhcDescribe() {
        return vhcDescribe;
    }

    public void setVhcDescribe(String vhcDescribe) {
        this.vhcDescribe = vhcDescribe;
    }

    public String getVhcState() {
        return vhcState;
    }

    public void setVhcState(String vhcState) {
        this.vhcState = vhcState;
    }

    public Long getVhcCreateTime() {
        return vhcCreateTime;
    }

    public void setVhcCreateTime(Long vhcCreateTime) {
        this.vhcCreateTime = vhcCreateTime;
    }

    public Long getVhcTimeTag() {
        return vhcTimeTag;
    }

    public void setVhcTimeTag(Long vhcTimeTag) {
        this.vhcTimeTag = vhcTimeTag;
    }

    public String getVhcNoteTag() {
        return vhcNoteTag;
    }

    public void setVhcNoteTag(String vhcNoteTag) {
        this.vhcNoteTag = vhcNoteTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id &&
                Objects.equals(vhcNo, vehicle.vhcNo) &&
                Objects.equals(vhcNum, vehicle.vhcNum) &&
                Objects.equals(vhcModel, vehicle.vhcModel) &&
                Objects.equals(vhcSeat, vehicle.vhcSeat) &&
                Objects.equals(vhcAgent, vehicle.vhcAgent) &&
                Objects.equals(vhcDescribe, vehicle.vhcDescribe) &&
                Objects.equals(vhcState, vehicle.vhcState) &&
                Objects.equals(vhcCreateTime, vehicle.vhcCreateTime) &&
                Objects.equals(vhcTimeTag, vehicle.vhcTimeTag) &&
                Objects.equals(vhcNoteTag, vehicle.vhcNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, vhcNo, vhcNum, vhcModel, vhcSeat, vhcAgent, vhcDescribe, vhcState, vhcCreateTime, vhcTimeTag, vhcNoteTag);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vhcNo=" + vhcNo +
                ", vhcNum='" + vhcNum + '\'' +
                ", vhcModel='" + vhcModel + '\'' +
                ", vhcSeat=" + vhcSeat +
                ", vhcAgent='" + vhcAgent + '\'' +
                ", vhcDescribe='" + vhcDescribe + '\'' +
                ", vhcState='" + vhcState + '\'' +
                ", vhcCreateTime=" + vhcCreateTime +
                ", vhcTimeTag=" + vhcTimeTag +
                ", vhcNoteTag='" + vhcNoteTag + '\'' +
                '}';
    }
}
