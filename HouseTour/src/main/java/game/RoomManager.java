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
		
		Room livingRoom = new Room("Living Room\n", 
				"a decorated living room...\n", 
				"A decorated living room with two fancy couches and an old fireplace. \n" + 
				"Against one wall is a narrow piano and in the middle is a glass coffee table. \n" + 
				"Family pictures line every table top and there's a large window that shows the front lawn.\n\n" +
				"Exits:\n" +
				"North: a cozy family room...\n\n  Where should I go...\n");
		this.rooms[0] = livingRoom;
		
		Room familyRoom = new Room("Family Room", 
				"a cozy family room...", 
				"A cozy family room filled with a comfy couch and entertainment center with an old flat screen TV. \n" +
				"Many people have relaxed, laughed, watched TV in this very room. It is well-loved.\n\n" +
				"Exits:\n" +
				"North: a jungle of a backyard...\n" +
				"West: a narrow hallway...\n" +
				"East: a busy kitchen...\n"+
				"South: a decorated living room...\n\n  Where should I go...\n");
		this.rooms[1] = familyRoom;
		
		Room kitchen = new Room("Kitchen", 
				"a busy kitchen...", 
				"A kitchen where thousands of meals have been prepared from. On one side there's an oblong dining " + 
				"table with four chairs and ceramic fruit that that never change. The wooden cutting board that's " +
				"been around since the house's inception in 1960 is worn but still used to this day.\n\n" +
				"Exits:\n" +
				"West: a cozy family room...\n\n  Where should I go...\n");
		this.rooms[2] = kitchen;

		Room hallway = new Room("Hallway", 
				"a narrow hallway...", 
				"This hallway houses the washer and dryer and has cupboards for towels. It's narrow but not very long. " +
				"On the west side of the hallway are all the room within the house, including one bathroom.\n\n" +
				"Exits:\n" +
				"North: a large master bedroom...\n" +
				"West: a pleasent bathroom...\n" +
				"SouthWest: a hot bedroom...\n" +
				"South: a dark bedroom...\n" +
				"East: a cozy family room...\n\n  Where should I go...\n");
		this.rooms[3] = hallway;
		
		Room bedroom1 = new Room("Bedroom 1", 
				"a dark bedroom...", 
				"This bedroom is the darkest of them all, only because the sun never directly hits it and the one " +
				"window faces the south where the sun never shines. Inside is a single twin bed and dresser drawer. " +
				"There's a small desk by the window where a laptop sits.\n\n" +
				"Exits:\n" +
				"North: a narrow hallway...\n\n  Where should I go...\n");
		this.rooms[4] = bedroom1;
		
		Room bedroom2 = new Room("Bedroom 2", 
				"a hot bedroom...", 
				"This is by far the hottest room in the house. At least the yellow walls reflect some sunlight, " +
				"however there's no stopping the evening sun from creating the house's very own sauna. " +
				"Inside there's a bed, desk, and TV that gets used regularaly. The rest is random old things.\n\n" +
				"Exits:\n" +
				"NorthEast: a narrow hallway...\n\n  Where should I go...\n");
		this.rooms[5] = bedroom2;
		
		Room bathroom = new Room("Bathroom", 
				"a pleasent bathroom...", 
				"If there's one room in this house that's meticulous upkept, it would be this room. " +
				"That's a good thing, because this is the most common room in the entire house. " +
				"Pleasentries are nice here, trust me. Also there's a shower that doesn't really work, " +
				"but trust me, all you need is the toilet.\n\n" +
				"Exits:\n" +
				"East: a narrow hallway...\n\n  Where should I go...\n");
		this.rooms[6] = bathroom;
		
		Room masterBedroom = new Room("Master Bedroom", 
				"a large master bedroom...", 
				"The largest room in the house. This room has a California King sized bed along with " +
				"it's own bathroom and shower. There's also a thingy with two sinks in the bathroom " +
				"I just forgot what it's called. Plus there's an entryway into the backyard. You " +
				"can't beath that.\n\n" +
				"Exits:\n" +
				"North: a jungle of a backyard...\n" +
				"West: a master bathroom fit for kings of old...\n" +
				"South: a narrow hallway...\n\n  Where should I go...\n");
		this.rooms[7] = masterBedroom;
		
		Room masterBathroom = new Room("Master Bathroom", 
				"a master bathroom fit for kings of old...", 
				"This is actually a super fancy bathroom for it's time. Since it's connected to the master " +
				"bedroom it really ups the master bedroom. There's a shower and restroom in one and outside " +
				"of it theres two sinks and a decently sized closet that's filled to the brim with the oldest " +
				"clothes you've ever seen.\n\n" +
				"Exits:\n" +
				"East: a large master bedroom...\n\n  Where should I go...\n");
		this.rooms[8] = masterBathroom;
		
		Room backyard = new Room("Backyard", 
				"a jungle of a backyard...", 
				"This is probably now one of my favorite places here. It's a large backyard that spans " +
				"the width of the house and has some of the most exotic plants you've ever seen. " + 
				"In the past there have been dogs, lizards, cats, koi fish, cockatiels, and yes... a macaw parrot by " +
				"the name of Goliath... who was sadly eaten by raccons... RIP\n\n" + 
				"Exits:\n" +
				"SouthWest: a large master bedroom...\n" +
				"South: a cozy family room...\n\n  Where should I go...\n");
		
		this.rooms[9] = backyard;
		
		this.startingRoom = livingRoom;
		
		
		/* Exits: North-0, South-1, East-2, West-3 
		 * Creates new array called roomExits and sets first exit at familyRoom*/
		Room[] roomExits = {familyRoom};
		
		/* Sets the exits for each room */
		livingRoom.setExits(roomExits);
		
		familyRoom.setExits(backyard, 0);
		familyRoom.setExits(livingRoom, 1);
		familyRoom.setExits(hallway, 3);
		familyRoom.setExits(kitchen, 2);
		
		kitchen.setExits(familyRoom, 3);
		
		hallway.setExits(bedroom1, 1);
		hallway.setExits(bedroom2, 4);
		hallway.setExits(bathroom, 3);
		hallway.setExits(masterBedroom, 0);
		hallway.setExits(familyRoom, 2);
		
		bedroom1.setExits(hallway, 0);
		
		bedroom2.setExits(hallway, 5);
		
		bathroom.setExits(hallway, 2);
		
		masterBedroom.setExits(hallway, 1);
		masterBedroom.setExits(masterBathroom, 3);
		masterBedroom.setExits(backyard, 0);
		
		backyard.setExits(masterBedroom, 4);
		backyard.setExits(familyRoom, 1);
		
	}
	
	public Room getRoom(int index) {
		return rooms[index];
	}
	
	public Room getRoom(String roomName) {
	//	int index = 0;
		
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
