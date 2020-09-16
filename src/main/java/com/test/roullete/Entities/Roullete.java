package com.test.roullete.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Roullete implements Serializable{
	private String id;
	private RoulleteStatus status;
	private ArrayList<Bet> bets;
	
	public ArrayList<Bet> getBets() {
		return bets;
	}
	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public RoulleteStatus getStatus() {
		return status;
	}
	public void setStatus(RoulleteStatus status) {
		this.status = status;
	}

}
