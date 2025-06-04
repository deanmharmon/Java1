//Dean Mason
//6-3-25

public class Main {

	public static void main(String[] args) {
		System.out.println("Inheritance Project - Assets\n");

		/*
		 * Putting down given values to work with here so that output matches up
		 */
		Stock microsoft = new Stock("Microsoft Stock", 8000, 1994, "MSFT", 200, 56);
		Building beachHouse = new Building("Beach House", 9000, 1964, 35000,
		"123 Seashore Ave, Malibu, CA");
		Art nighthawks = new Art("Nighthawks", 850, 1955, 7500, "Edward Hopper", 1942);
		
		//creating an array of Asset references to use in our enhanced for-loop
		Asset[] assets = {microsoft, beachHouse, nighthawks};
		
		System.out.println("\nAmortized costs per year: ");
		for (Asset asset : assets) {
			double amortized = asset.amortizedCost(2002);
			String outputCost = String.format("%-16s $ %8.2f", asset.getName(), amortized);
			System.out.println(outputCost);
		}
		
		System.out.println("\nValuations:");
		for (Asset asset : assets) {
			double value = asset.computeValue();
			String outputVal = String.format("%-16s $ %8.2f", asset.getName(), value);
			System.out.println(outputVal);
		}
		
		System.out.println("\nAsset Details:");
		for (Asset asset : assets) {
			System.out.println(asset.toString() + "\n");
			
		}
	}

}
