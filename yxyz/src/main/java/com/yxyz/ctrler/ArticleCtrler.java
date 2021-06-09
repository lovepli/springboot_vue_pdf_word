package com.yxyz.ctrler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.yxyz.condit.Article_Condit;
import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.service.ArticleService;
import com.yxyz.vo.Article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午9:18:18 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
@RestController
@RequestMapping("/article")
@CrossOrigin
@Api(value="文章管理",tags={"文章管理"})
public class ArticleCtrler 
{
	@Autowired
	private ArticleService articleService;
	
	@ApiOperation(value="添加文章")
	@PostMapping("/addarticle")
	public Object addarticle(@Valid Article vo)
	{
		try 
		{
			articleService.insert(vo);
			
			return Result.success(null);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		 return Result.error(CodeMsg.SERVER_ERROR);
	}
	
	@PostMapping("/loadPage")
	@ApiOperation(value="文章分页列表")
	public Object loadPage(@Valid Article_Condit vo)
	{
		try 
		{
			PageInfo<Article> loadPage = articleService.loadPage(vo);
			
			return Result.success(loadPage);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		 return Result.error(CodeMsg.SERVER_ERROR);
	}
}
