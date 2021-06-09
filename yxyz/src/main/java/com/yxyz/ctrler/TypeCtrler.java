package com.yxyz.ctrler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.service.TypeService;
import com.yxyz.vo.Type;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月11日 下午5:29:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月11日     ducl          v1.0.0               修改原因
*/
@RestController
@RequestMapping("/type")
@CrossOrigin
@Api(value="柱状图数据",tags={"柱状图数据"})
public class TypeCtrler 
{
	@Autowired
	private TypeService typeService;
	
	@PostMapping("/findAll")
	@ApiOperation(value="获取全量数据")
	public Object findAll()
	{
		try
		{
			List<Type> findAll = typeService.findAll();
			
			return Result.success(findAll);
		}
		catch(Exception e)
		{
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
