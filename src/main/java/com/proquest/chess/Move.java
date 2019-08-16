package com.proquest.chess;


public class Move
{
	private Position position;
	private Type promotedTo;
	private Piece capture;
	
	public Move (Position position) {
		this.position = position;
		this.promotedTo = Type.Nothing;
		this.capture = null;
	}
	
	public Move (Position position, Type type) {
		this.position = position;
		this.promotedTo = type;
		this.capture = null;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public Type getPromotion() {
		return promotedTo;
	}
	
	public void setCapture (Piece piece) {
		this.capture = piece;
	}
	
	public Piece getCapture() {
		return capture;
	}

}
