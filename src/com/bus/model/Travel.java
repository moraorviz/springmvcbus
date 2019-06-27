package com.bus.model;

import java.sql.Date;

public class Travel {
	
	private int id;
	private int departure;
	private int arrival;
	private int number;
	private Date departureDate;
	private Date departureHour;
	private Date arrivalDate;
	private Date arrivalHour;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeparture() {
		return departure;
	}
	public void setDeparture(int departure) {
		this.departure = departure;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getDepartureHour() {
		return departureHour;
	}
	public void setDepartureHour(Date departureHour) {
		this.departureHour = departureHour;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getArrivalHour() {
		return arrivalHour;
	}
	public void setArrivalHour(Date arrivalHour) {
		this.arrivalHour = arrivalHour;
	}
}
