//Dean Mason
//Unit 1-CFA Payroll
//5-20-25
//This program is used to determine the amount of each bill to be given for any paycheck cashed under 100,000 CFA.

import java.util.Scanner;

public class Main-Unit1 {

	public static void main(String[] args) {
		//Input Section
		//Start by creating object to look for input, then to store in variables
		Scanner scnr = new Scanner(System.in);
		
		String firstName, lastName;
		int pay; 
		
		System.out.print("Enter first name: ");
		firstName = scnr.next();
		 
		System.out.print("Enter last name: ");
		lastName = scnr.next();
		 
		System.out.print("Enter pay in CFA (less than 100000): ");
		pay = scnr.nextInt();
		
		//Calculations
		//By doing the modulo after integer division, it removes what was taken for the previous pay.
		//This is why we start at the largest denomination and move to the smallest.
		int remainder = pay;
		
		int myCFA10000 = remainder / 10000;
		remainder = remainder % 10000; 
		
		int myCFA5000 = remainder / 5000;
		remainder = remainder % 5000;
		
		int myCFA1000 = remainder / 1000;
		remainder = remainder % 1000;
		
		int myCFA500 = remainder / 500;
		remainder = remainder % 500;
		
		int myCFA100 = remainder / 100;
		remainder = remainder % 100;
		
		int myCFA50 = remainder / 50;
		remainder = remainder % 50;
		
		int myCFA25 = remainder / 25;
		remainder = remainder % 25;
		
		int myCFA10 = remainder / 10;
		remainder = remainder % 10;
		
		int myCFA5 = remainder / 5;
		remainder = remainder % 5;
		
		//Outputs 
		//Using the %- left-aligns the text/integers with the number being the width.
		//The s and d determine whether a string or integer go there.
		System.out.println();
		System.out.printf("%-15s %-5s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s\n", 
		   "Name", "Pay", "10k", "5k", "1k", "500", "100", "50", "25", "10", "5");
		
		//This just makes it look cleaner.
		System.out.println("=============== ===== === === === === === === === === ===");
		
		String fullName = lastName + ", " + firstName;
		//This is to truncate the name if it exceeds 15 characters
		if (fullName.length() > 15) {
		   fullName = fullName.substring(0, 15);
		}
		
		System.out.printf("%-15s %-5d %-3d %-3d %-3d %-3d %-3d %-3d %-3d %-3d %-3d\n",
		   fullName, pay, myCFA10000, myCFA5000, myCFA1000, myCFA500, myCFA100,
		   myCFA50, myCFA25, myCFA10, myCFA5);
		
	}

}
