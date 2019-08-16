package com.proquest.chess;


public enum Direction {
	North     ( 0,  1),
	NorthEast ( 1,  1),
	East      ( 1,  0),
	SouthEast ( 1, -1),
	South     ( 0, -1),
	SouthWest (-1, -1),
	West      (-1,  0),
	NorthWest (-1,  1);
	
	private final Position position;
	
	Direction(int deltaX, int deltaY) {
		position = new Position(deltaX, deltaY);
	}
	
	public Position getPosition() {
		return position;
	}

}
