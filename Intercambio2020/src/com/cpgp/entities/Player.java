package com.cpgp.entities;

public class Player {
	private int id;
	private String name;
	private int idTarget;
	
	
	
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdTarget() {
		return idTarget;
	}
	public void setIdTarget(int idTarget) {
		this.idTarget = idTarget;
	}
	
}
