package com.java.spring.example1;

public class Triangle {
	private String format;
	private int height;
	private InjectingObject in;

	public InjectingObject getIn() {
		return in;
	}

	public void setIn(InjectingObject in) {
		this.in = in;
	}

	public Triangle(String format, int height) {
		super();
		this.format = format;
		this.height = height;
	}

	public Triangle(String format) {
		this.format = format;
	}

	/*
	 * public String getFormat() { return format; }
	 * 
	 * 
	 * 
	 * public void setFormat(String format) { this.format = format; }
	 */

	public void draw() {
		System.out.println(format + " " + height + " size Triangle Drawn");
	}

	public void area() {
		System.out.println("Area of Rect :" + in.getHeight()*in.getWidth());

	}
}
