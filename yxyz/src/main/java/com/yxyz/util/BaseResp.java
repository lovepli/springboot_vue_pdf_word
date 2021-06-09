package com.yxyz.util;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;


/**
 * @Description: 基础返回类
 * @date 2018年5月21日 下午9:28:00
 */
public class BaseResp {

	public interface DefaultJsonView {
	};

	@JsonView(DefaultJsonView.class)
	private boolean rs;

	@JsonView(DefaultJsonView.class)
	private int code;

	@JsonView(DefaultJsonView.class)
	private String msg;

	@JsonView(DefaultJsonView.class)
	private Object data;

	@JsonView(DefaultJsonView.class)
	private List<?> datas;

	public BaseResp() {
		this(0);
	}

	public BaseResp(int code) {
		this.code = code;
	}

	public BaseResp(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		if (msg == null) {
			this.msg = JsonMsgUtil.getMsg(code);
		}
		if (this.msg == "") {
			this.msg = JsonMsgUtil.getMsg(999999);
		}
		return msg;
	}

	public boolean getRs() {
		rs = code == 0;
		return rs;
	}

	public boolean isRs() {
		rs = code == 0;
		return rs;
	}

	public static boolean isSuccess(BaseResp resp) {
		return resp.isRs();
	}

	/**
	 * 功能描述：请求成功
	 */
	public static BaseResp success(String msg) {
		BaseResp r = new BaseResp(0);
		r.setMsg(msg);
		return r;
	}
	
	public static BaseResp success(String msg, Object data) {
		BaseResp r = new BaseResp(0);
		r.setMsg(msg);
		r.setData(data);
		return r;
	}

	public static BaseResp success(String msg, List<?> datas) {
		BaseResp r = new BaseResp(0);
		r.setMsg(msg);
		r.setDatas(datas);
		return r;
	}
	
	public static BaseResp success(Object data) {
		BaseResp r = new BaseResp(0);
		r.setData(data);
		return r;
	}

	/**
	 * 功能描述：参数出错
	 */
	public static BaseResp paramsError(String msg) {
		BaseResp r = new BaseResp(100);
		r.setMsg(msg);
		return r;
	}

	/**
	 * 功能描述：验证出错
	 */
	public static BaseResp validError(String msg) {
		BaseResp r = new BaseResp(101);
		r.setMsg(msg);
		return r;
	}

	/**
	 * 功能描述：逻辑判断出错
	 */
	public static BaseResp logicError(String msg) {
		BaseResp r = new BaseResp(102);
		r.setMsg(msg);
		return r;
	}

	/**
	 * 功能描述：未登录
	 */
	public static BaseResp invalidLogin(String url) {
		BaseResp r = new BaseResp(9888);
		r.data = url;
		return r;
	}

	/**
	 * 功能描述：无权限
	 */
	public static BaseResp invalidPerms(String msg) {
		BaseResp r = new BaseResp(9889);
		r.setMsg(msg);
		return r;
	}

	public void setRs(boolean rs) {
		this.rs = rs;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
}
