package com.an;

import lombok.Data;

@Data
public class AjaxResponse {
	//請求結果
	private boolean isok;
	//請求結果Code
	private int code;
	//訊息
	private String message;
	//資料
	private Object data;
	
	private AjaxResponse() {}
	
	private AjaxResponse(boolean isok, int code, String message, Object data) {
		this.isok = isok;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public static AjaxResponse success(String message, Object data) {
		return new AjaxResponse(true,200,message,data);
	}
	
	public static AjaxResponse success(Object data) {
		return new AjaxResponse(true,200,"Request OK",data);
	}
	
	public static AjaxResponse SaveSuccess(String message) {
		AjaxResponse ajaxResponse=new AjaxResponse();
		ajaxResponse.setIsok(true);
		ajaxResponse.setCode(200);
		ajaxResponse.setMessage(message);
		return ajaxResponse;
	}
	
	public static AjaxResponse success() {
		AjaxResponse ajaxResponse=new AjaxResponse();
		ajaxResponse.setIsok(true);
		ajaxResponse.setCode(200);
		ajaxResponse.setMessage("Request OK");
		return ajaxResponse;
	}
	
	public static AjaxResponse Notsuccess() {
		AjaxResponse ajaxResponse=new AjaxResponse();
		ajaxResponse.setIsok(false);
		ajaxResponse.setCode(400);
		ajaxResponse.setMessage("Request NG");
		return ajaxResponse;
	}
	
}
