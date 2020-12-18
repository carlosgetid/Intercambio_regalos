package com.cpgp.entities;

public class Player {
	private int id;
	private String name;
	private boolean turn;
	private int idTarget;
	private boolean receptor;
	
	
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

	
	public boolean isReceptor() {
		return receptor;
	}

	public void setReceptor(boolean receptor) {
		this.receptor = receptor;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
	
	
}
