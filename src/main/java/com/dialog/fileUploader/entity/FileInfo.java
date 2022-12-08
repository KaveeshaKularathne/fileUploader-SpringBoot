package com.dialog.fileUploader.entity;

import java.sql.Timestamp;


public class FileInfo {
    private String name;
    private String url;
    private String category;
    private String uploadedBy;
    private Timestamp uploadedTime;
    private String  status;


    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public FileInfo(String name, String url,String category, String uploadedBy, Timestamp uploadedTime, String status) {
        this.name = name;
        this.url = url;
        this.category = category;
        this.uploadedBy = uploadedBy;
        this.uploadedTime = uploadedTime;
        this.status = status;
    }
    public FileInfo() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Timestamp getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(Timestamp uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
