package com.java.spring.example4;

public class Address {
private String doorNo;
private String street;
private String city;
public String getDoorNo() {
	return doorNo;
}
public void setDoorNo(String doorNo) {
	this.doorNo = doorNo;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Address [doorNo=" + doorNo + ", street=" + street + ", city="
			+ city + "]";
}

}
