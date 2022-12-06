package com.dialog.fileUploader.entity;

import java.sql.Timestamp;

public class FileInfo {
    private String name;
    private String url;

    //todo add table columns
    private int tableId;
    private String uploadedBy;
    private Timestamp uploadedTime;
    private String  status;


    public FileInfo(String name, String url) {
        this.name = name;
        this.url = url;
    }

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
}
