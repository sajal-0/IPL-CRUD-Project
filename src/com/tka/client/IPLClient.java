package com.tka.client;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.tka.controller.IPLController;
import com.tka.entity.Players;

public class IPLClient {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
			IPLController con = new IPLController();
		

			do{

				System.out.println("Available Options ");
				System.out.println("0 to Print players \n" +"1 get player of perticular team\n"+ "2 to Print all batters\n"
						+"3 to print allBowlers\n"+"4 to print all allrounders\n" + "5 to print batters of specific team\n"
						+ "6 to print bowlers of specific team\n"+"7 to print all allRounder of Specific team\n"
						+"8 Name of teams\n"
				+"9 Exit the application\n" + "10 Enter the valid input\n" );

				int option = sc.nextInt();
				sc.nextLine();
					
				switch(option) {
				case 0 :
					System.out.println("List Of all players In IPL :");
					List<Players> allPlayers = con.getAllPlayers();
					
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : allPlayers) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					// Table Footer
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 1 :
					
					System.out.println("Enter the name of team : ");
					String str = sc.nextLine();
					System.out.println("List Of all Players by team name In IPL :");
					List<Players> teamPlayers = con.getPlayersByTeamName(str);
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : teamPlayers) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 2 : 
					System.out.println("List Of all Batters In IPL :");
					List<Players> batters = con.getAllBatters();
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : batters) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 3 : 
					System.out.println("List Of all Bowlers In IPL :");

					List<Players> bowlers = con.getAllBowlers();
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : bowlers) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 4 :
					System.out.println("List Of all AllRounders In IPL :");

					List<Players> listOfAllrounders = con.getAllRounders();
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : listOfAllrounders) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 5 : 
					System.out.println("Enter the name of team : ");
					String str1 = sc.nextLine();
					System.out.println("List Of specific team batters In IPL :");
					List<Players> listOfSpecificTeamBatters = con.getAllSpecificTeamBatters(str1);
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : listOfSpecificTeamBatters) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 6 :
					System.out.println("Enter the name of team : ");
					String str2 = sc.nextLine();
					System.out.println("List Of specific team bowlers In IPL :");
					
					List<Players> listOfSpecificTeamBowlers = con.getAllSpecificTeamBowlers(str2);
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : listOfSpecificTeamBowlers) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
				case 7 :
					System.out.println("Enter the name of team : ");
					String str3 = sc.nextLine();
					List<Players> listofAllRounderOfSpecificTeam = con.getAllSpecificTeamAllRounders(str3);
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					System.out.printf("| %-19s | %-9s | %-5s | %-7s | %-4s |\n", "Player Name", "Jersey No", "Runs", "Wickets", "Team");
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");
					for (Players player : listofAllRounderOfSpecificTeam) {
						System.out.printf("| %-19s | %-9d | %-5d | %-7d | %-4s |\n",
								player.getName(), player.getJersey_No(), player.getRuns(), player.getWickets(), player.getTeam());
					}
					System.out.printf("+---------------------+-----------+-------+---------+------+\n");

					break;
					
				case 8 :
					System.out.println("Name of teams : ");
					Set<String> set = con.teams();
					System.out.println(set);
					break;
				case 9:
					System.out.println("Exiting the application. Thank you!");
					System.exit(0); 
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			
				}

	}while(true);
	}
}
