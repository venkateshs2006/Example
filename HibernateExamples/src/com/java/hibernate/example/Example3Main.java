package com.java.hibernate.example;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.java.hibernate.example3.pojo.Address;
import com.java.hibernate.example3.pojo.User;

public class Example3Main {
	public static void main(String args[]) {
		User user = new User();
		Address address=new Address();
		address.setDoorNo("20");
		address.setStreet("Main road");
		address.setCity("Chennai");
		address.setState("tamilnadu");
		address.setCountry("India");
		//user.setUserId(1);
		user.setEmail("a@gmail.com");
		user.setUserName("a");
		user.setPassword("pwd");
		user.setDob(new Date());
		//user.setHomeAddress(address);
		//user.setOfficeAddress(address);
		Set<Address> setOfAddress=new HashSet<Address>();
		setOfAddress.add(address);
		address.setDoorNo("21");
		setOfAddress.add(address);
		user.setAddress(setOfAddress);		
		SessionFactory sessionFactory = new Configuration().configure()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		User getUser = (User) session.get(User.class, 1);
		System.out.println(getUser.toString());
	}
}
