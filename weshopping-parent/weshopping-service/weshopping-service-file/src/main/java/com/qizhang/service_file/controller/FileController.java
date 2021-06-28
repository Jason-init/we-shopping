package com.qizhang.service_file.controller;

import com.qizhang.common.pojo.Result;
import com.qizhang.common.pojo.StatusCode;
import com.qizhang.service_file.util.FastDFSClient;
import com.qizhang.service_file.util.FastDFSFile;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file) {
        try {
            //判断文件是否存在
            if (file == null) {
                throw new RuntimeException("文件不存在");
            }

            //获取文件完整名称
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.isEmpty(originalFilename)) {
                throw new RuntimeException("文件不存在");
            }

            //获取文件扩展名
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            //获取文件内容
            byte[] content = file.getBytes();

            //封装文件上传的实体类
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename, content, ext);

            //使用工具类进行上传并接受文件地址
            String[] upload = FastDFSClient.upload(fastDFSFile);

            //封装返回结果
            String url = FastDFSClient.getTrackerUrl() + upload[0] + "/" + upload[1];
            return new Result(true, StatusCode.OK, "文件上传成功", url);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Result(false, StatusCode.ERROR, "文件上传失败");
    }
}
