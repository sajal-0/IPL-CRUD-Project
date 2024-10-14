package com.tka.entity;

public class Players {

	
	private String name;
	private int jersey_No;
	private int runs;
	private int wickets;
	private String team;
	
	
	public Players() {
		super();
	}
	
	
	public Players(String name, int jersey_No, int runs, int wickets, String team) {
		super();
		this.name = name;
		this.jersey_No = jersey_No;
		this.runs = runs;
		this.wickets = wickets;
		this.team = team;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	public int getJersey_No() {
		return jersey_No;
	}


	public void setJersey_No(int jersey_No) {
		this.jersey_No = jersey_No;
	}


	@Override
	public String toString() {
		return "Players [name=" + name + ", jersey_No=" + jersey_No + ", runs=" + runs + ", wickets=" + wickets
				+ ", team=" + team + "]";
	}
	
}
