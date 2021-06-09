package com.yxyz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yxyz.condit.Article_Condit;
import com.yxyz.vo.Article;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月23日 下午6:52:28 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月23日     ducl          v1.0.0               修改原因
*/
@Repository
public interface ArticleDao 
{
	void save(Article vo);
	
	List<Article> findByCondit(Article_Condit vo);
}
