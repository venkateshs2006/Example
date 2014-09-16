package com.java.spring.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.example1.Triangle;

public class ListObject {
	public static void main(String args[]){
		//BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext factory=new ClassPathXmlApplicationContext("spring.xml");
		StuDetails stu=(StuDetails) factory.getBean("student");
		stu.display();
	}
}
