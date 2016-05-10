package com.dream.common.api.test.request;

import org.apache.commons.lang3.StringUtils;

import com.dream.common.utils.memcached.ClientMemCacheConstants;
import com.dream.common.utils.rop.RopRequest;


public class RopHelloWorldRequest extends RopRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7683393066124643022L;

    private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
	public String getCacheKey() {
		
		return StringUtils.join(ClientMemCacheConstants.ANNOTATION_CACHEKEY_CONSTANTS.HELLO_WORLD.getCacheKey(),this.username);
	}
	
	public int getCacheSecends() {
		
		return ClientMemCacheConstants.ANNOTATION_CACHEKEY_CONSTANTS.HELLO_WORLD.getCacheSecends();
	}

}
