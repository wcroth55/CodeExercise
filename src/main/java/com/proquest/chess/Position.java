package com.proquest.chess;


public class Position
{
	private int x;
	private int y;
	
	public Position (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isValid() {
		return (x >= 0  &&  x < 8  &&  y >= 0  &&  y < 8);
	}
	
	public Position add (Position other) {
		return new Position (this.x + other.x, this.y + other.y);
	}
	
	public boolean equals (Position other) {
		return this.x == other.x  &&  this.y == other.y;
	}
	
}
