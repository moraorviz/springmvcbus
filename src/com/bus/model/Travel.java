package com.bus.model;

import java.sql.Date;
import java.sql.Time;

public class Travel {
	
	private int id;
	private int departure;
	private int arrival;
	private Date departureDate;
	private Time departureHour;
	private Date arrivalDate;
	private Time arrivalHour;
	
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
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Time getDepartureHour() {
		return departureHour;
	}
	public void setDepartureHour(Time departureHour) {
		this.departureHour = departureHour;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Time getArrivalHour() {
		return arrivalHour;
	}
	public void setArrivalHour(Time arrivalHour) {
		this.arrivalHour = arrivalHour;
	}
}
