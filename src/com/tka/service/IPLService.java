package com.tka.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tka.dao.IPLDao;
import com.tka.entity.Players;

public class IPLService {
	IPLDao dao = null;
	List<Players> team = getAllPlayers();

	
	public List<Players> getAllPlayers() {
		dao = new IPLDao();
	List<Players> allPlayers = dao.getAllPLayers();
		return allPlayers;
	}

	public List<Players> getPlayersByTeamName(String te) {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getTeam().equalsIgnoreCase(te)) {
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllBatters() {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getRuns()>5000) {
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllBowlers() {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getWickets()>50) {
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllRounders() {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getWickets()>50 && player.getRuns()>5000) {
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllSpecificTeamBatters(String str) {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getRuns() > 5000 && (player.getTeam().equalsIgnoreCase(str))){
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllSpecificTeamBowlers(String str) {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getWickets() > 50 && (player.getTeam().equalsIgnoreCase(str))){
				list.add(player);
			}
		}
		return list;
	}

	public List<Players> getAllSpecificTeamAllRounders(String str) {
		List<Players> list = new ArrayList<>();
		for(Players player : team) {
			if(player.getWickets() > 50 && (player.getTeam().equalsIgnoreCase(str)) && player.getRuns()>5000){
				list.add(player);
			}
		}
		return list;
		
	}
	
	
	public Set<String> teams(){
		Set<String> set = new HashSet<>();
		for(Players player: team) {
			String teamName = player.getTeam();
			set.add(teamName);
		}
		return set;
	}

	

}
