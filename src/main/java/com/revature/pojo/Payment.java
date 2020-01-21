package com.revature.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Payment {
	private Integer paymentId;
	private String datetime;
	private Integer userId;
	private Integer carId;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	
	//Create Payment
	public Payment(Integer userId, Integer carId) {
		super();
		
		this.userId = userId;
		this.carId = carId;
		this.datetime  = dtf.format(now); 
	}
	
	
}
