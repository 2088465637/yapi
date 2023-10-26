package com.yuanchanglin.yapi.controller;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.yuanchanglin.yapi.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuanchanglin
 * @since 2019-04-22
 */
@Api(value="文件上传",tags={"文件上传操作接口"})
@RestController
public class UploadController {

    private static final String END_POINT= "https://oss-cn-chengdu.aliyuncs.com";
    private static final String ACCESS_KEY_ID= "LTAI5tEGL5bTamgTLhM9SPHq";
    private static final String ACCESS_KEY_SECRET= "2jlbwpbkFFp11hi4lvZpSy9aNTLY4L";
    private static final String bucketName = "y-stu";

    @ApiParam(value = "图片上传")
    @PostMapping("/upload")
    public ResultVo fileUpload(HttpServletRequest request, String typeName) {
        try {
            // 配置上传参数
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            // 迭代表单数据
            for (FileItem item : formItems) {
                // 处理不在表单中的字段
                if (!item.isFormField()) {
                    String fileName = item.getName();
                    //定义上传文件的存放路径
                    String objectName = "files/"+typeName+"/"+fileName;
                    OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
                    ossClient.putObject(bucketName, objectName, item.getInputStream());
                    ossClient.shutdown();
                    System.out.println("https://y-stu.oss-cn-chengdu.aliyuncs.com/"+objectName);
                    return ResultVo.successResult("https://y-stu.oss-cn-chengdu.aliyuncs.com/"+objectName);
                }
            }
            return ResultVo.successResult();
        } catch (Exception ex) {
            System.out.println(ex);
            return ResultVo.errorResult("上传失败");
        }
    }
    @ApiParam(value = "图片上传")
    @PostMapping("/editorUpload")
    public Map editorUpload(HttpServletRequest request, String typeName) {
        Map result =  new HashMap<String,Object>();
        try {
            // 配置上传参数
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            // 迭代表单数据
            for (FileItem item : formItems) {
                // 处理不在表单中的字段
                if (!item.isFormField()) {
                    String fileName = item.getName();
                    //定义上传文件的存放路径
                    String objectName = "files/"+typeName+"/"+System.currentTimeMillis()+fileName;
                    OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
                    ossClient.putObject(bucketName, objectName, item.getInputStream());
                    ossClient.shutdown();
                    System.out.println("https://y-stu.oss-cn-chengdu.aliyuncs.com/"+objectName);
                    Map data =  new HashMap<String,Object>();
                    data.put("url","https://y-stu.oss-cn-chengdu.aliyuncs.com/"+objectName);
                    result.put("data",data);
                    result.put("errno",0);
                    return result;
                }
            }
            result.put("message","上传失败");
            result.put("errno",1);
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
            result.put("message","上传失败");
            result.put("errno",1);
            return result;
        }
    }


}