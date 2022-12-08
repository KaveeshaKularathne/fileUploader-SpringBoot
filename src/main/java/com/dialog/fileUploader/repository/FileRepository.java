package com.dialog.fileUploader.repository;

import com.dialog.fileUploader.entity.FileInfo;
import org.springframework.stereotype.Repository;

import java.io.File;
@Repository
public interface FileRepository{

    public int save(FileInfo fileInfo);

}
