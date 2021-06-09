package com.yxyz.ctrler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.util.AsposeUtil;
import com.yxyz.util.FileUtil;
import com.yxyz.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月17日 下午6:26:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月17日     ducl          v1.0.0               修改原因
*/
@RestController
@RequestMapping("/filetopaf")
@CrossOrigin
@Api(value="文件上传转pdf预览",tags={"文件上传转pdf预览"})
public class UploadParsePdfCtrler 
{
	//源文件存储位置
	@Value("${web.oring-save-path}")
	private String savePath;
	//生成pdf缓存位置
	@Value("${web.upload-path}")
	private String pdftemppath;
	//项目访问名称
	@Value("${server.servlet.context-path}")
	private String projName;
	
	@PostMapping("/uploadtopdf")
	@ApiOperation(value="批量文件上传转pdf预览")
	public Object uploadToPdf(HttpServletRequest request,MultipartFile[] file) throws Exception
	{
		if(null == file || file.length == 0)
		{
			return Result.error(CodeMsg.NOFILEUPLOAD);
		}
		//判断是否配置了项目名称
		projName = StringUtils.isEmpty(projName)?"":projName;
		//缓存 文件存储名、源名称对应关系、预览地址
		List<Map<String,String>> saveName_orinName_Url = new ArrayList<>();
		
		FileUtil.checkExistDir(savePath);
		FileUtil.checkExistDir(pdftemppath);
		
		for(MultipartFile fl : file)
		{
			/*
			 * 保存上传文件
			 */
			//文件存储名
			//源文件名
			String orinName = fl.getOriginalFilename();
			String preName = StringUtil.getUuid();
			String stuffName = orinName.substring(orinName.lastIndexOf("."));
			String svName = preName + stuffName;
			
			byte[] cache = new byte[1024];
			int hasRead = 0;
			InputStream in = fl.getInputStream();
			FileOutputStream out = new FileOutputStream(savePath+svName);
			while((hasRead=in.read(cache, 0, cache.length)) != -1)
			{
				out.write(cache, 0, hasRead);
			}
			out.flush();
			if(null != out)
			{
				out.close();
			}
			if(null != in)
			{
				in.close();
			}
			/*
			 * 上传文件转换pdf，存储至 ${web.upload-path}
			 */
			String pdfSaveName = pdftemppath+preName+".pdf";
			
			if(".pdf".equalsIgnoreCase(stuffName))
			{
				//直接把pdf文件存储到静态资源目录下
				FileInputStream pdfIn = new FileInputStream(savePath+svName);
				FileOutputStream pdfOut = new FileOutputStream(pdfSaveName);
				byte[] pdfCache = new byte[1024];
				int pdfHasRead = 0;
				while((pdfHasRead=pdfIn.read(pdfCache, 0, pdfCache.length)) != -1)
				{
					pdfOut.write(pdfCache, 0, pdfHasRead);
				}
				pdfOut.flush();
				if(null != pdfOut)
				{
					pdfOut.close();
				}
				if(null != pdfIn)
				{
					pdfIn.close();
				}
			}
			else
			{
				AsposeUtil.trans(savePath+svName, pdfSaveName);
			}
			
			String httpUrl = request.getScheme() + "://" + request.getServerName()
			   + ":" + request.getServerPort() +projName+"/"+ preName+".pdf";
			
			Map<String,String> rs = new HashMap<>();
			rs.put("oldname", orinName);
			rs.put("newname", preName+".pdf");
			rs.put("url", httpUrl);
			
			saveName_orinName_Url.add(rs);
			
		}
		
		return Result.success(saveName_orinName_Url);
	}
}
