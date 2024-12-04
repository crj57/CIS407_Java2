//Caitlyn Janiszewski CIS407 Week 1 Guessing Game
package guessingGame;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner; 

public class Game {
	int num;
	int guessNumber;
	int counter = 0; 
	int prevGuess = 0; 
	
	void generateNumberToBeGuessed() {
		Random rand = new Random();
		num = rand.nextInt(99) + 1;
	}
	
	void makeGuess(int number) {
		guessNumber = number;
		counter += 1;
		
	}
	
	boolean isCorrectGuess() {
		if (guessNumber == num) {
			return true;
		}else {
			return false;
		}
	}
	
	void displayWelcomeMessage() {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++\n");
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it.\n");
	}
	
	void displayPleaseGuessMessage() {
		System.out.print("Enter a number between 1 and 100: ");
	}
	
	void displayCorrectGuessMessage(){
		System.out.println("You got it in " + counter + " tries.");
		if (counter <= 3) {
			System.out.println("Great work! You are a mathematical wizard.\n");
		} else if (counter >= 4 && counter <= 7) {
			System.out.println("Not too bad! You've got some potential.\n");
		} else {
			System.out.println("What took you so long.\n");
		}
		counter = 0;
		prevGuess = 0;
	}
	
	void addLogic() {
		/*if (guessNumber > num && (guessNumber - num) > 10 ) {
			System.out.println("Way too high! Guess again.\n");
		} else if (guessNumber > num && (guessNumber - num) <= 10 ) {
			System.out.println("Too high! Guess again.\n");
		} else if (guessNumber < num && (num - guessNumber) > 10 ) {
			System.out.println("Way too low! Guess again.\n");
		} else if (guessNumber < num && (num - guessNumber) <= 10 ) {
			System.out.println("Too low! Guess again.\n");
		}
		*/
		if (guessNumber > num) {
			System.out.println("Too high");
		} else if(guessNumber < num) {
			System.out.println("Too low");
		}
		
		if (Math.abs(num - guessNumber)< Math.abs(num - prevGuess)) {
			System.out.println("Getting warmer");
		} else if (Math.abs(num - guessNumber) > Math.abs(num - prevGuess)){
			System.out.println("Getting colder");
		}
		prevGuess = guessNumber;
	}
	
	void displayGuessAgainMessage() {
		System.out.print("Try again? (y/n): ");
	}
	
	public static void main(String[] args) {
		String cont = "y";
		Game guessingGame = new Game();
		
		guessingGame.displayWelcomeMessage();
		
		Scanner input = new Scanner(System.in);
		
		while (!cont.equals("n")){
			guessingGame.generateNumberToBeGuessed();
			guessingGame.displayPleaseGuessMessage();
			
			while (guessingGame.guessNumber != guessingGame.num) {
				guessingGame.makeGuess(input.nextInt());
				if(guessingGame.isCorrectGuess()) {
					guessingGame.displayCorrectGuessMessage();
					break;
				} else {
					guessingGame.addLogic();
					guessingGame.displayPleaseGuessMessage();
				}
				
			}
			guessingGame.displayGuessAgainMessage();
			cont = input.next().toLowerCase();
			System.out.println();
		}
		input.close();
		System.out.println("Bye - Come back soon!");
	}

}
