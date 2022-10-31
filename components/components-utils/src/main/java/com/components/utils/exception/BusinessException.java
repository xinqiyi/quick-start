package com.components.utils.exception;

public class BusinessException extends RuntimeException{
    /**
	 */
	private static final long serialVersionUID = -2338814209828437720L;
	protected String errorCode;
	
	public BusinessException(String msg, Throwable t) {
		super(msg, t);
	}

	public BusinessException(String errorCode,String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	public BusinessException() {
	}

	public BusinessException(String msg) {
		super(msg);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}
}
