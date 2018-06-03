package com.ant.models;

import java.util.Objects;

public class Employee {
    private int id;
    private Integer empNo;  // 员工号
    private String empName; // 姓名
    private Integer empSex; // 性别
    private String empBirthday; // 生日
    private String empTel; // 电话
    private String empEmail; // 邮箱
    private String empIdcard; // 身份证
    private Integer empDeptNo; // 所属部门
    private String empDeptName; // 所属部门名
    private Integer empRole; // 角色
    private Integer empLanguage; // 语言
    private String empEntry; // 入职事件
    private Integer empState; // 任职状态
    private Long empTimeTag;
    private String empNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public String getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(String empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpIdcard() {
        return empIdcard;
    }

    public void setEmpIdcard(String empIdcard) {
        this.empIdcard = empIdcard;
    }

    public Integer getEmpDeptNo() {
        return empDeptNo;
    }

    public void setEmpDeptNo(Integer empDeptNo) {
        this.empDeptNo = empDeptNo;
    }

    public Integer getEmpRole() {
        return empRole;
    }

    public void setEmpRole(Integer empRole) {
        this.empRole = empRole;
    }

    public Integer getEmpLanguage() {
        return empLanguage;
    }

    public void setEmpLanguage(Integer empLanguage) {
        this.empLanguage = empLanguage;
    }

    public String getEmpEntry() {
        return empEntry;
    }

    public void setEmpEntry(String empEntry) {
        this.empEntry = empEntry;
    }

    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    public Long getEmpTimeTag() {
        return empTimeTag;
    }

    public void setEmpTimeTag(Long empTimeTag) {
        this.empTimeTag = empTimeTag;
    }

    public String getEmpNoteTag() {
        return empNoteTag;
    }

    public void setEmpNoteTag(String empNoteTag) {
        this.empNoteTag = empNoteTag;
    }

    public String getEmpDeptName() {
        return empDeptName;
    }

    public void setEmpDeptName(String empDeptName) {
        this.empDeptName = empDeptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return id == that.id &&
                Objects.equals(empNo, that.empNo) &&
                Objects.equals(empName, that.empName) &&
                Objects.equals(empSex, that.empSex) &&
                Objects.equals(empBirthday, that.empBirthday) &&
                Objects.equals(empTel, that.empTel) &&
                Objects.equals(empEmail, that.empEmail) &&
                Objects.equals(empIdcard, that.empIdcard) &&
                Objects.equals(empDeptNo, that.empDeptNo) &&
                Objects.equals(empRole, that.empRole) &&
                Objects.equals(empLanguage, that.empLanguage) &&
                Objects.equals(empEntry, that.empEntry) &&
                Objects.equals(empState, that.empState) &&
                Objects.equals(empTimeTag, that.empTimeTag) &&
                Objects.equals(empNoteTag, that.empNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, empNo, empName, empSex, empBirthday, empTel, empEmail, empIdcard, empDeptNo, empRole, empLanguage, empEntry, empState, empTimeTag, empNoteTag);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empSex=" + empSex +
                ", empBirthday='" + empBirthday + '\'' +
                ", empTel='" + empTel + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empIdcard='" + empIdcard + '\'' +
                ", empDeptNo=" + empDeptNo +
                ", empDeptName='" + empDeptName + '\'' +
                ", empRole=" + empRole +
                ", empLanguage=" + empLanguage +
                ", empEntry='" + empEntry + '\'' +
                ", empState=" + empState +
                ", empTimeTag=" + empTimeTag +
                ", empNoteTag='" + empNoteTag + '\'' +
                '}';
    }
}
