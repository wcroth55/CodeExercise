package com.proquest.chess;

import java.util.ArrayList;
import java.util.List;


public class King extends Piece 
{

	public King(Color color) {
		super(color);
		type = Type.King;
	}

	@Override
	List<Move> makeMoves(Board board) {
		return new ArrayList<Move>();
	}

}
