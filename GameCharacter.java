//Dean Mason
//5-21-25
//Unit 2-GameCharacter

import java.util.Random;

public class GameCharacter {
	//private instance variables
	//this allows them to be used independently for each instance of the class being run
	private String name;
	private int health;
	private int strength;
	private int defense;
	private String weapon;
	
	//constructor, this sets everything when you input arguments as you instantiate the class
	public GameCharacter(String name, int health, int strength, int defense, String weapon) {
		
	//using this allows us to not have to create other names for the arguments
		this.name= name;
		this.health = health;
		this.strength = strength;
		this.defense = defense;
		this.weapon = weapon;
	}
	
	//get methods, doing this allows us to access these private variables from other file
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	//set methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	//attack method
	public int attack() {
		//use of random and adding it to strength gives us variability
		Random rand = new Random();
		return strength + rand.nextInt(18); 
	}
	
	//defending method
	public void defend(int attackValue) {
		//use of random here does the same thing, giving it a little life
		Random rand = new Random();
		int block = defense + rand.nextInt(4); 
		int damage = attackValue - block;
		
		if (damage > 0) {
			health -= damage;
			System.out.println(name + " takes " + damage + " damage!");
		}
		else {
			System.out.println(name + " blocks the attack!");		
		}
		
		if (health <= 0) {
			health = 0;
			System.out.println(name + " has perished in combat.");
		}
	}
	
	//checking if the character has died, returns true if so
	public boolean isAlive() {
		return health > 0;
	}
	
	//toString method to print useful info
	public String toString() {
		return name + " (Health: " + health + ", Strength: " + strength +
				", Defense: " + defense + ", Weapon: " + weapon + ")";
	}
}
