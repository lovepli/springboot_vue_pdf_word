package com.yxyz.dao;

import org.springframework.stereotype.Repository;

import com.yxyz.condit.LoginUserReturn;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月28日 下午5:44:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月28日     ducl          v1.0.0               修改原因
*/
@Repository
public interface UserRoleDao 
{
	LoginUserReturn findByUserId(Integer id);
}
