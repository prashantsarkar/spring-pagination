package com.bitwise.pagination.web.beans;

public class Phone {

	private String id;

	private String name;
	
	private double price;
	
	public Phone() {

	}

	public Phone(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
}