package com.comradegenrr.officehander.officehander.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.comradegenrr.officehander.officehander.service.MainService;



@RestController
public class mainController {

    @Resource
    MainService mainService;
    
    @PostMapping("/upload")
    @ResponseBody
    public String getMethodName(MultipartHttpServletRequest request,HttpServletResponse response) throws IOException {
        String clm = request.getParameter("clm");
        List<MultipartFile> multipartFileList = request.getFiles("file");
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("合并结果.xlsx", "UTF-8"));
        InputStream inputStream = mainService.execFile(multipartFileList, clm);
        response.setHeader("Content-Length", ""+inputStream.available());
        OutputStream  outputStream = response.getOutputStream();
        byte[] buffer = new byte[2048];
        while(inputStream.read(buffer)!=-1){
            outputStream.write(buffer);
        }
        return "done";
    }
    

}
