	package com.tka.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tka.entity.Players;
import com.tka.utility.IPLUtility;

public class IPLDao {

//	Statement st = null;
	ResultSet rs = null;

	public List<Players> getAllPLayers() {
		String sql = "SELECT * FROM iplteams.players";
		List<Players> list = new ArrayList<>();
		try {
			Connection con = IPLUtility.support();

			PreparedStatement ps = con.prepareStatement(sql);

			rs = ps.executeQuery(sql);

			while (rs.next()) {
				int jn = rs.getInt("jersey_No");
				String pname = rs.getString("name");
				int pruns = rs.getInt("runs");
				int pwickets = rs.getInt("wickets");
				String team = rs.getString("team");

				Players obj = new Players(pname, jn, pruns, pwickets, team);
				list.add(obj);
//				System.out.println(obj);
			}
			ps.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	public List<Players> addPlayers() {
		String sql = "INSERT INTO iplteams.players(jersey_No,name,runs,wickets,team) VALUES  (?, ?, ?, ?, ?)";
		List<Players> list = new ArrayList<>();

		try {
			Connection con = IPLUtility.support();

			// it is use for the dynamic query
			PreparedStatement ps = con.prepareStatement(sql);

			// read the input from the console
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter the Jersey Number : ");
			int jn = Integer.parseInt(br.readLine());
			System.out.println("Enter the Name of Player : ");
			String name = br.readLine();
			System.out.println("Enter the Runs : ");
			int rn = Integer.parseInt(br.readLine());
			System.out.println("Enter the Wickets : ");
			int wk = Integer.parseInt(br.readLine());
			System.out.println("Name of the team : ");
			String tm = br.readLine();

			ps.setInt(1, jn);
			ps.setString(2, name);
			ps.setInt(3, rn);
			ps.setInt(4, wk);
			ps.setString(5, tm);

			// if want to update data in the table
			ps.executeUpdate();
			System.out.println("upadate query");

			Players obj = new Players(name, jn, rn, wk, tm);
			list.add(obj);

			ps.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	public List<Players> deletePlayer(int jn) {
		
		String sql = "DELETE FROM iplteams.players WHERE jersey_No = ?";
		try {
			Connection con = IPLUtility.support();

			PreparedStatement ps = con.prepareStatement(sql);
			con.setAutoCommit(true);
			
			ps.setInt(1, jn);
			
			int rowsAffected =  ps.executeUpdate();
			 ps.close();
			 
			 if(rowsAffected>0) {
				 System.out.println("Player with jersey no "+jn+" has been remove sucessfully!!");
			 }else {
				 System.out.println("No player found");
			 }

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		
		return getAllPLayers();
		

	}
	public List<Players> updatePlayer(int jerseyNo, Players updatedPlayer) {
	    String sql = "UPDATE iplteams.players SET name = ?, runs = ?, wickets = ?, team = ? WHERE jersey_No = ?";
	    try {
	        Connection con = IPLUtility.support();
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, updatedPlayer.getName());
	        ps.setInt(2, updatedPlayer.getRuns());
	        ps.setInt(3, updatedPlayer.getWickets());
	        ps.setString(4, updatedPlayer.getTeam());
	        ps.setInt(5, jerseyNo);

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Player with Jersey Number " + jerseyNo + " updated successfully.");
	        } else {
	            System.out.println("No player found with Jersey Number " + jerseyNo);
	        }

	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // Return the updated list of players
	    return getAllPLayers();
	}

}
