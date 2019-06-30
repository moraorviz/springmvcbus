package com.bus.model;

public class Extra {
	
	private boolean bici;
	private boolean surf;
	private boolean sky;
	private boolean mascota;
	private int nbici;
	private int nsurf;
	private int nsky;
	private int nmascota;
	private boolean seguro;
	
	public boolean isBici() {
		return bici;
	}
	public void setBici(boolean bici) {
		this.bici = bici;
	}
	public boolean isSurf() {
		return surf;
	}
	public void setSurf(boolean surf) {
		this.surf = surf;
	}
	public boolean isSky() {
		return sky;
	}
	public void setSky(boolean sky) {
		this.sky = sky;
	}
	public boolean isMascota() {
		return mascota;
	}
	public void setMascota(boolean mascota) {
		this.mascota = mascota;
	}
	public int getNbici() {
		return nbici;
	}
	public void setNbici(int nbici) {
		this.nbici = nbici;
	}
	public int getNsurf() {
		return nsurf;
	}
	public void setNsurf(int nsurf) {
		this.nsurf = nsurf;
	}
	public int getNsky() {
		return nsky;
	}
	public void setNsky(int nsky) {
		this.nsky = nsky;
	}
	public int getNmascota() {
		return nmascota;
	}
	public void setNmascota(int nmascota) {
		this.nmascota = nmascota;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	
	@Override
	public String toString() {
		return "Extra [bicy=" + bici + ", surf=" + surf + ", sky=" + sky + 
				", mascota=" + mascota + ", nbicy=" + nbici  + ", nsurf=" + nsurf + 
				", nsky= " + nsky + ", nmascota= " + nmascota + ", seguro= " + seguro
				+ "]";
	}

}
