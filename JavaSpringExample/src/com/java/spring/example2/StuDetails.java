package com.java.spring.example2;

import java.util.List;

public class StuDetails {
private String name;
private List<Mark> marks;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Mark> getMarks() {
	return marks;
}
public void setMarks(List<Mark> marks) {
	this.marks = marks;
}
public void display(){
	System.out.println("Student details:");
	System.out.println("Name :"+ getName());
	System.out.println("Marks :");
	int count=1;
	for(Mark m: marks){
		System.out.println("Mark "+count+"  :"+m.getM());
		count++;
	}
}
}
