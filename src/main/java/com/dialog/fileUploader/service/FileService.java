package com.dialog.fileUploader.service;
import com.dialog.fileUploader.entity.FileInfo;
import com.dialog.fileUploader.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    public  int save(FileInfo fileInfo){

        Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
        String user1;
        fileInfo.setUploadedTime(timestamp);
        fileInfo.setName(fileInfo.getName());
        fileInfo.setUrl(fileInfo.getUrl());
       //fileInfo.setCategory(fileInfo.getCategory());
        fileInfo.setCategory("NG");
        fileInfo.setStatus("pending");
        fileInfo.setUploadedBy("11");
        return  fileRepository.save(fileInfo);
    }

}
