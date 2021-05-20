package game;

public class RoomManager {
	
	// Instance Variables for each property
	String frontOfHouse;
	String shortFrontOfHouse;
	String longFrontOfHouse;
	
	String livingRoom;
	String shortLivingRoom;
	String longLivingRoom;
	
	String kitchen;
	String shortKitchen;
	String longKitchen;
	
	Room startingRoom;
	Room[] rooms;

	public void init() {
		
		Room start = new Room("Foyer", "Grand entryway", "The super long description that I'm not going to write out...");
		this.rooms[0] = foyer;
		this.startingRoom = foyer;
	}
}
