package com.dialog.fileUploader;

import com.dialog.fileUploader.service.FileUploadservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FileUploaderApplication implements CommandLineRunner {

	@Autowired
	FileUploadservice fileUploadservice;
	public static void main(String[] args) {
		SpringApplication.run(FileUploaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		fileUploadservice.init();
	}
}
