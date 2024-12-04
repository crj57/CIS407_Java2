//Caitlyn Janiszewski CIS 407 Stack Calculator

package stackCalculator;
import java.util.Stack;

public class StackCalculator {
	String command = ""; 
	Stack<Double> s = new Stack<Double>(); 
	

	public void displayWelcomeMessage() {
		System.out.println("Welcome to the Stack Calculator.");
	}
	
	public void displayCommands() {
		System.out.println("Commands: push n, add, sub, div, list, clear, or quit");
	}
	
	public void addItem(double num) {
		s.push(num);
	}
	
	public double removeItem() {
		return s.pop();
	}
	
	public int getSize() {
		return s.size();
	}
	
	public void listStack() {
		if (getSize() == 0) {
			System.out.println("empty");
		} else {
		getValues();
		}
	}
	
	public void clearStack() {
		s.clear();
	}
	
	public void  getValues() {
		for (double num : s) {
			System.out.println(num);
		}
	}
	
	public double addNums() {
		double num1 = removeItem();
		double num2 = removeItem();
		double result = num1 + num2;
		addItem(result);
		listStack();
		return result;
	}
	
	public double subNums() {
		double num1 = removeItem();
		double num2 = removeItem();
		double result = num1 - num2;
		addItem(result);
		listStack();
		return result;
	}
	public double multNums() {
		double num1 = removeItem();
		double num2 = removeItem();
		double result = num1 * num2;
		addItem(result);
		listStack();
		return result;
	}
	public double divNums() {
		double num1 = removeItem();
		double num2 = removeItem();
		double result = num2 / num1;
		addItem(result);
		listStack();
		return result;
	}
}
