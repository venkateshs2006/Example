package com.java.spring.example1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class DrawingApp {
	public static void main(String args[]){
		//BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext factory=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) factory.getBean("triangle");
		//triangle.draw();
		triangle.area();
	}

}
