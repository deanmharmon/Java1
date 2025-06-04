//Dean Mason
//6-3-25

public class Property extends Asset {
	//Instance var
	private double assessedValue;
	
	/* Getters and setters, I do not like the look of using this. to denote variables,
	 * so new/altered names are used for parameters.
	 */
	public double getAssessedValue() {
		return assessedValue;
	}
	
	public void setAssessedValue(double newVal) {
		assessedValue = newVal;
	}
	//Constructor
	public Property(String name, double cost, int yearPurchased, double assessedValue) {
		super(name, cost, yearPurchased);
		this.assessedValue = assessedValue;
	}
	
	//overriding the computeValue() since it is inherited
	
	@Override
	public double computeValue() {
		return assessedValue;
	}
	/*
	 * Need to override the toString() method so that we don't need to type all of this in main, makes
	 * it easier to debug 
	 */
	@Override
	public String toString() {
	    return String.format(
	        "%s\n%-12s: %-8.1f",
	        super.toString(),
	        "Assessment", assessedValue
	    	);
	}
	
}
