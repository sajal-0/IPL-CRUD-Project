package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tka.entity.Players;
import com.tka.utility.IPLUtility;

public class IPLDao {

	Statement st = null;
	ResultSet rs = null;
	

	public List<Players> getAllPLayers() {
		String sql = "SELECT * FROM iplteams.players";
		List<Players> list = new ArrayList<>();
		try {
			Connection con = IPLUtility.support();

			st = con.createStatement();

			rs = st.executeQuery(sql);

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

		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;
	}

	public void addPlayers() {
		String sql = "INSERT INTO iplteams.players(jersey_No,name,runs,wickets,team) VALUES  (?, ?, ?, ?, ?)";
		

		try {
			Connection con = IPLUtility.support();

			PreparedStatement ps = con.prepareStatement(sql);


			
				ps.setInt(1,745);
				ps.setString(2, "Narendra Yadav");
				ps.setInt(3, 5400);
				ps.setInt(4, 42);
				ps.setString(5, "MI");

				ps.executeUpdate();
				System.out.println("upadate query");
				

			ps.close();

			

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
