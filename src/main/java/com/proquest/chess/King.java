package com.proquest.chess;

import java.util.ArrayList;
import java.util.List;
import static com.proquest.chess.Direction.*;


public class King extends Piece 
{
	private final Direction[] directions = {North, NorthEast, East, SouthEast, South, SouthWest, West, NorthWest};

	public King(Color color) {
		super(color);
		type = Type.King;
	}

	@Override
	List<Move> makeMoves(Board board) {
		List<Move> moves = new ArrayList<>();
		for (Direction direction: directions) {
			Position newpos = position.add(direction.getPosition());
			if (mayLandOn(newpos, board)) {
				Move newMove = new Move(newpos);
				newMove.setCapture(board.getPiece(newpos));
				moves.add(newMove);
			}
		}
		
		return moves;
	}

}
