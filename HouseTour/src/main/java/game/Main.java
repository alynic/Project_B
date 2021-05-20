package game;

public class Main {
	
	public static void main(String[] args) {
		
		/* Setup rooms */
		RoomManager roomManager = new RoomManager();
		roomManager.init();
		
		/* Get starting Room from room manager */
		Room startingRoom = roomManager.getStartingRoom(); // roomManager.startingRoom
		
		/* Create player and set up their currentRoom to be the startingRoom*/
		Player player = new Player(startingRoom);
		
		/*
		 * Game loop print Room get user command and translate it move Player/execute
		 * command repeat until quit
		 */
		
		Room nextRoom = currentRoom.getExit(direction);//direction holds “north” from the user
		player.setCurrentRoom(nextRoom);

	}
	
	// Methods
	private static void printRoom(Player player) {
		/*
		 * The printRoom(Player) method will print a prompt to the console for the
		 * player's current room, similar to the above image.
		 */	
	}
	
	private static String[] collectInput() {
		/*
		 * The collectInput() method will use a Scanner object to collect console input
		 * from the user, and then will divide that input into multiple parts. Generally
		 * those parts will look like this: 1. An action 2. The target of an action (if
		 * any) For example, "go east" -> "go" is the command, "east" is the target.
		 * This method will break the input into a String[], and return that.
		 */
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
	}
	
}// end main



