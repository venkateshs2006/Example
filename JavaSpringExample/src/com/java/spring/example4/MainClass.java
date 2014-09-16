package com.java.spring.example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.spring.example3.UserDetails;

public class MainClass {
	public static void main(String args[]){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		UserDetails userDetails=context.getBean("userDetails", UserDetails.class);
		userDetails.display();
	}
}
