package com.yxyz.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午6:46:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="发布文章", description="发布文章")
public class Article implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "文章编号",hidden = true)
	private Long id;
	
	@ApiModelProperty(value = "文章标题",required = true)
	@NotBlank(message = "标题不能为空")
	private String title;
	
	@ApiModelProperty(value = "文章描述",required = true)
	@NotBlank(message = "文章描述不能为空")
	private String description;
	
	@ApiModelProperty(value = "文章内容",required = true)
	@NotBlank(message = "文章内容不能为空")
	private String content;
	
	@ApiModelProperty(value = "文章类型",required = false)
	private String articletype;
	
	@ApiModelProperty(value = "创建时间",hidden = true)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
	private Timestamp createdatetime;
	
	@ApiModelProperty(value = "创建人",hidden = true)
	private String createuserid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}

	public String getCreateuserid() {
		return createuserid;
	}

	public void setCreateuserid(String createuserid) {
		this.createuserid = createuserid;
	}

	
	public String getArticletype() {
		return articletype;
	}

	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", articletype=" + articletype + ", createdatetime=" + createdatetime + ", createuserid="
				+ createuserid + "]";
	}

}
