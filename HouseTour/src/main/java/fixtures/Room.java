package fixtures;

public class Room extends Fixture {
	
	private Room[] exits;

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		this.exits = new Room[4]; // size is your choice
	}
		
	public Room[] getExits() {
		return exits;
		
	}
		
	public Room getExit(String direction) {
	//use the direction to return a Room from the exits array
	/*For example if I always save the south exit at position 0 in my exits array when I define my code in the first
	place, then I could write out logic like the following.*/
		direction = direction.toUpperCase();
		
		if(direction.equals("NORTH")){
			return exits[0];
		}
		if(direction.equals("SOUTH")){
			return exits[1];
		}
		if(direction.equals("EAST")){
			return exits[2];
		}
		if(direction.equals("WEST")){
			return exits[3];
		}
		else {
			System.out.println("There is no exit in that direction!");
			return this;
		}
		
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
