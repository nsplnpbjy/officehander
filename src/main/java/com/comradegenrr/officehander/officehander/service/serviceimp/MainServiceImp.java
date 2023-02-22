package com.comradegenrr.officehander.officehander.service.serviceimp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.comradegenrr.officehander.officehander.service.MainService;
import com.comradegenrr.officehander.officehander.util.MergeUtil;

@Service
public class MainServiceImp implements MainService{

    @Resource
    MergeUtil mergeUtil;

    @Override
    public InputStream execFile(List<MultipartFile> multipartFileList, String clm) throws IOException {
        return mergeUtil.mergeTwo(multipartFileList, clm);
    }
    
}
