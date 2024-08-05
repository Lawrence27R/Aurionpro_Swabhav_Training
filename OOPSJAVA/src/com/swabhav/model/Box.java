package com.swabhav.model;

public class Box {
	private int width;
	private int height;
	private int depth;
	
	
	
	public Box() {
		this.width=10;
		this.height=10;
		this.depth=10;
	}
	public Box(int width, int height) {
		this();
		this.width=width;
		this.height=height;
	}
	
	public Box(int width, int height, int depth) {
		this(width, height);
		this.width=width;
		this.height=height;
		this.depth=depth;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getDepth() {
		return depth;
	}
	public void setWidth(int w) {
		width = w;
	}
	public void setHeight(int h) {
		height = h;
	}
	public void setDepth(int d) {
		depth = d;
	}

	public void display() {
		System.out.println("Width : " + width);
		System.out.println("Height : " + height);
		System.out.println("Depth : " + depth);
	}
	
	public int calculateArea() {
		return width*height*depth;
	}

}
