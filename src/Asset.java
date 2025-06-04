//Dean Mason
//6-3-25

public class Asset {
	//Instance vars
	private String name;
	private double cost;
	private int yearPurchased;
	
	/* Getters and setters, I do not like the look of using this. to denote variables,
	 * so new/altered names are used for parameters.
	 */
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double newCost) {
		cost = newCost;
	}
	
	public int getYear() {
		return yearPurchased;
	}
	
	public void setYear(int year) {
		yearPurchased = year;
	}
	
	//I've run out of other ideas, so this. will be used in the constructor below
	public Asset(String name, double cost, int yearPurchased) {
		this.name = name;
		this.cost = cost;
		this.yearPurchased = yearPurchased;
	}
	
	public double amortizedCost(int currentYear) {
		return cost / (currentYear - yearPurchased);
	}
	
	public double computeValue() {
		return cost;
	}
	
	/*
	 * Need to override the toString() method so that we don't need to type all of this in main, makes
	 * it easier to debug 
	 */
	
	@Override
	public String toString() {
		return String.format(
				"%-12s: %-20s\n%-12s: %-10.1f\n%-12s: %-10d",
				"Name", name,
				"Cost", cost,
				"Purchased", yearPurchased);
	}
}
