//Dean Mason
//6-3-25

public class Building extends Property {
	//Instance var
	private String address;
	
	/* Getters and setters, I do not like the look of using this. to denote variables,
	 * so new/altered names are used for parameters.
	 */
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String newAdd) {
		address = newAdd;
	}
	//Constructor
	public Building(String name, double cost, int yearPurchased, double assessedValue, String address) {
		super(name, cost, yearPurchased, assessedValue);
		this.address = address;
	}
	/*
	 * Need to override the toString() method so that we don't need to type all of this in main, makes
	 * it easier to debug 
	 */
	@Override
	public String toString() {
	    return String.format(
	        "%s\n%-12s: %s",
	        super.toString(),
	        "Address", address
	    	);
	}
}
