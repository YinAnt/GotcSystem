package com.ant.models;

import java.util.Objects;

public class Holiday {
    private int id;
    private Long hldNo;   // 工单号
    private Integer hldEmpNo;   // 申请人工号
    private String hldEmpName;   // 申请人姓名
    private Long hldCreateTime; // 创建时间
    private Long hldStartTime; // 开始时间
    private Long hldEndTime; // 结束时间
    private Float hldDays; // 请假天数
    private String hldType; // 请假类型
    private String hldReason; // 请假原因
    private Integer hldHandle; // 处理人工号
    private String hldHandleName; // 处理人姓名
    private Long hldHandleTime; // 处理时间
    private Float hldHandleDays; // 处理时长
    private String hldResult; // 处理结果
    private Integer hldState; // 工单状态
    private Long hldTimeTag;
    private String hldNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getHldNo() {
        return hldNo;
    }

    public void setHldNo(Long hldNo) {
        this.hldNo = hldNo;
    }

    public Integer getHldEmpNo() {
        return hldEmpNo;
    }

    public void setHldEmpNo(Integer hldEmpNo) {
        this.hldEmpNo = hldEmpNo;
    }

    public Long getHldCreateTime() {
        return hldCreateTime;
    }

    public void setHldCreateTime(Long hldCreateTime) {
        this.hldCreateTime = hldCreateTime;
    }

    public Long getHldStartTime() {
        return hldStartTime;
    }

    public void setHldStartTime(Long hldStartTime) {
        this.hldStartTime = hldStartTime;
    }

    public Long getHldEndTime() {
        return hldEndTime;
    }

    public void setHldEndTime(Long hldEndTime) {
        this.hldEndTime = hldEndTime;
    }

    public Float getHldDays() {
        return hldDays;
    }

    public void setHldDays(Float hldDays) {
        this.hldDays = hldDays;
    }

    public String getHldType() {
        return hldType;
    }

    public void setHldType(String hldType) {
        this.hldType = hldType;
    }

    public String getHldReason() {
        return hldReason;
    }

    public void setHldReason(String hldReason) {
        this.hldReason = hldReason;
    }

    public Integer getHldHandle() {
        return hldHandle;
    }

    public void setHldHandle(Integer hldHandle) {
        this.hldHandle = hldHandle;
    }

    public Long getHldHandleTime() {
        return hldHandleTime;
    }

    public void setHldHandleTime(Long hldHandleTime) {
        this.hldHandleTime = hldHandleTime;
    }

    public Float getHldHandleDays() {
        return hldHandleDays;
    }

    public void setHldHandleDays(Float hldHandleDays) {
        this.hldHandleDays = hldHandleDays;
    }

    public Integer getHldState() {
        return hldState;
    }

    public void setHldState(Integer hldState) {
        this.hldState = hldState;
    }

    public Long getHldTimeTag() {
        return hldTimeTag;
    }

    public void setHldTimeTag(Long hldTimeTag) {
        this.hldTimeTag = hldTimeTag;
    }

    public String getHldNoteTag() {
        return hldNoteTag;
    }

    public void setHldNoteTag(String hldNoteTag) {
        this.hldNoteTag = hldNoteTag;
    }

    public String getHldEmpName() {
        return hldEmpName;
    }

    public void setHldEmpName(String hldEmpName) {
        this.hldEmpName = hldEmpName;
    }

    public String getHldHandleName() {
        return hldHandleName;
    }

    public void setHldHandleName(String hldHandleName) {
        this.hldHandleName = hldHandleName;
    }

    public String getHldResult() {
        return hldResult;
    }

    public void setHldResult(String hldResult) {
        this.hldResult = hldResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return id == holiday.id &&
                Objects.equals(hldNo, holiday.hldNo) &&
                Objects.equals(hldEmpNo, holiday.hldEmpNo) &&
                Objects.equals(hldCreateTime, holiday.hldCreateTime) &&
                Objects.equals(hldStartTime, holiday.hldStartTime) &&
                Objects.equals(hldEndTime, holiday.hldEndTime) &&
                Objects.equals(hldDays, holiday.hldDays) &&
                Objects.equals(hldType, holiday.hldType) &&
                Objects.equals(hldReason, holiday.hldReason) &&
                Objects.equals(hldHandle, holiday.hldHandle) &&
                Objects.equals(hldHandleTime, holiday.hldHandleTime) &&
                Objects.equals(hldHandleDays, holiday.hldHandleDays) &&
                Objects.equals(hldState, holiday.hldState) &&
                Objects.equals(hldTimeTag, holiday.hldTimeTag) &&
                Objects.equals(hldNoteTag, holiday.hldNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, hldNo, hldEmpNo, hldCreateTime, hldStartTime, hldEndTime, hldDays, hldType, hldReason, hldHandle, hldHandleTime, hldHandleDays, hldState, hldTimeTag, hldNoteTag);
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", hldNo=" + hldNo +
                ", hldEmpNo=" + hldEmpNo +
                ", hldEmpName='" + hldEmpName + '\'' +
                ", hldCreateTime=" + hldCreateTime +
                ", hldStartTime=" + hldStartTime +
                ", hldEndTime=" + hldEndTime +
                ", hldDays=" + hldDays +
                ", hldType='" + hldType + '\'' +
                ", hldReason='" + hldReason + '\'' +
                ", hldHandle=" + hldHandle +
                ", hldHandleName='" + hldHandleName + '\'' +
                ", hldHandleTime=" + hldHandleTime +
                ", hldHandleDays=" + hldHandleDays +
                ", hldResult='" + hldResult + '\'' +
                ", hldState=" + hldState +
                ", hldTimeTag=" + hldTimeTag +
                ", hldNoteTag='" + hldNoteTag + '\'' +
                '}';
    }
}
