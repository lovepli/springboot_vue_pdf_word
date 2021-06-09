package com.yxyz.ctrler;

import java.io.FileOutputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.util.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月17日 下午9:47:16 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月17日     ducl          v1.0.0               修改原因
*/
@RestController
@RequestMapping("/filesupload")
@CrossOrigin
@Api(value="批量文件上传",tags={"批量文件上传"})
public class FileUploadCtrler 
{
	@Value("${web.oring-save-path}")
	private String savePath;
	@PostMapping("/filesUpload")
	@ApiOperation(value="批量文件上传")
	public Object filesUpload(MultipartFile[] files) throws Exception
	{
		if(null == files || files.length == 0)
		{
			return Result.error(CodeMsg.NOFILEUPLOAD);
		}
		for(MultipartFile file : files)
		{
			/*
			 * 保存上传文件
			 */
			//文件存储名
			//源文件名
			String orinName = file.getOriginalFilename();
			String preName = StringUtil.getUuid();
			String stuffName = orinName.substring(orinName.lastIndexOf("."));
			String svName = preName + stuffName;
			
			byte[] cache = new byte[1024];
			int hasRead = 0;
			InputStream in = file.getInputStream();
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
		}
		
		return Result.success(null);
	}
}
