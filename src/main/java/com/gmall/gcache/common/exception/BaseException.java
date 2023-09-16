package com.gmall.gcache.common.exception;

import com.gmall.gcache.common.response.ResponseEnum;

/**
 * 通用异常类
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Object object;

	private ResponseEnum responseEnum;

	public BaseException(String msg) {
		super(msg);
	}

	public BaseException(String msg, Object object) {
		super(msg);
		this.object = object;
	}

	public BaseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BaseException(ResponseEnum responseEnum) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
	}

	public BaseException(ResponseEnum responseEnum, Object object) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
		this.object = object;
	}


	public Object getObject() {
		return object;
	}

	public ResponseEnum getResponseEnum() {
		return responseEnum;
	}

}
