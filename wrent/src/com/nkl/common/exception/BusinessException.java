package com.nkl.common.exception;

public class BusinessException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2003893000369522428L;

	/**
     * 构造.
     * @param msg 错误信息.
     */
    public BusinessException(String msg) {
        super(msg);
    }
    
    /**
     * 构造.
     * @param msg 错误信息
     * @param t 前一异常
     */
    public BusinessException(String msg, Throwable t) {
        super(msg, t);
        
        this.setStackTrace(t.getStackTrace());
    }
}