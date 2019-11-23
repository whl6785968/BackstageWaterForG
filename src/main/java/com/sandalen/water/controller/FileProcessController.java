package com.sandalen.water.controller;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.other.Constants;
import com.sandalen.water.util.UploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileProcessController {

    @RequestMapping("/uploadPic")
    public RespBean uploadPic(MultipartFile file) throws IOException {
        String path = UploadUtils.addMultipartFile(file, Constants.PIC_PATH_APPEND);
        return RespBean.ok("上传成功",path);
    }

    @RequestMapping("/deletePic")
    public RespBean deletePic(String path) throws IOException{
        path = Constants.PIC_PATH_APPEND + path;
        boolean isDelete = UploadUtils.deleteFile(path);
        if(isDelete){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
