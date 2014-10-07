package com.java.hibernate.example;

import java.io.File;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.java.hibernate.example1.pojo.User;

public class Example1Main {
	public static void main(String args[]) {
		User user = new User();
		user.setUserId(2);
		user.setEmail("b@gmail.com");
		user.setUserName("b");
		user.setPassword("pwd");
		user.setDob(new Date());
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
