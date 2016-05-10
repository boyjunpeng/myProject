package com.dream.common.utils.rop;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;


public class RopRequestBody<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -589833629810101948L;
	@JSONField(serialize=false)
	private T t ; 
	 
	public T getT(){ 
	    return t ;  
	} 
	
	public void setT(T t){  
	        this.t = t ;  
	}

}
