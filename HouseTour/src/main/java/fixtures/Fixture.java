package fixtures;

public abstract class Fixture {
	
	// Instance Variables
	String name;
	String shortDescription;
	String longDescription;
	
	// Empty Constructor
	Fixture(){
		
	}
	
	// Constructor
	Fixture(String name, String shortDescription, String longDescription){
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	// Getters and Setters
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	@Override
	public String toString() {
		return "Fixture [name=" + name + ", shortDesc=" + shortDescription + ", longDesc=" + longDescription + "]";
	}
	
}// end class
