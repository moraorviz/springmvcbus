package com.bus.model;

public class User {
	
	private String nombre;
	private String apellidos;
	private String tipoIdent;
	private String ident;
	private String email;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipoIdent() {
		return tipoIdent;
	}
	public void setTipoIdent(String tipoIdent) {
		this.tipoIdent = tipoIdent;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	@Override 
	public String toString() {
		return "User [nombre=" + nombre + ", apellidos=" + apellidos + ", tipoIdent=" + tipoIdent + ", ident=" +  ident + ", email=" + email + "]";
	}

}
