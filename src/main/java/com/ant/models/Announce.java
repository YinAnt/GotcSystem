package com.ant.models;

import java.util.Objects;

public class Announce {
    private int id;
    private String ancTitle; // 公告标题
    private Long ancCreateTime; // 创建时间
    private Integer ancPoster; // 发布者
    private String ancPosterName; // 发布者姓名
    private String ancType; // 公告类型
    private String ancContent; // 公告内容
    private Long ancTimeTag;
    private String ancNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAncTitle() {
        return ancTitle;
    }

    public void setAncTitle(String ancTitle) {
        this.ancTitle = ancTitle;
    }

    public Long getAncCreateTime() {
        return ancCreateTime;
    }

    public void setAncCreateTime(Long ancCreateTime) {
        this.ancCreateTime = ancCreateTime;
    }

    public Integer getAncPoster() {
        return ancPoster;
    }

    public void setAncPoster(Integer ancPoster) {
        this.ancPoster = ancPoster;
    }


    public String getAncType() {
        return ancType;
    }

    public void setAncType(String ancType) {
        this.ancType = ancType;
    }

    public String getAncContent() {
        return ancContent;
    }

    public void setAncContent(String ancContent) {
        this.ancContent = ancContent;
    }

    public Long getAncTimeTag() {
        return ancTimeTag;
    }

    public void setAncTimeTag(Long ancTimeTag) {
        this.ancTimeTag = ancTimeTag;
    }

    public String getAncNoteTag() {
        return ancNoteTag;
    }

    public void setAncNoteTag(String ancNoteTag) {
        this.ancNoteTag = ancNoteTag;
    }

    public String getAncPosterName() {
        return ancPosterName;
    }

    public void setAncPosterName(String ancPosterName) {
        this.ancPosterName = ancPosterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announce that = (Announce) o;
        return id == that.id &&
                Objects.equals(ancTitle, that.ancTitle) &&
                Objects.equals(ancCreateTime, that.ancCreateTime) &&
                Objects.equals(ancPoster, that.ancPoster) &&
                Objects.equals(ancType, that.ancType) &&
                Objects.equals(ancContent, that.ancContent) &&
                Objects.equals(ancTimeTag, that.ancTimeTag) &&
                Objects.equals(ancNoteTag, that.ancNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ancTitle, ancCreateTime, ancPoster, ancType, ancContent, ancTimeTag, ancNoteTag);
    }

    @Override
    public String toString() {
        return "Announce{" +
                "id=" + id +
                ", ancTitle='" + ancTitle + '\'' +
                ", ancCreateTime=" + ancCreateTime +
                ", ancPoster=" + ancPoster +
                ", ancPosterName='" + ancPosterName + '\'' +
                ", ancType='" + ancType + '\'' +
                ", ancContent='" + ancContent + '\'' +
                ", ancTimeTag=" + ancTimeTag +
                ", ancNoteTag='" + ancNoteTag + '\'' +
                '}';
    }
}
