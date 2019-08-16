package com.proquest.chess;

import java.util.List;


public abstract class Piece
{
	protected Color color;
	protected Type  type;
	protected Position position;
	
	public Piece (Color color) {
		this.color = color;
		position = null;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setPosition (Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Type getType() {
		return type;
	}

	public String toString() {
		return (color == Color.White ? type.getSymbol() : type.getSymbol().toLowerCase());
	}
	
	// Note that this will not work for pawns, and will have to be overridden.
	protected boolean mayLandOn (Position pos, Board board) {
		if (! pos.isValid())  return false;
		Piece piece = board.getPiece(pos);
		return (piece == null  ||  piece.getColor() != color);
	}
	
	abstract List<Move> makeMoves(Board board) ;
}
