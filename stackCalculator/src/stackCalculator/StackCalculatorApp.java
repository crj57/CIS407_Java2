//Caitlyn Janiszewski CIS 407 Stack Calculator
package stackCalculator;
import java.util.Scanner;


public class StackCalculatorApp {
	

	public static void main(String[] args) {
		StackCalculator calc = new StackCalculator();
		Scanner input = new Scanner(System.in);
		
		calc.displayWelcomeMessage();
		calc.displayCommands();
		
		while (!calc.command.equals("quit")) {
			System.out.print("stack> ");
			calc.command = input.nextLine().toLowerCase();
			String[] commandArray = calc.command.split(" ");
			
			if (commandArray[0].equals("push")) {
				try {
					double addNum = Double.parseDouble(commandArray[1]);
					calc.addItem(addNum);
					calc.listStack();
				} catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Must include number to add.");
				}
			} else if (commandArray[0].equals("add")) {
				calc.addNums();
			} else if (commandArray[0].equals("sub")) {
				calc.subNums();
			} else if (commandArray[0].equals("mult")) {
				calc.multNums();
			} else if (commandArray[0].equals("div")) {
				calc.divNums();
			} else if (commandArray[0].equals("clear")) {
				calc.clearStack();
				calc.listStack();
			} else if (commandArray[0].equals("list")) {
				calc.listStack();
			} else if (commandArray[0].equals("quit")) {
				break;
			} else {
				System.out.println("Invalid command, try again.");
			}
		}
		System.out.println("Thank you for using the Stack Calculator.");
		input.close();
	}
	
}
