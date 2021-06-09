package com.yxyz.service;

import com.github.pagehelper.PageInfo;
import com.yxyz.condit.Article_Condit;
import com.yxyz.vo.Article;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午9:10:36 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
public interface ArticleService 
{
	void insert(Article vo);
	
	PageInfo<Article> loadPage(Article_Condit vo);
}
