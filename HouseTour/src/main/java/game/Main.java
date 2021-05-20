package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {
	
	/* Setup rooms */
	private static RoomManager roomManager = new RoomManager(4);
	/* Controls when game is running */
	private static boolean valid = true;
	
	public static void main(String[] args) {
		
		/* Instantiate the house */
		roomManager.init();
		
		/* Create player and set up their currentRoom to be the startingRoom */
		Player player = new Player();
		
		System.out.println("Here, we can print a message about"
				+ "how to play the game. "
				+ "\nIncluding directions and what commands to use..."
				+ "\nYou can also save this message as a method which prints "
				+ "\nto the console, if you want to be able to print"
				+ "\nthe instructions at any time...");
		
		/* Set up their currentRoom to be the startingRoom */
		player.setCurrentRoom(roomManager.getStartingRoom());
		
		while(valid) {
			printRoom(player);
			String[] input = collectInput();
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
		
		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println("Name: " + player.getCurrentRoom().getName());
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
		scanner.close();
		
		String[] phrase = input.split(" ");
		return phrase;
	}
		
	private static void parse(String[] command, Player player) {
		/*
		 * The parse(String[], Player) method will take the output of the above
		 * collectInput() method and a player object, and will resolve that command.
		 * This can actually be simpler than it sounds - the first index of the
		 * passed-in String[] should be the action, so you can switch on that and handle
		 * the target differently for each case. The Player object is there so you can
		 * modify it if needed (like changing the Player's currentRoom based on the
		 * direction moved)
		 */
		
		String action = command[0].toUpperCase().intern();
		String direction = null;
		
		if (command.length > 1) {
			direction = command[1].toUpperCase().intern();
		}
		
		if (action == "GO" | action == "MOVE") {
			System.out.println("You try to move: " + direction);
			Room move = player.getCurrentRoom().getExit(direction);
			player.setCurrentRoom(move);
		} else if (action == "QUIT") {
			valid = false;
		}
	}
	
}// end main



