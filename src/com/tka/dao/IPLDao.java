package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Players> addPlayers() {
		String sql = "INSERT INTO batch1199.playersipl(jersey_No,name,runs,wickets,team) VALUES  (?, ?, ?, ?, ?)";
		List<Players> allPlayers = getAllPLayers();

		try {
			Connection con = IPLUtility.support();

			PreparedStatement ps = con.prepareStatement(sql);

			rs = st.executeQuery(sql);

			for (Players player : allPlayers) {
				ps.setInt(1, player.getJersey_No());
				ps.setString(2, player.getName());
				ps.setInt(3, player.getRuns());
				ps.setInt(4, player.getWickets());
				ps.setString(5, player.getTeam());

				ps.addBatch(); 
			}
			ps.executeBatch();
			ps.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return allPlayers;
	}

}