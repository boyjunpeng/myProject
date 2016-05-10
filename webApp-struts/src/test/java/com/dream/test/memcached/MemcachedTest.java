package com.dream.test.memcached;

import org.junit.Test;

import com.dream.common.utils.memcached.MemcachedUtil;

public class MemcachedTest {
	@Test
    public void testSet(){
		MemcachedUtil util = MemcachedUtil.getInstance();
		//util.set("username", 60, "boyjunpeng", false);
		System.out.println(util.get("username"));
    }
}
