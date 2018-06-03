package com.ant.models;

import java.util.Objects;

public class Files {
    private int id;
    private String filesTitle; // 标题
    private String filesName; // 文件名
    private String filesDescribe; // 描述
    private String filesPath; // 路径
    private String filesType; // 文件类型
    private Integer filesPoster; // 发布者工号
    private String filesPosterName; // 发布者姓名
    private Long filesTime; // 发布时间
    private Long filesTimeTag;
    private String filesNoteTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilesTitle() {
        return filesTitle;
    }

    public void setFilesTitle(String filesTitle) {
        this.filesTitle = filesTitle;
    }

    public String getFilesName() {
        return filesName;
    }

    public void setFilesName(String filesName) {
        this.filesName = filesName;
    }

    public String getFilesDescribe() {
        return filesDescribe;
    }

    public void setFilesDescribe(String filesDescribe) {
        this.filesDescribe = filesDescribe;
    }

    public String getFilesPath() {
        return filesPath;
    }

    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }

    public String getFilesType() {
        return filesType;
    }

    public void setFilesType(String filesType) {
        this.filesType = filesType;
    }

    public Integer getFilesPoster() {
        return filesPoster;
    }

    public void setFilesPoster(Integer filesPoster) {
        this.filesPoster = filesPoster;
    }

    public Long getFilesTime() {
        return filesTime;
    }

    public void setFilesTime(Long filesTime) {
        this.filesTime = filesTime;
    }

    public Long getFilesTimeTag() {
        return filesTimeTag;
    }

    public void setFilesTimeTag(Long filesTimeTag) {
        this.filesTimeTag = filesTimeTag;
    }

    public String getFilesNoteTag() {
        return filesNoteTag;
    }

    public void setFilesNoteTag(String filesNoteTag) {
        this.filesNoteTag = filesNoteTag;
    }

    public String getFilesPosterName() {
        return filesPosterName;
    }

    public void setFilesPosterName(String filesPosterName) {
        this.filesPosterName = filesPosterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Files files = (Files) o;
        return id == files.id &&
                Objects.equals(filesTitle, files.filesTitle) &&
                Objects.equals(filesName, files.filesName) &&
                Objects.equals(filesDescribe, files.filesDescribe) &&
                Objects.equals(filesPath, files.filesPath) &&
                Objects.equals(filesType, files.filesType) &&
                Objects.equals(filesPoster, files.filesPoster) &&
                Objects.equals(filesTime, files.filesTime) &&
                Objects.equals(filesTimeTag, files.filesTimeTag) &&
                Objects.equals(filesNoteTag, files.filesNoteTag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, filesTitle, filesName, filesDescribe, filesPath, filesType, filesPoster, filesTime, filesTimeTag, filesNoteTag);
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", filesTitle='" + filesTitle + '\'' +
                ", filesName='" + filesName + '\'' +
                ", filesDescribe='" + filesDescribe + '\'' +
                ", filesPath='" + filesPath + '\'' +
                ", filesType='" + filesType + '\'' +
                ", filesPoster=" + filesPoster +
                ", filesPosterName='" + filesPosterName + '\'' +
                ", filesTime=" + filesTime +
                ", filesTimeTag=" + filesTimeTag +
                ", filesNoteTag='" + filesNoteTag + '\'' +
                '}';
    }
}
