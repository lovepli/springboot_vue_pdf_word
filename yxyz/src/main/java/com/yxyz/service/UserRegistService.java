package com.yxyz.service;

import com.yxyz.vo.User;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月7日 下午9:21:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月7日     ducl          v1.0.0               修改原因
*/
public interface UserRegistService 
{
	Object regist(User vo); 
	
	Object update(String code);
	
	Object login(String username,String pwd);
}
