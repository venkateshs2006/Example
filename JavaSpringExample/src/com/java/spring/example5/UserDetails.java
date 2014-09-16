package com.java.spring.example5;

public class UserDetails {
private String name;
private Address homeAddress;
private Address officeAddress;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Address getHomeAddress() {
	return homeAddress;
}
public void setHomeAddress(Address homeAddress) {
	this.homeAddress = homeAddress;
}
public Address getOfficeAddress() {
	return officeAddress;
}
public void setOfficeAddress(Address officeAddress) {
	this.officeAddress = officeAddress;
}
public void display(){
	System.out.println("Name :"+getName());
	System.out.println("Home Address :"+homeAddress.toString());
	System.out.println("Office Address :"+officeAddress.toString());
}
	
}
