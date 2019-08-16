package com.proquest.chess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class KingTest
{
	
	@Test
	public void shouldGetLowerCaseK_forBlackKing() {
		King king = new King(Color.Black);
		assertEquals ("k", king.toString());
	}
	
	@Test
	public void shouldGetUpperCaseK_forBlackKing() {
		King king = new King(Color.White);
		assertEquals ("K", king.toString());
	}

}
