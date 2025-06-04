//Dean Mason
//6-3-25

public class Stock extends Asset {
	
	//begin by making instance variables
	private String ticker;
	private int shares;
	private double price;
	
	
	/* Getters and setters, I do not like the look of using this. to denote variables,
	 * so new/altered names are used for parameters.
	 */
	
	public String getTicker() {
		return ticker;
	}
	
	public void setTicker(String newTick) {
		ticker = newTick;
	}
	
	public int getShares() {
		return shares;
	}
	
	public void setShares(int newShares) {
		shares = newShares;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	//Constructor below
	public Stock(String name, double cost, int yearPurchased, String ticker, int shares, double price) {
		super(name, cost, yearPurchased);
		this.ticker = ticker;
		this.shares = shares;
		this.price = price;
		
	}
	
	//overriding the computeValue() since it is inherited
	@Override
	public double computeValue() {
		return price * shares;
	}
	/*
	 * Need to override the toString() method so that we don't need to type all of this in main, makes
	 * it easier to debug 
	 */
	@Override
	public String toString() {
	    return String.format(
	        "%s\n%-12s: %-6s\n%-12s: %-6d\n%-12s: %-8.1f",
	        super.toString(),
	        "Symbol", ticker,
	        "Shares", shares,
	        "Price", price
	    	);
	}
	
}
