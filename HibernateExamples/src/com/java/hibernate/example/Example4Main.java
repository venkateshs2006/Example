package com.java.hibernate.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.java.hibernate.example4.pojo.User;
import com.java.hibernate.example4.pojo.Vehicle;

public class Example4Main {
	public static void main(String args[]) {
		User user = new User();
		user.setEmail("a@gmail.com");
		user.setUserName("a");
		user.setPassword("pwd");
		user.setDob(new Date());
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Bus");
		user.setVehicle(vehicle);
		SessionFactory sessionFactory = new Configuration().configure()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.saveOrUpdate(vehicle);
		User getUser = (User) session.get(User.class, 1);
		System.out.println(getUser.toString());
		session.delete(getUser);
		session.getTransaction().commit();
	}
}
