package com.tka.controller;

import java.util.List;
import java.util.Set;

import com.tka.entity.Players;
import com.tka.service.IPLService;

public class IPLController {
	IPLService service = null;

	public List<Players> getAllPlayers() {
		
		service = new IPLService();
		List<Players> allPlayers = service.getAllPlayers();
		return allPlayers;
	}


	public List<Players> getPlayersByTeamName(String team) {
		service = new IPLService();
		List<Players> teamPlayers = service.getPlayersByTeamName(team);
		return teamPlayers;
		
	}


	public List<Players> getAllBatters() {
		service = new IPLService();
		List<Players> batters = service.getAllBatters();
		return batters;
	}


	public List<Players> getAllBowlers() {
		service = new IPLService();
		List<Players> bowlers = service.getAllBowlers();
		return bowlers;
	}


	public List<Players> getAllRounders() {
		service = new IPLService();
		List<Players> listOfAllrounders = service.getAllRounders();
		return listOfAllrounders;
	}


	public List<Players> getAllSpecificTeamBatters(String str) {
		service = new IPLService();
		List<Players> listOfRCBBatters = service.getAllSpecificTeamBatters(str);
		return listOfRCBBatters;
	}


	public List<Players> getAllSpecificTeamBowlers(String str) {
		service = new IPLService();
		List<Players> listOfRCBBowlers = service.getAllSpecificTeamBowlers(str);
		return listOfRCBBowlers;
	}
	
	public List<Players> getAllSpecificTeamAllRounders(String str){
		service = new IPLService();
		List<Players> listOfAllallRounders = service.getAllSpecificTeamAllRounders(str);
		return listOfAllallRounders;
	}
	
	public Set<String> teams(){
		service = new IPLService();
		Set<String> teamsName = service.teams();
		return teamsName;
	}
	
	public List<Players> addPlayer(){
		service = new IPLService();
		List<Players> add = service.addPlayers();
		return add;
	}
	
	public List<Players> deletePlayer(int jn) {
		service = new IPLService();
		List<Players> delete = service.deletePlayer(jn);
		return delete;
	}

	


	

}
