package com.yxyz.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yxyz.rest.CodeMsg;
import com.yxyz.rest.Result;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年7月7日 下午9:16:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年7月7日     ducl          v1.0.0               修改原因
*/
@RestControllerAdvice
public class GloabException 
{
	private Logger logger = LoggerFactory.getLogger(GloabException.class);
	/**
	 * 参数验证处理
	 * @param e
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String MethodArgumentNotValiExceptionHandler(MethodArgumentNotValidException e)
	{
		logger.info("参数验证失败:[{}]",e);
		
		ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
		
		return objectError.getDefaultMessage();
	}
	
	/**
	 * 未知异常拦截
	 * @param e
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public Object ExceptionHandler(Exception e)
	{
		logger.error("未知异常:[{}]",e.getMessage());
		
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	
	
}
