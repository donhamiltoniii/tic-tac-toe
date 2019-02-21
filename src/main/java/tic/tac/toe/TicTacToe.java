package tic.tac.toe;

public class TicTacToe {

	private static final int SIZE = 3;

	private char lastPlayer = 'E';

	private char[][] board = { { 'E', 'E', 'E' }, { 'E', 'E', 'E' }, { 'E', 'E', 'E' } };

	private void checkAxis(int axis) {
		if (axis < 1 || axis > 3) {
			throw new RuntimeException("Choice is outside of the board");
		}
	}

	public String play(int x, int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();
		setBox(x, y, lastPlayer);
		return printResult(x, y);
	}

	private String printResult(int x, int y) {
		if (isWin(x, y)) {
			return lastPlayer + " is the winner";
		} else if (isDraw()) {
			return "The result is a draw";
		}
		return "No winner";
	}

	private boolean isDraw() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] == 'E') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isWin(int x, int y) {
		int playerTotal = lastPlayer * 3;
		char horizontal, vertical, diagonal1, diagonal2;
		horizontal = vertical = diagonal1 = diagonal2 = '\0';
		for (int i = 0; i < SIZE; i++) {
			horizontal += board[i][y - 1];
			vertical += board[x - 1][i];
			diagonal1 += board[i][i];
			diagonal2 += board[i][SIZE - i - 1];
			if (horizontal == playerTotal || vertical == playerTotal || diagonal1 == playerTotal
					|| diagonal2 == playerTotal) {
				return true;
			}
		}
		return false;
	}

	private void setBox(int x, int y, char lastPlayer) {
		if (board[x - 1][y - 1] != 'E') {
			throw new RuntimeException("Box is occupied!");
		} else {
			board[x - 1][y - 1] = lastPlayer;
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

	public String printBoard() {
		String boardState = "";
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				boardState += board[i][j];
				boardState += " ";
			}
			boardState += "\n\n";
		}
		return boardState;
	}

}
