//Dean Mason
//5-21-25
//Unit 2-GameTest

public class GameTest {

	public static void main(String[] args) {
		//start by making two character instances
		//I don't like them having the same stats, but if not then one will typically beat the other, this makes it actually a fair distribution of wins.
		//After changing the random defense/attack stats for awhile, this gives the best randomness in outcomes, to see a longer fight the health can be raised.
		GameCharacter hero = new GameCharacter("Sherlock", 100, 8, 5, "Pen");
		GameCharacter villain = new GameCharacter("Moriarty", 100, 8, 5, "Sword");
		
		System.out.println("----------- We Begin! -----------");
		System.out.println(hero);
		System.out.println(villain);
		System.out.println();
		
		//logic for the fight
		//while loop ensures we stop fighting after one is dead (otherwise it would be cruel)
		int round = 1;
		while (hero.isAlive() && villain.isAlive()) {
			System.out.println("Round " + round);
			
			int heroAttack = hero.attack();
			System.out.println(hero.getName() + " attacks with " + heroAttack);
			villain.defend(heroAttack);
			
			if(!villain.isAlive()) break;
			
			int villainAttack = villain.attack();
			System.out.println(villain.getName() + " attacks with " + villainAttack);
			hero.defend(villainAttack);
			
			System.out.println(hero);
			System.out.println(villain);
			System.out.println();
			round++;
			
		}
		
		System.out.println("----------- Battle Complete -----------");
		
		//simple check for who has won
		if (hero.isAlive()) {
			System.out.println(hero.getName() + " has won!");
		}
		else if (villain.isAlive()) {
			System.out.println(villain.getName() + " has won!");
		}
		else {
			System.out.println("Both have vanquished.");
		}
		

	}

}
