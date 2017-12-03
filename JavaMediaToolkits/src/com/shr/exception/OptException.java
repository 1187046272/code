package com.shr.exception;

/**
 * @author 孙浩然
 * 自定义异常类
 */
public class OptException extends Exception{

	private static final long serialVersionUID = 1L;
	ErrorEnum ee;
	
	public OptException(ErrorEnum ee) {
		super();
		this.ee = ee;
	}

	public void message(ErrorEnum ee){
		System.out.println("msg:" + ee.getMessage() + "--- code:" + ee.getCode());
	}

	@Override
	public String getMessage() {
		return ee.getMessage() + "\n" + super.getMessage();
	}

	@Override
	public String toString() {
		return "{\"code\":\"" + ee.getCode() + "\",\"msg\",\"" + ee.getMessage() + "\"}\n";
	}

	@Override
	public void printStackTrace() {
		System.err.println("打印错误堆栈：");
		super.printStackTrace();
	}
	
	
}
