package com.yxyz.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yxyz.bean.Base64ImgReq;
import com.yxyz.exception.SysException;
import com.yxyz.rest.CodeMsg;

import sun.misc.BASE64Encoder;



/**
 * @description httpclient 工具
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class HttpUtil 
{
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    
    private static final int Format_KeyValue = 0;
    
    private static final int Format_Json = 1;
    
    private static final int SOCKET_TIMEOUT = 60 * 1000;
    
    private static final int CONN_TIMEOUT = 60 * 1000;

    /**
     * 创建HttpClient客户端
     * 
     * @param isHttps
     * @return
     */
    private static CloseableHttpClient createClient(boolean isHttps) 
    {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        
        if (isHttps) 
        {
            try 
            {
                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() 
                {
                    // 信任所有
                    @Override
                    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException 
                    {
                        return true;
                    }
                }).build();
                
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                
                httpClientBuilder.setSSLSocketFactory(sslsf);
            }
            catch (Exception e) 
            {
                e.printStackTrace();
                logger.error("创建HTTPS客户端异常");
            }
        }
        
        return httpClientBuilder.build();
    }

    /**
     * 支持 http、https协议 
     * 调用Get接口
     * @param url        接口地址
     * @param isHttps [true:https协议，false:http协议]
     * @return
     */
    public static String sendGet(String url, boolean isHttps) 
    {
    	CloseableHttpClient httpClient = createClient(isHttps);
        if (url == null || "".equals(url)) 
        {
            logger.error("接口地址为空");
            return null;
        }
        HttpGet request = null;
        try 
        {
            request = new HttpGet(url);
            
            if (httpClient == null) 
            {
                logger.error("HttpClient实例为空");
                return null;
            }
            
            setTimeOut(request);
            
            CloseableHttpResponse response = httpClient.execute(request);
            
            if (response.getStatusLine().getStatusCode() == 200) 
            {
                return EntityUtils.toString(response.getEntity());
            }
        } 
        catch (Exception e) 
        {
            logger.error("访问接口失败，接口地址为：" + url);
        } 
        finally 
        {
            if (request != null)
                request.releaseConnection();
        }
        
        return null;
    }

    /**
     * 调用Post接口
     * 
     * @param url        接口地址
     * @param params     参数
     * @param type       参数类型，0：键值对，1：json数据
     * @param isHttps    参数类型 false:http协议，true:https协议
     * @return
     */
    public static String sendPost(String url, String parameters, int type, boolean isHttps) 
    {
    	CloseableHttpClient httpClient = createClient(isHttps);
    	
        if (url == null || "".equals(url)) 
        {
            logger.error("接口地址为空");
            return null;
        }
        
        HttpPost request = null;
        
        try 
        {
            request = new HttpPost(url);
            
            if (httpClient == null) 
            {
                logger.error("HttpClient实例为空");
                return null;
            }
            
            setTimeOut(request);
            
            StringEntity entity = new StringEntity(parameters, "UTF-8");
            
            if (type == Format_KeyValue) 
            {
//                request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                entity.setContentType("application/x-www-form-urlencoded");
            }
            else if (type == Format_Json) 
            {
//                request.addHeader("Content-Type", "application/json");
                entity.setContentType("application/json");
            } 
            else 
            {
                logger.error("不支持的参数格式");
                return null;
            }
            request.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(request);
            
            if (response.getStatusLine().getStatusCode() == 200) 
            {
                return EntityUtils.toString(response.getEntity());
            }
        } 
        catch (Exception e) 
        {
            logger.error("访问接口失败，接口地址为：" + url);
            
            throw new SysException(CodeMsg.SERVER_ERROR);
        } 
        finally 
        {
            if (request != null)
                request.releaseConnection();
        }
        
        return null;
    }

    /**
     * 调用Post接口，参数为键值对方式
     * 
     * @param url        接口地址
     * @param params     键值对参数
     * @param isHttps    参数类型 false:http协议，true:https协议
     * @return
     */
    public static String sendPostByKeyValue(String url, Map<String, String> params, boolean isHttps) 
    {
    	CloseableHttpClient httpClient = createClient(isHttps);
    	
        if (url == null || "".equals(url)) 
        {
            logger.error("接口地址为空");
            return null;
        }
        
        HttpPost request = null;
        try 
        {
            request = new HttpPost(url);
            if (httpClient == null) 
            {
                logger.error("HttpClient实例为空");
                return null;
            }
            
            setTimeOut(request);
            
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            
            for (Map.Entry<String, String> entry : params.entrySet()) 
            {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            request.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            CloseableHttpResponse response = httpClient.execute(request);
            
            if (response.getStatusLine().getStatusCode() == 200)
            {
                return EntityUtils.toString(response.getEntity());
            }
        } 
        catch (Exception e) 
        {
            logger.error("访问接口失败，接口地址为：" + url);
        } 
        finally 
        {
            if (request != null)
                request.releaseConnection();
        }
        
        return null;
    }

    /**
     * 调用Post接口，参数为JSON格式
     * 
     * @param url        接口地址
     * @param params     json数据
     * @param isHttps    参数类型 false:http协议，true:https协议
     * @return
     */
    public static String sendPostByJson(String url, String params,boolean isHttps) 
    {
        return sendPost(url, params, Format_Json, isHttps);
    }
    
    /**
     *  设置 请求超时
     * @author ducl
     * @param methodType void
     * @date 2020年7月1日上午8:55:44
     */
    private static void setTimeOut(HttpRequestBase methodType)
    {
    	RequestConfig config = RequestConfig.custom()
    			.setConnectTimeout(SOCKET_TIMEOUT)
    			.setConnectionRequestTimeout(CONN_TIMEOUT)
    			.setSocketTimeout(SOCKET_TIMEOUT).build();
    	
    	methodType.setConfig(config);
    	
    }
  public static void main(String[] args) throws Exception
  {
	  InputStream in1 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test1.png");
		InputStream in2 = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test2.png");
		byte[] test1 = new byte[in1.available()];
		byte[] test2 = new byte[in2.available()];
		
		int hasread1 = 0;
		while((hasread1=in1.read(test1, 0, test1.length)) != -1)
		{
			//
		}
		
		int hasread2 = 0;
		while((hasread2=in2.read(test2, 0, test2.length)) != -1)
		{
			//
		}
		in1.close();
		in2.close();
		BASE64Encoder encoder = new BASE64Encoder();
		Base64ImgReq vo = new Base64ImgReq();
		String str1 = "data:image/png;base64,"+encoder.encode(test1);
		String str2 = "data:image/png;base64,"+encoder.encode(test2);
		JSONArray arr= new JSONArray();
		arr.add(str1);
		arr.add(str2);
		vo.setImgs(arr);
		
		String jsonString = JSONObject.toJSONString(vo);
		String sendPostByJson = sendPostByJson("http://139.159.147.237:8080/yxyz/uploadService/uploadImgBase64", jsonString, false);
		
		System.out.println("结果:"+sendPostByJson);
  }
}
