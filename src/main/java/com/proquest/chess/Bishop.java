package com.proquest.chess;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece
{

	public Bishop(Color color) {
		super(color);
		type = Type.Bishop;
	}

	@Override
	List<Move> makeMoves(Board board) {
		return new ArrayList<Move>();
	}

}
