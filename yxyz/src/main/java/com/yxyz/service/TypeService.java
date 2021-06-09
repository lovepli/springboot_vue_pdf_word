package com.yxyz.service;
import java.util.List;

import com.yxyz.vo.Type;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月11日 下午5:26:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月11日     ducl          v1.0.0               修改原因
*/
public interface TypeService 
{
	/**
	 * 直接查询所有的数据
	 * @return
	 */
	List<Type> findAll();
}
