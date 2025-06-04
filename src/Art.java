//Dean Mason
//6-3-25

public class Art extends Property {
	//Instance vars
	private String artist;
	private int yearCreated;
	
	/* Getters and setters, I do not like the look of using this. to denote variables,
	 * so new/altered names are used for parameters.
	 */
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String newArtist) {
		artist = newArtist;
	}
	
	public int getYearCreated() {
		return yearCreated;
	}
	
	public void setYearCreated(int updatedYear) {
		yearCreated = updatedYear;
	}
	//Constructor
	public Art(String name, double cost, int yearPurchased, double assessedValue, String artist, int yearCreated) {
		super(name, cost, yearPurchased, assessedValue);
		this.artist = artist;
		this.yearCreated = yearCreated;
	}
	/*
	 * Need to override the toString() method so that we don't need to type all of this in main, makes
	 * it easier to debug 
	 */
	@Override
	public String toString() {
	    return String.format(
	        "%s\n%-12s: %-20s\n%-12s: %d",
	        super.toString(),
	        "Artist", artist,
	        "Created", yearCreated
	    	);
	}
	
}
