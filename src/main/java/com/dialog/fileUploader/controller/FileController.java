package com.dialog.fileUploader.controller;


import com.dialog.fileUploader.entity.FileInfo;
import com.dialog.fileUploader.message.ResponseMessage;
import com.dialog.fileUploader.repository.FileRepository;
import com.dialog.fileUploader.service.FileService;
import com.dialog.fileUploader.service.FileUploadservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("http://localhost:4200")
public class FileController {

    @Autowired
    FileUploadservice fileUploadservice;
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileUploadservice.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            //fileRepository.save(new FileInfo());

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = fileUploadservice.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @PostMapping("/fileUpload")
    public ResponseEntity<String> createFileInfo(@RequestBody FileInfo fileInfo) {
        System.out.println("working on file upload controller ");
        try {
            fileService.save(fileInfo);
              return new ResponseEntity<>("File record was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
