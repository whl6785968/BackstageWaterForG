package com.sandalen.water.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    public static String addMultipartFile(MultipartFile file,String pathAppend) throws IOException {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","");

        if(file == null){
            return null;
        }

        String path = null;
        String type = null;

        String originalFilename = file.getOriginalFilename();
        type = originalFilename.substring(originalFilename.lastIndexOf("."));

        String realPath = "static/";
        realPath = pathAppend + realPath;

        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        else {
            System.out.println("文件目录已存在");
        }

        path = realPath + uuid + type;
        System.out.println("最终文件上传路径为:" + path);
        file.transferTo(new File(path));
        System.out.println("文件已经上传至指定目录");

//        "/static/"+uuid+type
        return path;
    }

    public static boolean deleteFile(String path){
        File file = new File(path);
        boolean isDelete = false;
        if(file.exists()){
            isDelete = file.delete();
            System.out.println("文件" + path + "已经删除");
        }

        return isDelete;

    }
}
