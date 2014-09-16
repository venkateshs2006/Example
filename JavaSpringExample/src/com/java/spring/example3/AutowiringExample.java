package com.java.spring.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringExample {
	public static void main(String args[]){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		UserDetails userDetails=context.getBean("userDetails", UserDetails.class);
		
		userDetails.display();
	}
}
