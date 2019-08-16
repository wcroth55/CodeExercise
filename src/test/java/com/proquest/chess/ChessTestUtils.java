package com.proquest.chess;

import static org.junit.Assert.fail;

import java.util.List;


/**
 * Find a Move (in a list of Move's) that goes to square (x,y).
 * Fail if there is no such Move.
 * 
 * @author Charles Roth
 */
public class ChessTestUtils
{
	public static Move findMoveToSquare (List<Move> moves, int x, int y) {
		for (Move move: moves) {
			Position pos = move.getPosition();
			if (pos.getX() == x  &&  pos.getY() == y)  return move;
		}
		fail ("Did not contain position " + x + " " + y);
		return null;
	}

}
