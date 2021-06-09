package com.yxyz.condit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午8:15:35 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="文章查询条件", description="文章查询条件")
public class Article_Condit 
{
	@ApiModelProperty(value = "文章类型",required = false)
	private String articletype;
	
	@ApiModelProperty(value = "创建人",required = false)
	private String createuserid;
	
	@ApiModelProperty(value = "分页页码",required = false)
	private Integer pageIndex;
	
	@ApiModelProperty(value = "分页大小",required = false)
	private Integer pageSize;
	
	public String getArticletype() {
		return articletype;
	}

	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}

	public String getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Article_Condit [articletype=" + articletype + ", createuserid=" + createuserid + ", pageIndex="
				+ pageIndex + ", pageSize=" + pageSize + "]";
	}
}
