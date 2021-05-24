package fixtures;

public class Room extends Fixture {
	
	private Room[] exits;

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[6]; // size is your choice for how many exits you want
	}
		
	public Room[] getExits() {
		return exits;
		
	}
		
	public Room getExit(String direction) {
	//use the direction to return a Room from the exits array
	/*For example if I always save the south exit at position 0 in my exits array when I define my code in the first
	place, then I could write out logic like the following.*/
		int index = 0;
		direction = direction.toUpperCase();
		switch (direction) {
		case "NORTH":
			index = 0;
			break;
		case "SOUTH":
			index = 1;
			break;
		case "EAST":
			index = 2;
			break;
		case "WEST":
			index = 3;
			break;
		case "SOUTHWEST":
			index = 4;
			break;
		case "NORTHEAST":
			index = 5;
			break;
		default:
			System.out.println("\nYour fingers must've slipped... where do you want to go?");
		}
		
		// If statement checks if there is actually a room in certain direction
		if (index >= this.exits.length || this.exits[index] == null) {
			System.out.println("There is no room in that direction");
			
			// Return the current room is there is not a room in that direction
			return this;
		}
		
		return this.exits[index];
		
	}
	
	/*If you decide to include a getter like this then you should write out the logic for the other directions you
	want to support.*/
	
	// Setter for the exits
	public void setExits(Room[] exits) {
		this.exits = exits;
	}
	
	// Overloaded setter method. Allows us to set single exit based on index...
	public void setExits(Room exit, int index) {
		this.exits[index] = exit;
	}

}
