package com.diego.hrpayroll.model;

import java.math.BigDecimal;

public class Payment {

	private String name;
	private BigDecimal dailyIncome;
	private int days;
	
	public Payment() {}
	public Payment(String name, BigDecimal dailyIncome, int days) {
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}
	
	public BigDecimal getTotal() {
		return dailyIncome.multiply(new BigDecimal(days));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getDailyIncome() {
		return dailyIncome;
	}
	public void setDailyIncome(BigDecimal dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
}
