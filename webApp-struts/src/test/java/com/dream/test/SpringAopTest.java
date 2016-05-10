package com.dream.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dream.test.aop.bean.Sleepable;

public class SpringAopTest {
	@Test
	public void testOne() {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("test-beans.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("humanProxy");
		sleeper.sleep();
	}
	@Test
	public void testAutoProxy(){
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("test-aop-autoproxy-beans.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("human");
		sleeper.sleep();
	}
	@Test
	public void testAspectj(){
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("test-aop-aspectj-beans.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("human");
		sleeper.sleep();
	}
}
