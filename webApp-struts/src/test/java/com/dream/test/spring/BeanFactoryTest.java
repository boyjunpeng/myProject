package com.dream.test.spring;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.dream.test.vs.PersonService;
public class BeanFactoryTest {
   @Test
   public void testDefaultListableBeanFactory(){
	   ClassPathResource res = new ClassPathResource("test-beans.xml");
	   DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	   XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	   reader.loadBeanDefinitions(res);
	   PersonService obj = (PersonService)factory.getBean("personService");
	   System.out.println(obj.getPersionInfo().toString());
	   
   }
}
