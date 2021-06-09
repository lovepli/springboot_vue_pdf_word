package com.yxyz.exception;

import com.yxyz.rest.CodeMsg;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 系统异常
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年6月16日 下午3:31:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年6月16日     ducl          v1.0.0               修改原因
*/
public class SysException extends RuntimeException
{

	private static final long serialVersionUID = -7758988925110723264L;
	
	private CodeMsg codeMsg;
	
	public SysException(CodeMsg codeMsg)
	{
		this.codeMsg = codeMsg;
	}

	public CodeMsg getCodeMsg() {
		return codeMsg;
	}

	public void setCodeMsg(CodeMsg codeMsg) {
		this.codeMsg = codeMsg;
	}
	

}
