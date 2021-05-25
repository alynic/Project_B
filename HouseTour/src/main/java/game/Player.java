package game;

import fixtures.Room;

public class Player {
	
	// Instance Variables
	private Room currentRoom;
	
	
	// Getters and Setters
	public Room getCurrentRoom() {
		return currentRoom;
		
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

}
