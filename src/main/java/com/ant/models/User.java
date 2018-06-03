package com.ant.models;

import java.util.Objects;

public class User {
    private int id;
    private String userName; // 登录名
    private String userPassword; // 登录密码
    private Integer userType; // 用户类型 1 职员；2顾客；3 系统管理员
    private String userAlias; // 别名（姓名）
    private String userTel; // 电话
    private String userEmail; // 邮箱
    private Long userTimeTag;
    private String userNoteTag;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserTimeTag() {
        return userTimeTag;
    }

    public void setUserTimeTag(Long userTimeTag) {
        this.userTimeTag = userTimeTag;
    }

    public String getUserNoteTag() {
        return userNoteTag;
    }

    public void setUserNoteTag(String userNoteTag) {
        this.userNoteTag = userNoteTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userType, user.userType) &&
                Objects.equals(userAlias, user.userAlias) &&
                Objects.equals(userTel, user.userTel) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userTimeTag, user.userTimeTag) &&
                Objects.equals(userNoteTag, user.userNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, userPassword, userType, userAlias, userTel, userEmail, userTimeTag, userNoteTag);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType=" + userType +
                ", userAlias='" + userAlias + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userTimeTag=" + userTimeTag +
                ", userNoteTag='" + userNoteTag + '\'' +
                '}';
    }
}
