package com.yxyz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxyz.condit.LoginUserReturn;
import com.yxyz.dao.UserDao;
import com.yxyz.dao.UserRoleDao;
import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;
import com.yxyz.service.UserRegistService;
import com.yxyz.util.MailUtil;
import com.yxyz.vo.User;


/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月7日 下午9:28:41 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月7日     ducl          v1.0.0               修改原因
*/
@Service
public class UserRegistServiceImpl implements UserRegistService 
{

	private Logger logger = LoggerFactory.getLogger(UserRegistServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public Object regist(User vo) 
	{
		//未激活
		final Integer zt = 0;
		//生成 验证码 code
		String code = UUID.randomUUID().toString().replace("-", "");
		
		vo.setCode(code);
		vo.setZt(zt);
		vo.setCreatedate(new Date());
		
		User findByUserName = userDao.findByUserName(vo.getUsername());
		
		if(null != findByUserName)
		{
			logger.error("error:注册用户名:[{}],已存在",vo.getUsername());
			
			return Result.error(CodeMsg.USEREXISTS);
		}
		
		userDao.insert(vo);
		
		try 
		{
			new MailUtil(vo.getEmail(), code).run();
		} 
		catch (Exception e) 
		{
			logger.error("error:发送邮件失败");
			
			throw new RuntimeException("发送邮件失败");
		}
		
		return Result.error(CodeMsg.REGIST_SUCCESS);
	}

	@Override
	public Object update(String code)
	{
		userDao.update(code);
		
		return Result.error(CodeMsg.ACTIVE_SUCCESS);
	}

	@Override
	public Object login(String username, String pwd) 
	{
		Map<String,String> map = new HashMap<>(3);
		
		map.put("username", username);
		map.put("pwd", pwd);
		
		User findByNameAndPwd = userDao.findByNameAndPwd(map);
		
		if(null == findByNameAndPwd)
		{
			return Result.error(CodeMsg.USENOTREXISTS);
		}
		
		
		LoginUserReturn findByUserId = userRoleDao.findByUserId(findByNameAndPwd.getId());
		
		return Result.success(findByUserId);
		
	}

}
