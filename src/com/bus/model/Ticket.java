package com.bus.model;

public class Ticket {
	
	private Integer id;
	private String user;
	private String code;
	
	public Ticket() {
		
	}
	
	public Ticket(Integer id, String user, String code) {
		this.id = id;
		this.user = user;
		this.code = code;
	}
	
	public Ticket(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", user=" + user + ", code=" + code + "]";
	}
}
