package com.yxyz.util;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseController {

    protected final int START_UP = 1;

    protected final int EXECUTE = 2;


    /**
     * 封装分页参数
     * @param // limit,page(一页显示条数，当前页数)
     * @return
     */
    public Map<String, Object> pageOffset(Map<String, Object> map) {
        if(map.containsKey("LIMIT") && map.containsKey("PAGE")) {
            int limit = Integer.parseInt(map.get("LIMIT")+"");
            int page = Integer.parseInt(map.get("PAGE")+"");
            map.put("OFFSET", (page-1)*limit);
        }
        return map;
    }

    /**
     * 封装data成功返回（带结果集和提示的返回）
     * @param data
     * @return
     */
    public Map<String, Object> successReturn(Object data,String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("success", true);
        map.put("data", data);
        return map;
    }

    /**
     * Map成功返回
     * @param rsMap
     * @return
     */
    public Map<String, Object> successMap(Map<String, Object> rsMap) {
        if(rsMap==null) {
            rsMap = new HashMap<String,Object>();
        }
        rsMap.put("success", true);
        return rsMap;
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public Map<String,Object> failModelMap(String message){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("message", message);
        modelMap.put("success", false);
        return modelMap;
    }

    /**
     * 成功返回
     * @param message
     * @return
     */
    public Map<String,Object> successModelMap(String message){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("message", message);
        modelMap.put("success", true);
        return modelMap;
    }


    /**
     * 获取登录用户id
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getUserID(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_UC_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("userInfoId"));
    }

    /**
     * 获取用户名
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getUserName(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_UC_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("username"));
    }

    /**
     * 获取用户真实名称
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getRealName(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_UC_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("realname"));
    }

    /**
     * 获取登录租户
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getTenantID(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_TENANT_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("tenantCode"));
    }

    /**
     * 获取登录部门id
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getDepartmentId(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_DEPARTMENT_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("departmentId"));
    }

    /**
     * 获取登录部门名称
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getDepartmentName(HttpServletRequest request) {
        Map<String, Object> DOONE_UC_SESSION = (Map<String, Object>) request.getSession().getAttribute("DOONE_DEPARTMENT_SESSION");

        return String.valueOf(DOONE_UC_SESSION.get("departmentName"));
    }

    public Map<String, Object> getRequestParams(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();

        String paramName;
        String[] paramValue;
        String[] strArray;

        while (paramNames.hasMoreElements()) {
            paramName = paramNames.nextElement();
            strArray = paramName.split("\\.");
            paramValue = request.getParameterValues(paramName);
            String value = null;

            for (String str : paramValue) {
                if (StringUtils.isEmpty(value)) value = str; else value += "," + str;
            }

            if (strArray.length > 1) {
                map.put(strArray[1], value);
                returnMap.put(strArray[0], map);
            } else {
                returnMap.put(paramName, value);
            }
        }

        return returnMap;
    }
    /**
     * 获取request参数（处理中文乱码问题）
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getMapData(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        //获取所有参数的名称
        Enumeration enumeration = request.getParameterNames();
        //遍历所有参数--转换成map对象
        while (enumeration.hasMoreElements()) {
            Object object = enumeration.nextElement();
            String value = "";
            value = request.getParameter(object.toString());
            if(!isChineseChar(value)){
                try {
                    value = new String(request.getParameter(object.toString()).getBytes("ISO-8859-1"),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            map.put(object.toString(), value);
        }
        return map;
    }

    /**
     * 判断是否为中文，处理乱码
     * @param str
     * @return
     */
    private  boolean isChineseChar(String str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m=p.matcher(str);
        if(m.find()){
            temp =  true;
        }
        return temp;
    }

    /**
     * 获得项目工程的绝对路径
     */
    public static String getWebRoot(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    /**
     * 获得发布后的jar当前路径
     */
    public String getJarRoot(){
        ApplicationHome home = new ApplicationHome(getClass());
        File jarFile = home.getSource();
        return jarFile.getParentFile().getPath();
    }

    /**
     * 将图片放入流
     * @param httpResponse
     * @param imgPath
     */
    public void outPutImg(HttpServletResponse httpResponse, String imgPath){
        httpResponse.setHeader("Pragma", "No-cache");
        httpResponse.setHeader("Cache-Control", "no-cache");
        httpResponse.setDateHeader("Expires", 0);
        httpResponse.setContentType("image/jpg");

        ServletOutputStream out = null;
        FileInputStream ips = null;

        try {
            //获取图片存放路径
            ips = new FileInputStream(new File(imgPath));
            //读取文件流
            out = httpResponse.getOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                ips.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取所有参数
     * @author jack
     * @param request
     * @return
     */
    public Map<String, Object> getParams(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        Set<String> key = request.getParameterMap().keySet();
        for (Iterator<String> it = key.iterator(); it.hasNext();) {
            String name = (String) it.next();
            Object[] value = (Object[]) request.getParameterMap().get(name);
            if (value.length == 1) {
                if ((value[0] != null) && (value[0].toString().length() > 0)) {
                    params.put(name, value[0]);
                }
            } else if (value.length > 1) {
                String values = "";
                for (Object object : value) {
                    if(StringUtils.isEmpty(object)) {
                        continue;
                    }
                    values = values + object.toString() + ",";
                }
                params.put(name, values.substring(0, values.length()-1));
            }
        }
        return params;
    }

}
