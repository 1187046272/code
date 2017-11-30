package com.shr.exception;

public enum ErrorEnum {
	qita(1,"其他错误"),zhuanma(2,"转码错误"),io(3,"IO异常"),net(4,"网络异常"),fne(5,"文件未找到");
	
	private String message;
	private int code;
	
	private ErrorEnum(int code,String message) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
