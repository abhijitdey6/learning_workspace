package com.java8.db;

public class Bike {

	private String name;
	private String model;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Bike(String name, String model) {
		super();
		this.name = name;
		this.model = model;
	}
	@Override
	public String toString() {
		return "Bike [name=" + name + ", model=" + model + "]";
	}
	
	
}
