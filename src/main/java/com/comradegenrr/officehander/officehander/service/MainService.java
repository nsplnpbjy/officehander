package com.comradegenrr.officehander.officehander.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface MainService {
    public InputStream execFile(List<MultipartFile> multipartFileList,String clm) throws IOException;
}
