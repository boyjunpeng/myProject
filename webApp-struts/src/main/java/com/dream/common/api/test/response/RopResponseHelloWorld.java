package com.dream.common.api.test.response;

import java.io.Serializable;

public class RopResponseHelloWorld implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1723808150716676068L;
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
