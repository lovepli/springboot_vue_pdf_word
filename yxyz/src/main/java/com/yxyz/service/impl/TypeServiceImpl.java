package com.yxyz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxyz.dao.TypeDao;
import com.yxyz.service.TypeService;
import com.yxyz.vo.Type;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月11日 下午5:27:50 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月11日     ducl          v1.0.0               修改原因
*/
@Service
@Transactional
public class TypeServiceImpl implements TypeService 
{
	@Autowired
	private TypeDao typeDao;
	@Override
	public List<Type> findAll() 
	{
		return typeDao.findAll();
	}

}
