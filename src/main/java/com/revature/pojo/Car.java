package com.revature.pojo;

public class Car {
	private Integer carId;
	private String make;
	private String model;
	private String year;
	private Double price;
	private boolean owned;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	
	public Car() {
		super();
		this.owned = false;
	}

	//For insertion to DB
	public Car(String make, String model, String year, Double price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.owned = false;
	}
	
	//For Reading from DB
	public Car(Integer carid, String make, String model, String year, Double price, boolean owners, Integer userId) {
		super();
		this.carId = carid;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.owned = false;
	}
	
	
}
