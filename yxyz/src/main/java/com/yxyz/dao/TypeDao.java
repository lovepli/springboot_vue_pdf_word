package com.yxyz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.yxyz.vo.Type;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月11日 下午5:14:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月11日     ducl          v1.0.0               修改原因
*/
@Repository
public interface TypeDao 
{
	List<Type> findAll();
}
