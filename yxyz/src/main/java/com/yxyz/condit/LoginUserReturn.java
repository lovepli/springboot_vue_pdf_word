package com.yxyz.condit;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月28日 下午5:48:55 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月28日     ducl          v1.0.0               修改原因
*/
@ApiModel(value="登录成功返回信息", description="登录成功返回信息")
public class LoginUserReturn 
{
	@ApiModelProperty(value = "用户名")
	private String username;
	@ApiModelProperty(value = "用户角色")
	private String rolecode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

}
