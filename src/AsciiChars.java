import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class AsciiChars 
{
  public static void printNumbers()
  {
    for (int i = 48; i<58; ++i) {
    	System.out.print(((char) i)+ " ");
    }
    System.out.println();
  }

  public static void printLowerCase()
  {
	  for (int i = 97; i<123; ++i) {
	    	System.out.print(((char) i)+ " ");
	    }
	  System.out.println();
  }

  public static void printUpperCase()
  {
	  for (int i = 65; i<91; ++i) {
	    	System.out.print(((char) i)+ " ");
	    }
	  System.out.println();
  }
  
  public static int lessThan65(int x) {
	  while (x>65) {x-=65;}
	  return x;
  }
 
  
  
  public static void main(String[] args) {
	  
	  Scanner input = new Scanner(System.in);
	  Random rand = new Random();
	  
	  AsciiChars.printNumbers();
	  AsciiChars.printUpperCase();
	  AsciiChars.printLowerCase();
	  
	  System.out.print("Please Enter Your Name: ");
	  String userName = input.nextLine();
	  System.out.printf("Hello %s\n", userName);
	  
	  System.out.print("Would you like to continue to the interactive portion? y or n ");
	  String userAnswer = input.nextLine();
	  
	  ArrayList luckyNumbers = new ArrayList<>();
	  boolean interested = true;
	  
	  if(userAnswer.equals("y")||userAnswer.equals("yes")) {
	  		while (interested) {
	  			System.out.println("What's your favorite pet's name?");
	  			int petChar = (char) input.nextLine().charAt(2);
	  			
	  			System.out.println("How old is your favorite pet?");
	  			Integer petAge = Integer.parseInt(input.nextLine());
	  			
	  			System.out.println("What is your lucky number?");
	  			Integer luckyNum = Integer.parseInt(input.nextLine());

	  			System.out.println("Do you have a favorite quarterback? (y, n)");
	  			boolean hasFav = input.nextLine().equals("y");
	  			
	  			
	  			int jerseyNum = 0;
	  			if (hasFav) {
		  			System.out.println("What is the Jersey number of your favorite quarterback?");
		  			jerseyNum = Integer.parseInt(input.nextLine());
	  			}
	  			
	  			System.out.println("What is the two-digit model year of your car?");
	  			Integer modelYear = Integer.parseInt(input.nextLine());
	  			
	  			
	  			System.out.println("What is the first name of your favorite actor?");
	  			String actor = input.nextLine();
	  			int actorFirst = (char) actor.charAt(0);
	  			int actorLast = (char) actor.charAt(actor.length()-1);
	  			
	  			
	  			System.out.println("Enter a random number from 1-50");
	  			Integer randomNum = Integer.parseInt(input.nextLine());
	  			while(randomNum > 50 || randomNum < 1) {
	  				System.out.println("That number is not within the required range. Please provide a random number from 1-50");
		  			randomNum = Integer.parseInt(input.nextLine());
	  			}
	  			//#####################################################################
	  			//Generate Random numbers
	  			int upperBound = 66;
	  			int intRandom1 = 1+rand.nextInt(upperBound); 
	  			int intRandom2 = 1+rand.nextInt(upperBound); 
	  			int intRandom3 = 1+rand.nextInt(upperBound);
	  			
	  			
	  			//Calculate MagicBall
	  			int magicBall;
	  			if (rand.nextInt(2)==1) {
	  				magicBall = intRandom1*jerseyNum;
	  			} else {magicBall = intRandom1*luckyNum;}
	  			
		  		while (magicBall > 75) {magicBall-=75;}
	  			
	  			
	  			//#####################################################################
	  			//Number Conversion and Add to List
	  			
	  		
	  			luckyNumbers.add(lessThan65(petChar));
	  			luckyNumbers.add(lessThan65(modelYear+luckyNum));
	  			luckyNumbers.add(Math.abs(randomNum-intRandom1));
	  			luckyNumbers.add(lessThan65(42+petAge+modelYear));
	  			if (jerseyNum != 0) {
	  				luckyNumbers.add(lessThan65(jerseyNum+intRandom3+modelYear));
	  			} else {luckyNumbers.add(lessThan65(intRandom2+actorFirst+actorLast));}
	  			//#####################################################################
	  			//Print Out Results
		  		Collections.sort(luckyNumbers);
		  		System.out.printf("Lottery numbers: %d, %d, %d, %d, %d Magic ball: %d\n", luckyNumbers.get(0),
		  				luckyNumbers.get(1),
		  				luckyNumbers.get(2),
		  				luckyNumbers.get(3),
		  				luckyNumbers.get(4),
		  				magicBall);

		  		
	  			//#####################################################################
	  			//Take Quiz Again Logic
	  			System.out.println("Would you like to take the quiz again? (y or n)");
	  			String stillInterested = input.nextLine();
	  			if (stillInterested.equals("n")){interested = false;System.out.println("\nSee you later!");}
	  		}
		  
	  } else {System.out.println("\nPlease return later to complete the survey.");}
  	}
 }
//Feedback for this activity: The instructions were EXTREMELY unclear and I had to rewrite this several times. There are multiple ways to make this
//less cumbersome on the programmer (Implementation of separate helper functions, try catch blocks, etc.) and I think that this lab should be revised for future courses.
