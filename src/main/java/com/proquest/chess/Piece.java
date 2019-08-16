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
	
	abstract List<Move> makeMoves(Board board) ;
}
