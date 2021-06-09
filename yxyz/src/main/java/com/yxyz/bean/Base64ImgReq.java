package com.yxyz.bean;

import javax.validation.constraints.NotNull;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月6日 下午1:11:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月6日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="base64图片请求数据", description="base64图片请求数据")
public class Base64ImgReq 
{
	@ApiModelProperty(value = "图片的base64数据json数组")
	@NotNull(message = "上传图片不能为空")
	public JSONArray imgs;

	public JSONArray getImgs() {
		return imgs;
	}

	public void setImgs(JSONArray imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "Base64ImgReq [imgs=" + imgs + "]";
	}
	
}
