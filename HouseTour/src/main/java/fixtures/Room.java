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
		 if(direction.equals("south")){
			 return exits[0];
		 }
	/*If you decide to include a getter like this then you should write out the logic for the other directions you
	want to support.*/
	}


}
