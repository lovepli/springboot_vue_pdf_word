package com.yxyz.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**    
* Copyright @ 2020 Zonlyn. All rights reserved.

* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: ducl
* @date: 2020年8月6日 上午10:17:24 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2020年8月6日     ducl          v1.0.0               修改原因
*/
public class FileUtil 
{
	/**
     * 初始化 当天文件路径 或 文件夹
     * @param rootPath http容器根目录
     * @param path
     */
    public String initFilePath(String rootPath,String path) throws RuntimeException 
    {
        try
        {
            // 当天日期文件夹
            String filePath = path + date2String(new Date(),"yyyyMMdd" ) + "/";// 头像图片保存路径
            // 文件保存目录路径
            String savePath = rootPath + filePath;
            savePath.replaceAll("\\\\", "/").replaceAll("//", "/");

            // 根目录是否存在 不存在则创建
            File saveDirFile = new File(rootPath);
            if (!saveDirFile.exists())
            {
                saveDirFile.mkdirs();
            }
            // 判断当天文件夹是否存在 不存在则创建
            File dirFile = new File(savePath);
            if (!dirFile.exists()) 
            {
                dirFile.mkdirs();
            }
            return filePath;
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            throw new RuntimeException("创建文件异常:错误的文件路径。");
        }
    }
    
    /**
	 * Date转字符串(自定义)
	 * 
	 * @Title date2String
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String date2String(Date date, String format)
	{
		return new SimpleDateFormat(format).format(date);
	}
	/**
	 * 检查目录是否存在，不存在则创建
	 * @param path
	 */
	public static void checkExistDir(String path) 
	{
		File file = new File(path);
		if (!file.isDirectory()) 
		{
			file.mkdirs();
		}
	}
}
