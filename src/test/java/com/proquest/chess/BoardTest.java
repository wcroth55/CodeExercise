package com.proquest.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class BoardTest
{
	private Board board;
	
	@Before
	public void setUp() {
		board = new Board();
	}
	
	@Test
	public void shouldHaveNoPiecesOnEmptyBoard() {
		assertEquals (0, board.getPieces(Color.White).size());
		assertEquals (0, board.getPieces(Color.Black).size());
		Position pos;
		for (int x=0;   x<8;   ++x) {
			for (int y=0;  y<8;   ++y) {
				pos = new Position(x, y);
				assertNull (board.getPiece(pos));
			}
		}
	}
	
	@Test
	public void shouldHaveNoPiecesOutsideBoard() {
		assertNull (board.getPiece(new Position(-1,  0)));
		assertNull (board.getPiece(new Position( 0, -1)));
		assertNull (board.getPiece(new Position( 8,  8)));
	}
	
	@Test
	public void shouldPlaceKing_andVerifyPlacement() {
		King king = new King(Color.White);
		assertNull (king.getPosition());
		
		Position kingSpot = new Position(4, 0);
		board.placePiece(king, kingSpot);
		
		Set<Piece> whitePieces = board.getPieces(Color.White);
		assertEquals (1, whitePieces.size());
		for (Piece piece: whitePieces) {
			assertEquals (king, piece);
		}
		
		assertEquals (king, board.getPiece(kingSpot));
		assertEquals (4, king.getPosition().getX());
		assertEquals (0, king.getPosition().getY());
	}
	
	@Test
	public void shouldThrowException_whenPlacingPieceOutsideBoard() {
		King king = new King(Color.White);
		try {
			board.placePiece(king, new Position(-1, -1));
			fail();
		}
		catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	public void shouldCaptureKnight_byPlacingKingOnSameSquare() {
		Knight blackKnight = new Knight(Color.Black);
		Position pos = new Position(4, 4);
		board.placePiece(blackKnight, pos);
		assertEquals (1, board.getPieces(Color.Black).size());
		
		King whiteKing = new King(Color.White);
		board.placePiece(whiteKing, pos);
		
		assertEquals (0, board.getPieces(Color.Black).size());
		assertEquals (1, board.getPieces(Color.White).size());
		assertEquals (whiteKing, board.getPiece(pos));
	}
	
	@Test
	public void shouldPrintBoard() {
		King whiteKing = new King(Color.White);
		board.placePiece(whiteKing, new Position(4, 0));
		
		Knight blackKnight = new Knight(Color.Black);
		board.placePiece(blackKnight, new Position(6, 7));
		
		String [] printout = board.preparePrintoutRows();
		assertEquals ("|...|   |...|   |.K.|   |...|   |", printout[1]);
		assertEquals ("|   |...|   |...|   |...| n |...|", printout[15]);
		
		board.print();
	}
	

}
