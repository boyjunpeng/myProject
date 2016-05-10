package com.dream.common.exception;
/**
 * 自定义rop异常
 * @author dengcheng
 *
 */
public class RopException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7115081616648590439L;

	public RopException() {
    }

    public RopException(String message) {
        super(message);
    }

    public RopException(String message, Throwable cause) {
        super(message, cause);
    }

    public RopException(Throwable cause) {
        super(cause);
    }
}
