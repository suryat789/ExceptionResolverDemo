package com.technoficent.rest.exceptions;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8240130828686736116L;
	private ExceptionLevel exceptionLevel;
	private String message;
	
	public static enum ExceptionLevel {
		SEVERE, WARNING, INFO;
	}
	
	public BusinessException(){	}
	
	public BusinessException(String message) {
        this(message, ExceptionLevel.INFO);
    }
	
	public BusinessException(Throwable cause) {
        this(cause, ExceptionLevel.INFO);
    }
	
	public BusinessException(String message, Throwable cause){
		this(message, cause, ExceptionLevel.INFO);
	}
	
	public BusinessException(String message, ExceptionLevel exceptionLevel) {
        super(message);
        this.message = message;
        this.exceptionLevel = exceptionLevel;
    }
	
	public BusinessException(Throwable cause, ExceptionLevel exceptionLevel) {
        super(cause);
        this.exceptionLevel = exceptionLevel;
    }
	
	public BusinessException(String message, Throwable cause, ExceptionLevel exceptionLevel){
		super(message, cause);
		this.message = message;
		this.exceptionLevel = exceptionLevel;
	}

	public ExceptionLevel getExceptionLevel() {
		return exceptionLevel;
	}

	public void setExceptionLevel(ExceptionLevel exceptionLevel) {
		this.exceptionLevel = exceptionLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
