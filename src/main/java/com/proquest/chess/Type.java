package com.proquest.chess;

import java.util.Arrays;
import java.util.List;


public enum Type {
	King("K"),
	Queen("Q"),
	Bishop("B"),
	Knight("N"),
	Rook("R"),
	Pawn("P"),
	Nothing("");
	
	public static final List<Type> promotions = Arrays.asList(new Type [] {Queen, Rook, Bishop, Knight});
	
	private String symbol;
	
	
	
	Type(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
}
