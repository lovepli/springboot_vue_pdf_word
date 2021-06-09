package com.yxyz.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxyz.condit.Article_Condit;
import com.yxyz.dao.ArticleDao;
import com.yxyz.service.ArticleService;
import com.yxyz.vo.Article;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午9:11:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService 
{
	@Autowired
	private ArticleDao articleDao;
	@Override
	public void insert(Article vo) 
	{
		vo.setCreatedatetime(new Timestamp(new Date().getTime()));
		vo.setCreateuserid("system");
		articleDao.save(vo);
	}

	@Override
	public PageInfo<Article> loadPage(Article_Condit vo) 
	{
		PageHelper.startPage(vo.getPageIndex()==null?0:vo.getPageIndex(), vo.getPageSize()==null?0:vo.getPageSize());
		
		List<Article> findByCondit = articleDao.findByCondit(vo);
		
		return new PageInfo<Article>(findByCondit);
	}

}
