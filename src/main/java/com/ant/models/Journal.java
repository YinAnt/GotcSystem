package com.ant.models;

import java.util.Objects;

public class Journal {
    private int id;
    private Long jnlNo; // 工单号
    private Integer jnlEmpNo;   // 工号
    private String jnlEmpName;  // 姓名
    private Long jnlCreateTime; // 创建时间
    private String jnlContent;  // 日报内容
    private String jnlDutyType; // 值班类型：在岗、2 请假、3 出差
    private Long jnlTimeTag;
    private String jnlNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getJnlNo() {
        return jnlNo;
    }

    public void setJnlNo(Long jnlNo) {
        this.jnlNo = jnlNo;
    }

    public Integer getJnlEmpNo() {
        return jnlEmpNo;
    }

    public void setJnlEmpNo(Integer jnlEmpNo) {
        this.jnlEmpNo = jnlEmpNo;
    }

    public String getJnlEmpName() {
        return jnlEmpName;
    }

    public void setJnlEmpName(String jnlEmpName) {
        this.jnlEmpName = jnlEmpName;
    }

    public Long getJnlCreateTime() {
        return jnlCreateTime;
    }

    public void setJnlCreateTime(Long jnlCreateTime) {
        this.jnlCreateTime = jnlCreateTime;
    }

    public String getJnlContent() {
        return jnlContent;
    }

    public void setJnlContent(String jnlContent) {
        this.jnlContent = jnlContent;
    }

    public String getJnlDutyType() {
        return jnlDutyType;
    }

    public void setJnlDutyType(String jnlDutyType) {
        this.jnlDutyType = jnlDutyType;
    }

    public Long getJnlTimeTag() {
        return jnlTimeTag;
    }

    public void setJnlTimeTag(Long jnlTimeTag) {
        this.jnlTimeTag = jnlTimeTag;
    }

    public String getJnlNoteTag() {
        return jnlNoteTag;
    }

    public void setJnlNoteTag(String jnlNoteTag) {
        this.jnlNoteTag = jnlNoteTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return id == journal.id &&
                Objects.equals(jnlEmpNo, journal.jnlEmpNo) &&
                Objects.equals(jnlEmpName, journal.jnlEmpName) &&
                Objects.equals(jnlCreateTime, journal.jnlCreateTime) &&
                Objects.equals(jnlContent, journal.jnlContent) &&
                Objects.equals(jnlDutyType, journal.jnlDutyType) &&
                Objects.equals(jnlTimeTag, journal.jnlTimeTag) &&
                Objects.equals(jnlNoteTag, journal.jnlNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, jnlEmpNo, jnlEmpName, jnlCreateTime, jnlContent, jnlDutyType, jnlTimeTag, jnlNoteTag);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", jnlNo=" + jnlNo +
                ", jnlEmpNo=" + jnlEmpNo +
                ", jnlEmpName='" + jnlEmpName + '\'' +
                ", jnlCreateTime=" + jnlCreateTime +
                ", jnlContent='" + jnlContent + '\'' +
                ", jnlDutyType='" + jnlDutyType + '\'' +
                ", jnlTimeTag=" + jnlTimeTag +
                ", jnlNoteTag='" + jnlNoteTag + '\'' +
                '}';
    }
}
