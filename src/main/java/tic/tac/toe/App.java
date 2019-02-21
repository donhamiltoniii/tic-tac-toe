package tic.tac.toe;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		String result = "";
		
		System.out.println("Welcome to Donny's Tic Tac Toe Game!");
		System.out.println("Currently only available to two players...");
		System.out.println("------------------------------------");
		System.out.println("Player 'X' will go first");
		System.out.println();
		System.out.println("Instructions:");
		System.out.println("1. Enter the coordinates of the space on the board you'd like to play.");
		System.out.println("2. Continue trading turns until the game is over.");
		System.out.println("3. 'E's represent (E)mpty space");
		System.out.println();
		
		while(isNoWinner(result) && isNoDraw(result)) {
			System.out.println(game.printBoard());
			System.out.print("Please select the first coordinate of your play: ");
			int x = input.nextInt();
			input.nextLine();
			System.out.print("Please select the second coordinate of your play: ");
			int y = input.nextInt();
			input.nextLine();
			result = game.play(x, y);
			System.out.println();
			System.out.println(result);
		}
		
		System.out.println();
		System.out.println(game.printBoard());
		System.out.println("Thanks for playing!");
		
		input.close();
	}

	private static boolean isNoDraw(String result) {
		return !result.equals("The result is a draw");
	}

	private static boolean isNoWinner(String result) {
		return !result.equals("O is the winner") && !result.equals("X is the winner");
	}
}
