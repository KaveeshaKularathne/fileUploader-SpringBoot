package com.dialog.fileUploader.repository;

import com.dialog.fileUploader.entity.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(FileInfo fileInfo) {
        return jdbcTemplate.update("INSERT INTO file_upload (file_name,file_category,status,upload_by,upload_at) VALUES(?,?,?,?,?)",
                new Object[] {
                        fileInfo.getName(),
                        fileInfo.getCategory(),
                        fileInfo.getStatus(),
                        fileInfo.getUploadedBy(),
                        fileInfo.getUploadedTime()});

    }
}
