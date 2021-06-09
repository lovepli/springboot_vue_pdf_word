package com.yxyz.util;

import java.net.MalformedURLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**    

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: admin
* @date: 2020年8月4日 上午9:12:57 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月4日     admin          v1.0.0               修改原因
*/
public class StringUtil 
{
	public static String getUuid()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 获取根目录下路径
	 * @param request
	 * @param dirs
	 * @return
	 */
	public static String getUrl(HttpServletRequest request,String dirs)
	{
		String root = request.getSession().getServletContext().getRealPath("");
		String path = "";
		if(isNullValue(root))
		{
			try 
			{
				path = request.getSession().getServletContext().getResource("/").getFile()+dirs;
			} 
			catch (MalformedURLException e) 
			{
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			path = request.getSession().getServletContext().getRealPath("") + dirs;
		}
		return path;
	}
	/**
	 * 判断是否为空
	 * @param value
	 * @return
	 */
	public static boolean isNullValue(String value) 
	{
		if (value != null && !"".equals(value.trim()))
			return false;
		else
			return true;
	}
}
