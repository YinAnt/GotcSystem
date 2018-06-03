package com.ant.models;

import java.util.Objects;

public class Department {
    private int id;
    private int deptNo; // 部门号
    private String deptName; // 部门名
    private Integer deptLeader; // 部门经理
    private Long deptTimeTag;
    private String deptNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(Integer deptLeader) {
        this.deptLeader = deptLeader;
    }

    public Long getDeptTimeTag() {
        return deptTimeTag;
    }

    public void setDeptTimeTag(Long deptTimeTag) {
        this.deptTimeTag = deptTimeTag;
    }

    public String getDeptNoteTag() {
        return deptNoteTag;
    }

    public void setDeptNoteTag(String deptNoteTag) {
        this.deptNoteTag = deptNoteTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                deptNo == that.deptNo &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(deptLeader, that.deptLeader) &&
                Objects.equals(deptTimeTag, that.deptTimeTag) &&
                Objects.equals(deptNoteTag, that.deptNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, deptNo, deptName, deptLeader, deptTimeTag, deptNoteTag);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", deptLeader=" + deptLeader +
                ", deptTimeTag=" + deptTimeTag +
                ", deptNoteTag='" + deptNoteTag + '\'' +
                '}';
    }
}
