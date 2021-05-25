package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	
	/* Instantiate roomManager object and set how many rooms*/
	private static RoomManager roomManager = new RoomManager(10);
	/* Controls when game is running */
	private static boolean valid = true;
	
	public static void main(String[] args) {
		
		/* Instantiate the house */
		roomManager.init();
		
		/* Create player and set up their currentRoom to be the startingRoom */
		Player player = new Player();
		
		System.out.println("==Tour the Ong Residence==\n" +
				"This is a tour of my grandparents' place where I'm currently staying at right now. \n" +
				"I'd like to dedicate this tour to my grandpa who passed away on April 15th, 2021. \n" +
				"Rest in Peace, Tatay. We love you. \n    P.S. Action = \"go/move north/south/etc.\"");
		
		/* Set up their currentRoom to be the startingRoom */
		player.setCurrentRoom(roomManager.getStartingRoom());
		
		/* While loops runs the program until user 'quit's */
		while(valid) {
			/* Prints out current room the player is in */
			printRoom(player);
			/* Collects usesr's input and splits it into parts by words saved into an array */
			String[] input = collectInput();
			/* Takes the input array turns each word/element into an action and direction */
			parse(input,player);
		}
		
		/* If the user wants to 'quit' exit the program*/
		if(!valid) {
			System.out.println("\nThanks for playing!");
		}
		
	}
	
	
	/*
	 * The printRoom(Player) method will print a prompt to the console for the
	 * player's current room.
	 */
	private static void printRoom(Player player) {
	
		System.out.println("\n:::: CURRENT ROOM ::::\n");
		System.out.println("Room Name: " + player.getCurrentRoom().getName());
		System.out.println("Short Desc: " + player.getCurrentRoom().getShortDescription());
		System.out.println("Long Desc: " + player.getCurrentRoom().getLongDescription());
		
	}
	
	/*
	 * The collectInput() method will use a Scanner object to collect console input
	 * from the user, and then will divide that input into multiple parts. Generally
	 * those parts will look like this: 1. An action 2. The target of an action (if
	 * any) For example, "go east" -> "go" is the command, "east" is the target.
	 * This method will break the input into a String[], and return that.
	 */
	private static String[] collectInput() {

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] phrase = input.split(" ");
		
		return phrase;
	}
	
	/*
	 * The parse(String[], Player) method will take the output of the above
	 * collectInput() method and a player object, and will resolve that command.
	 * The first index of the passed-in String[] is the action, which is later switched on that to handle
	 * the target differently for each case.
	 */	
	private static void parse(String[] input, Player player) {
	
		String action = input[0].toUpperCase().intern();
		String direction = null;
		
		if (input.length > 1) {
			direction = input[1].toUpperCase().intern();
		}
		
		if (action == "GO" | action == "MOVE") {
			System.out.println("\nYou move: " + direction);
			Room move = player.getCurrentRoom().getExit(direction, action);
			player.setCurrentRoom(move);
		} else if (action == "QUIT") {
			valid = false;
		} else {
			System.out.println("\n----Your fingers must've slipped... where do you want to \"GO\"?----");
		}
	}
	
}// end main



