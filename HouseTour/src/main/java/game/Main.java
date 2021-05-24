package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	
	/* Instantiate roomManager object and set many rooms*/
	private static RoomManager roomManager = new RoomManager(10);
	/* Controls when game is running */
	private static boolean valid = true;
	
	public static void main(String[] args) {
		
		/* Instantiate the house */
		roomManager.init();
		
		/* Create player and set up their currentRoom to be the startingRoom */
		Player player = new Player();
		
		System.out.println("==Tour the Ong Residence==\n" +
				"This is a tour of my grandparent's place where I'm currently staying at right now. \n" +
				"I'd like to dedicate this tour to my grandpa who passed away on April 15th, 2021. \n" +
				"Rest in Peace, Tatay. We love you.");
		
		/* Set up their currentRoom to be the startingRoom */
		player.setCurrentRoom(roomManager.getStartingRoom());
		
		/* While loops runs the program until user 'quit's */
		while(valid) {
			/* Prints out current room the player is in */
			printRoom(player);
			/* Collects user's input and splits it into parts by words saved into an array */
			String[] input = collectInput();
			/* Takes the input array turns each word/element into an action and direction */
			parse(input,player);
		}
		
		if(!valid) {
			System.out.println("Thanks for playing!");
		}

	}
	
	// Methods
	private static void printRoom(Player player) {
		/*
		 * The printRoom(Player) method will print a prompt to the console for the
		 * player's current room, similar to the above image.
		 */
		
		System.out.println("\n:::: CURRENT ROOM ::::\n");
		System.out.println("Room Name: " + player.getCurrentRoom().getName());
		System.out.println("Short Desc: " + player.getCurrentRoom().getShortDescription());
		System.out.println("Long Desc: " + player.getCurrentRoom().getLongDescription());
		// You can also print information about connecting rooms here...
	}
	
	private static String[] collectInput() {
		/*
		 * The collectInput() method will use a Scanner object to collect console input
		 * from the user, and then will divide that input into multiple parts. Generally
		 * those parts will look like this: 1. An action 2. The target of an action (if
		 * any) For example, "go east" -> "go" is the command, "east" is the target.
		 * This method will break the input into a String[], and return that.
		 */
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
	//	scanner.close();
		
		String[] phrase = input.split(" ");
		return phrase;
	}
		
	private static void parse(String[] input, Player player) {
		/*
		 * The parse(String[], Player) method will take the output of the above
		 * collectInput() method and a player object, and will resolve that command.
		 * This can actually be simpler than it sounds - the first index of the
		 * passed-in String[] should be the action, so you can switch on that and handle
		 * the target differently for each case. The Player object is there so you can
		 * modify it if needed (like changing the Player's currentRoom based on the
		 * direction moved)
		 */
		
		String action = input[0].toUpperCase().intern();
		String direction = null;
		
		if (input.length > 1) {
			direction = input[1].toUpperCase().intern();
		}
		
		if (action == "GO" | action == "MOVE") {
			System.out.println("\nYou move: " + direction);
			Room move = player.getCurrentRoom().getExit(direction);
			player.setCurrentRoom(move);
		} else if (action == "QUIT") {
			valid = false;
		}
	}
	
}// end main



