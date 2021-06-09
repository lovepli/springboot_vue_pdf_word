package com.yxyz.ctrler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yxyz.bean.Base64ImgReq;
import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.util.BASE64DecodedMultipartFile;
import com.yxyz.util.BaseController;
import com.yxyz.util.BaseResp;
import com.yxyz.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/***
 * @Author : Jack Fang
 */
@Controller
@RequestMapping("/uploadService/")
@CrossOrigin
@Api(value="图片上传",tags={"图片上传"})
public class UploadServerController extends BaseController {

    @Value("${my-file-path.root-path}")
    private String rootPath;

    @Value("${my-file-path.image-path}")
    private String imagePath;

    @Value("${my-file-path.file-path}")
    private String filePath;

    /**
     * 上传图片 Base64格式
     * @param request
     * @param response
     * @return
     */
    @PostMapping("uploadImgBase64")
    @ResponseBody
    @ApiOperation(value="批量图片base64上传")
    public Object uploadImgBase64(@RequestBody Base64ImgReq vo)
    {
    	List<Map<String,Object>> rs = new ArrayList<>();
    	Object[] array = vo.getImgs().toArray();
        try 
        {
			for(Object obj : array) 
			{
				 Map<String,Object> outMap = new HashMap<>();
			     // 上传图片base64
			     String imgBase64 = obj.toString();
			     
			     if (StringUtils.isEmpty(imgBase64))
			     {	// 图像数据为空
			         return BaseResp.validError("未获取到上传图片内容");
			     }
			     // 转型为MultipartHttpRequest：
			     MultipartFile file = BASE64DecodedMultipartFile.base64ToMultipart(imgBase64);
			     if (file == null) {
			            imgBase64 = "data:image/png;base64,"+imgBase64;
			            MultipartFile file2 = BASE64DecodedMultipartFile.base64ToMultipart(imgBase64);
			            if (file2 == null) {
			                return BaseResp.validError("图片base64格式转换失败。");
			            }else{
			                file = file2;
			            }
			        }
			     // 创建保存路径
			     String filePath = initFilePath(imagePath);

			     String fileName = DateUtil.getFormatDate("yyyyMMddHHmmss", new Date()) + "_"
			             + new Random().nextInt(1000);
			     String fileRealName = file.getOriginalFilename();// 原始名称
			     String[] str = fileRealName.split("\\.");
			     File uploadedFile = new File(rootPath + filePath, fileName + "." + str[str.length - 1]);
			     InputStream inputStream = file.getInputStream();
			     OutputStream out = new FileOutputStream(uploadedFile);
			     int hasread=0;
			     byte[] cache = new byte[1024];
			     while((hasread=inputStream.read(cache, 0, cache.length)) !=-1)
			     {
			    	 out.write(cache, 0, hasread);
			     }
			     inputStream.close();
			     out.close();
			     //file.transferTo(uploadedFile);
			     String imgUrl = filePath + fileName + "." + str[str.length - 1];
			     imgUrl = imgUrl.replaceAll("\\\\", "/").replaceAll("//", "/");
			     outMap.put("filePath",imgUrl);
			     outMap.put("fileName", fileRealName);
			     rs.add(outMap);
			}
			 return Result.success(rs);
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
			return Result.success(CodeMsg.SERVER_ERROR);
		}
        
    }

    /**
     * 初始化 当天文件路径 或 文件夹
     * @param path
     */
    private String initFilePath(String path)throws RuntimeException {
        try {
            // 当天日期文件夹
            String filePath = path + DateUtil.getFormatDate("yyyyMMdd", new Date()) + "/";// 头像图片保存路径
            // 文件保存目录路径
            String savePath = rootPath + filePath;
            savePath.replaceAll("\\\\", "/").replaceAll("//", "/");

            // 根目录是否存在 不存在则创建
            File saveDirFile = new File(rootPath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }
            // 判断当天文件夹是否存在 不存在则创建
            File dirFile = new File(savePath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            return filePath;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException("创建文件异常:错误的文件路径。");
        }
    }

}
