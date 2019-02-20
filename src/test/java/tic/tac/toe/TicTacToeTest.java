package tic.tac.toe;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TicTacToeTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	private TicTacToe ticTacToe;
	
	@Before
	public final void setup() {
		ticTacToe = new TicTacToe();
	}
	
	@Test
	public void whenXOutsideBoard_ThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(5, 2);
	}
	
	@Test
	public void whenYOutsideBoard_ThenRuntimeException() {
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 5);
	}
	
	@Test
	public void whenOccupied_ThenRuntimeException() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		ticTacToe.play(2, 1);
	}
	
	@Test
	public void givenFirstTurn_WhenNextPlayer_ThenX() {
		assertEquals('X', ticTacToe.nextPlayer());
	}
	
	@Test
	public void givenLastTurnWasX_WhenNextPlayer_ThenO() {
		ticTacToe.play(1, 1);
		assertEquals('O', ticTacToe.nextPlayer());
	}
	
	@Test
	public void whenPlay_ThenNoWinner() {
		String actual = ticTacToe.play(1, 1);
		assertEquals("No winner", actual);
	}
	
	@Test
	public void whenPlay_AndWholeHorizontalLine_ThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 2);
		String actual = ticTacToe.play(3, 1);
		
		assertEquals("X is the winner", actual);
	}
	
	@Test
	public void whenPlay_AndWholeVerticalLine_ThenWinner() {
		ticTacToe.play(2, 1);
		ticTacToe.play(1, 1);
		ticTacToe.play(3, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		String actual = ticTacToe.play(1, 3);
		assertEquals("O is the winner", actual);
	}
	
	@Test
	public void whenPlay_AndTopBottomDiagonalLine_ThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		ticTacToe.play(1, 3);
		String actual = ticTacToe.play(3, 3);
		assertEquals("X is the winner", actual);
	}
	
	@Test
	public void whenPlay_AndBottomTopDiagonalLine_ThenWinner() {
		ticTacToe.play(1, 1);
		ticTacToe.play(3, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(1, 3);
		assertEquals("O is the winner", actual);
	}
	 
	@Test
	public void whenAllBoxesAreFilled_ThenDraw() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(3, 2);
		assertEquals("The result is a draw", actual);
	}

}
