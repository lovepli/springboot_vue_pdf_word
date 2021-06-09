package com.yxyz.util;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aspose.cells.Workbook;
import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;
import com.aspose.words.*;

public class AsposeUtil 
{
	private static Logger logger = LoggerFactory.getLogger(AsposeUtil.class);
	
	private static final String WORD = "WORD";
	private static final String EXCEL = "EXCEL";
	private static final String TXT = "TXT";
	private static final String PPT = "PPT";
	//校验license
	private static boolean judgeLicense() 
	{
		boolean result = false;
		try 
		{
			
			if(!isWindows())
			{
				/*
				 * 以下作用，解决可能linux安装字体后，也会出现转换pdf中文乱码，造成原因是 没有加载到安装的字体
				 * 若 安装字体仍出现中文乱码，则 手动指定加载字体位置。[未测试]
				 */
				FontSettings.getDefaultInstance().setFontsFolder(File.separator + "usr"+ File.separator + "share" + 
			    File.separator + "fonts" +File.separator + "windows", true);
			}
			
			InputStream is = AsposeUtil.class.getClassLoader().getResourceAsStream("pdf/license.xml");
			License aposeLic = new License();
			aposeLic.setLicense(is);
			result = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 支持 doc、docx、xls、xlsx、ppt、txt文件转换pdf
	 * @param filePath
	 * @param pdfPath
	 * @param type
	 */
	public static void trans(String filePath, String pdfPath) 
	{
		if (!judgeLicense())
		{
			logger.info("license错误");
		}
		try 
		{
			String type = "UNKNOWN";
			
			String fileType = filePath.substring(filePath.lastIndexOf(".")+1);
			
			if("XLSX".equalsIgnoreCase(fileType) || "XLS".equalsIgnoreCase(fileType))
			{
				type = EXCEL;
			}
			else if("DOC".equalsIgnoreCase(fileType) || "DOCX".equalsIgnoreCase(fileType))
			{
				type = WORD;
			}
			else if("TXT".equalsIgnoreCase(fileType))
			{
				type = "TXT";
			}
			else if("PPT".equalsIgnoreCase(fileType) || "PPTX".equalsIgnoreCase(fileType))
			{
				type = PPT;
			}
			
			logger.info("as开始：" + filePath);
			long old = System.currentTimeMillis();
			File file = new File(pdfPath);
			toPdf(file, filePath, type);
			long now = System.currentTimeMillis();
			logger.info("完成：" + pdfPath);
			logger.info("共耗时：" + ((now - old) / 1000.0) + "秒");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

	private static void toPdf(File file, String filePath, String type) 
	{
		if (WORD.equals(type) || TXT.equals(type)) 
		{
			wordofpdf(file, filePath);
		} 
		else if (EXCEL.equals(type))
		{
			exceOfPdf(file, filePath);
		} 
		else if (PPT.equals(type)) 
		{
			pptofpdf(file, filePath);
		}
		else
		{
			logger.info("暂不支持该类型："+type);
		}
	}
	/**
	 * 以文件的方法读取
	 * @param file
	 * @param filePath
	 */
	private static void wordofpdf(File file, String filePath) 
	{
		FileOutputStream os = null;
		Document doc;
		try 
		{
			os = new FileOutputStream(file);
			doc = new Document(filePath);
			doc.save(os, com.aspose.words.SaveFormat.PDF);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				os.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	private static void exceOfPdf(File file, String filePath) 
	{
		FileOutputStream os = null;
		
		try 
		{
			os = new FileOutputStream(file);
			Workbook wb = new Workbook(filePath);
			wb.save(os, com.aspose.cells.SaveFormat.PDF);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				os.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	private static void pptofpdf(File file, String filePath) 
	{
		FileOutputStream os = null;
		try 
		{
			os = new FileOutputStream(file);
			Presentation pres = new Presentation(filePath);// 输入pdf路径
			pres.save(os, SaveFormat.Pdf);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				os.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	}
	
	private static boolean isWindows()
	{
		String os = System.getProperty("os.name"); 
		
		if(os.toLowerCase().startsWith("win"))
		{  
		   return true;
		}
		
		return false;
	}
	public static void main(String[] args) 
	{
		String wordpath = "F:\\二次众联\\南京汽融\\附件6：兴业银行南京分行盐城汽融项目系统测试报告.docx";
		
		String excelpath = "C:\\Users\\Administrator\\Desktop\\CD2020004杜承隆_第33周20200817.xlsx";
		
		String savePath = "C:\\Users\\Administrator\\Desktop\\民政查询_ducl\\";
		
		trans(wordpath, savePath+"1.pdf");
		trans(excelpath, savePath+"2.pdf");
	}
}
