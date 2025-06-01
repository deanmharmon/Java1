//Dean Mason
//5-30-25
//Mid term, dice roller

import java.util.Scanner;
import java.util.Arrays;

public class DiceManager {

        // Use these values for the quick roll option.
        final int ROLLS = 1000;
        final int DICE = 2;
        final int SIDES = 6;

        //Declaring variables for a DiceFactory and console input.

        Scanner input;
        DiceFactory newRoll;
        
        
        public DiceManager()
        {
        	input = new Scanner(System.in);
            newRoll = new DiceFactory();
        }

        /**
         * Launch the Dice Roller program menu.
         */
        public void go()
        {
            System.out.println("\nWelcome to Dice Roller.\n");
            int choice;
        	//Display the menu and call inputInt to get the user's menu choice validated.
        	do{
        		displayMenu();
        		choice = inputInt(input, "Please enter a number corresponding to your choice: ", 0, 3);
        		  		
        		switch (choice) {
        		case 0:
        			break;
        		case 1:
        			newRoll.rollDice(ROLLS, DICE, SIDES);
        			break;
        		case 2:
        			//Gets user input validated with inputInt then runs rollDice()
        			int rolls = inputInt(input, "How many rolls would you like to do?", 0, Integer.MAX_VALUE);
        			int dice = inputInt(input, "How many dice would you like to roll?", 0, Integer.MAX_VALUE);
        			int sides = inputInt(input, "How many sides would you like on each die?", 0, Integer.MAX_VALUE);
        			newRoll.rollDice(rolls, dice, sides);
        			break;
        		case 3:
        			System.out.println(Arrays.toString(newRoll.getResultsArray()));
        			break;
        		default:
        			//Not necessary since we have the inputInt() helper function, but good practice to have a default switch statement.
        			System.out.println("Invalid input\nPlease try again.");
        		}
        	}while (choice != 0);

        	input.close();
        	
         }

        private void displayMenu()
        {
            System.out.println("\nHere's the menu of choices -");
            System.out.println("0) Quit");
            System.out.printf("1) Quick roll with the default values (rolls = %d, dice = %d, sides = %d)\n", ROLLS, DICE, SIDES);
            System.out.println("2) Custom dice rolling (You enter the number of rolls, dice and sides.)");
            System.out.println("3) Get the array showing the results of the last simulation.");
        }

        /**
         * (Mostly) Error-proof method to get an int in a specified range from the user.
         * This method would be best as a static method in some library so that it can be used
         * in any of our programs.  That's why the first parameter is a Scanner object.
         * @param input - the Scanner object previously created for input.
         * @param prompt - the message to be displayed for the input prompt.
         * @param min - the smallest number allowed.
         * @param max - the largest number allowed.
         * @return the int entered by the user.
         */
        private int inputInt(Scanner input, String prompt, int min, int max)
        {
            int number = -1;    // -1 Just to make the compiler happy.
            boolean wrong = true;
            do
            {
                try
                {
                    System.out.print(prompt);
                    number = Integer.parseInt(input.nextLine());

                    if (number > max || number < min)
                    {
                        System.out.printf("That number is out of range [%d to %d].  Try again.\n",
                                min, max);
                    }
                    else    // good input
                    {
                        wrong = false;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Make sure you enter an integer.  Try again.");
                }
            } while (wrong);

            return number;
        }
        
    }



