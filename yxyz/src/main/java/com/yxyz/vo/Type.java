package com.yxyz.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月11日 下午5:14:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月11日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="分类实体", description="分类实体")
public class Type 
{
	@ApiModelProperty(value = "主键",hidden = true)
	private Long id;
	@ApiModelProperty(value = "描述")
	private String name;
	@ApiModelProperty(value = "分类编码")
	private String category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
}
