package com.yxyz.vo;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月7日 下午8:55:56 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月7日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="注册用户信息", description="注册用户信息")
public class User 
{
	@ApiModelProperty(value = "用户编号",hidden = true)
	private Integer id;
	
	@NotBlank(message = "用户名不能为空")
	@ApiModelProperty(value = "用户名",required = true)
	private String username;
	
	@NotBlank(message = "密码不能为空")
	@ApiModelProperty(value = "密码",required = true)
	private String pwd;
	
	@ApiModelProperty(value = "是否激活标志",hidden = true)
	private Integer zt;
	
	@Email(message = "邮箱格式不正确")
	@ApiModelProperty(value = "邮箱",required = true)
	private String email;
	
	@ApiModelProperty(value = "激活码",hidden = true)
	private String code;
	
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", zt=" + zt + ", email=" + email
				+ ", code=" + code + ", createdate=" + createdate + "]";
	}

}
