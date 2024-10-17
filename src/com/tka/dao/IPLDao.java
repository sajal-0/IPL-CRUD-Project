package com.tka.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

	public List<Players> addPlayers() {
		String sql = "INSERT INTO iplteams.players(jersey_No,name,runs,wickets,team) VALUES  (?, ?, ?, ?, ?)";
		List<Players> list = new ArrayList<>();

		try {
			Connection con = IPLUtility.support();

			PreparedStatement ps = con.prepareStatement(sql);
			
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


			
				ps.setInt(1,jn);
				ps.setString(2,name);
				ps.setInt(3, rn);
				ps.setInt(4, wk);
				ps.setString(5, tm);

				ps.executeUpdate();
				System.out.println("upadate query");
				

			ps.close();

			Players obj = new Players(name, jn, rn, wk, tm);
			list.add(obj);

		} catch (Exception e) {

			e.printStackTrace();
			
		}
		return list;
		
		
		
	}

}
