package com.bus.model;

import java.sql.Date;

public class Search {
	
	//private boolean roundTrip;
	private int departure;
	private int arrival;
	private Date departureDate;
	private Date returnDate;
	private Integer number;
	
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public int getDeparture() {
		return departure;
	}
	public void setDeparture(int departure) {
		this.departure = departure;
	}
	
	@Override
	public String toString() {
		return "Search [departure=" + departure + ", arrival=" + arrival + ", departureDate=" + departureDate + 
				", returnDate=" + returnDate + ", number=" + number + "]";
	}

}
