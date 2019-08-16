package com.proquest.chess;

import java.util.ArrayList;
import java.util.List;


public class Knight extends Piece
{

	public Knight(Color color) {
		super(color);
		type = Type.Knight;
	}

	@Override
	List<Move> makeMoves(Board board) {
		return new ArrayList<Move>();
	}

}
