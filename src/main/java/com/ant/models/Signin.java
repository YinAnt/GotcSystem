package com.ant.models;

import java.util.Objects;

public class Signin {
    private int id;
    private Integer signEmpNo; // 员工号
    private String signEmpName; // 员工号
    private Long signDay; // 签到日期
    private Long signInTime; // 签到时间
    private String signInIp;    // 签到IP
    private Long signOutTime; // 签退时间
    private String signOutIp; // 签退IP
    private Integer signFlag; // 签到类型
    private Long signTimeTag;
    private String signNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSignEmpNo() {
        return signEmpNo;
    }

    public void setSignEmpNo(Integer signEmpNo) {
        this.signEmpNo = signEmpNo;
    }

    public Long getSignDay() {
        return signDay;
    }

    public void setSignDay(Long signDay) {
        this.signDay = signDay;
    }

    public Long getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Long signInTime) {
        this.signInTime = signInTime;
    }

    public String getSignInIp() {
        return signInIp;
    }

    public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public Long getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Long signOutTime) {
        this.signOutTime = signOutTime;
    }

    public String getSignOutIp() {
        return signOutIp;
    }

    public void setSignOutIp(String signOutIp) {
        this.signOutIp = signOutIp;
    }

    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public Long getSignTimeTag() {
        return signTimeTag;
    }

    public void setSignTimeTag(Long signTimeTag) {
        this.signTimeTag = signTimeTag;
    }

    public String getSignNoteTag() {
        return signNoteTag;
    }

    public void setSignNoteTag(String signNoteTag) {
        this.signNoteTag = signNoteTag;
    }

    public String getSignEmpName() {
        return signEmpName;
    }

    public void setSignEmpName(String signEmpName) {
        this.signEmpName = signEmpName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signin that = (Signin) o;
        return id == that.id &&
                Objects.equals(signEmpNo, that.signEmpNo) &&
                Objects.equals(signDay, that.signDay) &&
                Objects.equals(signInTime, that.signInTime) &&
                Objects.equals(signInIp, that.signInIp) &&
                Objects.equals(signOutTime, that.signOutTime) &&
                Objects.equals(signOutIp, that.signOutIp) &&
                Objects.equals(signFlag, that.signFlag) &&
                Objects.equals(signTimeTag, that.signTimeTag) &&
                Objects.equals(signNoteTag, that.signNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, signEmpNo, signDay, signInTime, signInIp, signOutTime, signOutIp, signFlag, signTimeTag, signNoteTag);
    }

    @Override
    public String toString() {
        return "Signin{" +
                "id=" + id +
                ", signEmpNo=" + signEmpNo +
                ", signEmpName='" + signEmpName + '\'' +
                ", signDay=" + signDay +
                ", signInTime=" + signInTime +
                ", signInIp='" + signInIp + '\'' +
                ", signOutTime=" + signOutTime +
                ", signOutIp='" + signOutIp + '\'' +
                ", signFlag=" + signFlag +
                ", signTimeTag=" + signTimeTag +
                ", signNoteTag='" + signNoteTag + '\'' +
                '}';
    }
}
