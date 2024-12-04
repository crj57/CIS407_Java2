//Caitlyn Janiszewski CIS407 Week 3 Lab Tic Tac Toe
package ticTacToe;
import java.util.Scanner;
import java.util.Arrays;


public class TicTacToe {
	String[][] grid = {
			{"|   |", "   |", "   |"},
			{"|   |", "   |", "   |"},
			{"|   |", "   |", "   |"}
	};
	String gridDivide = "+---+---+---+";
	int xOrO = 0;
	
	void displayWelcomeMessage() {
		System.out.println("Welcome to Tic Tac Toe");
	}
	
	void displayGrid() {
		System.out.println();
		System.out.println(gridDivide);
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(grid[i][j]);
			}
			System.out.println(sb.toString());
			System.out.println(gridDivide);
			sb.setLength(0);
		}
		System.out.println();
	}
	
	boolean isFull() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j].contains("X") || grid[i][j].contains("O")) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true; 
		
	}
	
	void startGame() {
		Scanner input = new Scanner(System.in);
		while (true) {
			if (this.takeTurn(input)) {
				if (xOrO == 0) {
					System.out.println("O is the winner!");
				} else {
					System.out.println("X is the winner!");
				}
				break;
			} else if (this.isFull()) {
				System.out.println("Game is tied!");
				break;		
			}
		}
		input.close();		
	}
	
	boolean takeTurn(Scanner input) {
		if (xOrO == 0) {
			System.out.println("X's turn");
			xOrO = 1;
		} else {
			System.out.println("O's turn");
			xOrO = 0;
		}
		
		System.out.print("Pick a row (1, 2, 3): ");
		int choiceRow = input.nextInt() - 1;
		System.out.print("Pick a column (1, 2, 3): ");
		int choiceCol = input.nextInt() - 1;
		
		while (grid[choiceRow][choiceCol].contains("X") || grid[choiceRow][choiceCol].contains("O")) {
			System.out.println("Already selected in game, please choose again.");
			System.out.print("Pick a row (1, 2, 3): ");
			choiceRow = input.nextInt() - 1;
			System.out.print("Pick a column (1, 2, 3): ");
			choiceCol = input.nextInt() - 1;
		}
		
		if (xOrO == 1) {
			grid[choiceRow][choiceCol] = grid[choiceRow][choiceCol].replace("   ", " X ");
		} else {
			grid[choiceRow][choiceCol] = grid[choiceRow][choiceCol].replace("   ", " O ");
		}
		
		this.displayGrid();
		
		return this.checkForWinner();
	}
	
	boolean checkForWinner() {
		String checking = "";
		//Checking rows
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0].contains("X")){
				checking = "X";
			} else if (grid[i][0].contains("O")){
				checking = "O";
			} else {
				continue;
			}
			if (grid[i][1].contains(checking) && grid[i][2].contains(checking)) {
				return true;
			}
		}
		//Checking columns
		for (int j = 0; j < 3; j++) {
			if (grid[0][j].contains("X")){
				checking = "X";
			} else if (grid[0][j].contains("O")){
				checking = "O";
			} else {
				continue;
			}
			if (grid[1][j].contains(checking) && grid[2][j].contains(checking)) {
				return true;
			}
		}
		//Checking diagonal
		if (grid[1][1].contains("X")) {
			checking = "X";
		} else if (grid[1][1].contains("O")) {
			checking = "O";	
		}
		
		if (grid[0][0].contains(checking) && grid[2][2].contains(checking)){
			return true;
		}else if (grid[2][0].contains(checking) && grid[0][2].contains(checking)) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		TicTacToe game1 = new TicTacToe();
		
		game1.displayWelcomeMessage();
		
		game1.displayGrid();
		
		
		game1.startGame();
	

	}

}
