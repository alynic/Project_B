package game;

import fixtures.Room;

public class RoomManager {
	
	// Instance Variables for each property
	private Room startingRoom;
	private Room[] rooms;
	
	public RoomManager(int roomCount) {
		super();
		rooms = new Room[roomCount];
	}

	public void init() {
		
		Room livingRoom = new Room("Living Room", "Grand entryway", "The super long description that I'm not going to write out...");
		this.rooms[0] = livingRoom;
		
		Room familyRoom = new Room("Family Room", "Grand entryway", "The super long description that I'm not going to write out...");
		this.rooms[1] = familyRoom;
		
		Room kitchen = new Room("Kitchen", "Grand entryway", "The super long description that I'm not going to write out...");
		this.rooms[2] = kitchen;

		Room hallway = new Room("Hallway", "Grand entryway", "The super long description that I'm not going to write out...");
		this.rooms[3] = hallway; 
		
		this.startingRoom = livingRoom;
		
		Room[] livingRoomExits = {familyRoom};
		livingRoom.setExits(livingRoomExits);
		familyRoom.setExits(kitchen, 1);
		kitchen.setExits(hallway, 2);
		
	}
	
	public Room getRoom(int index) {
		return rooms[index];
	}
	
	public Room getRoom(String roomName) {
		int index = 0;
		
		for(int i=0; i<rooms.length; i++) {
			if(roomName.toUpperCase() == rooms[i].getName().toUpperCase())
				// return the room based on the index (we call the overloaded function)
				return getRoom(i);
		}
		
		// If the for loop does NOT find a matching room name
		return null;
	}
	
	public Room getStartingRoom() {
		return this.startingRoom;
	}
	
	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}
	
	public Room[] getRooms() {
		return this.rooms;
	}
	
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}
	
}// end class
