package com.proquest.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class KingTest
{
	private Board board;
	private King king;
	
	@Before
	public void setUp() {
		board = new Board();
		king = new King(Color.White);
	}
	

	@Test
	public void shouldGetUpperCaseK_forWhiteKing() {
		assertEquals ("K", king.toString());
	}
	
	@Test
	public void shouldGetLowerCaseK_forBlackKing() {
		king = new King(Color.Black);
		assertEquals ("k", king.toString());
	}
	
	@Test
	public void shouldFindAllKingMoves_fromMidBoard() {
		board.placePiece(king, new Position(4, 2));
		
		List<Move> moves = king.makeMoves(board);
		assertEquals (8, moves.size());
		ChessTestUtils.findMoveToSquare(moves, 4, 3);
		ChessTestUtils.findMoveToSquare(moves, 5, 3);
		ChessTestUtils.findMoveToSquare(moves, 5, 2);
		ChessTestUtils.findMoveToSquare(moves, 5, 1);
		ChessTestUtils.findMoveToSquare(moves, 4, 1);
		ChessTestUtils.findMoveToSquare(moves, 3, 1);
		ChessTestUtils.findMoveToSquare(moves, 3, 2);
		ChessTestUtils.findMoveToSquare(moves, 3, 3);
	}
	
	@Test
	public void shouldFindAllKingMoves_fromStartingPosition() {
		board.placePiece(king, new Position(4, 0));
		
		List<Move> moves = king.makeMoves(board);
		assertEquals (5, moves.size());
		ChessTestUtils.findMoveToSquare(moves, 4, 1);
		ChessTestUtils.findMoveToSquare(moves, 5, 1);
		ChessTestUtils.findMoveToSquare(moves, 5, 0);
		ChessTestUtils.findMoveToSquare(moves, 3, 1);
		ChessTestUtils.findMoveToSquare(moves, 3, 0);
	}
	
	@Test
	public void shouldFindKingMove_withCapture() {
		board.placePiece(king, new Position(0, 0));
		
		Bishop bishop = new Bishop(Color.Black);
		board.placePiece(bishop, new Position(0,1));
		
		List<Move> moves = king.makeMoves(board);
		assertEquals (3, moves.size());
		Move capture = ChessTestUtils.findMoveToSquare(moves, 0,  1);
		assertEquals (bishop, capture.getCapture());
	}
	
	@Test
	public void shouldNotFindKingMove_overOwnPiece() {
		board.placePiece(king, new Position(0, 0));
		
		Bishop bishop = new Bishop(Color.White);
		board.placePiece(bishop, new Position(0,1));
		
		List<Move> moves = king.makeMoves(board);
		assertEquals (2, moves.size());
		ChessTestUtils.findMoveToSquare(moves, 1, 0);
		ChessTestUtils.findMoveToSquare(moves, 1, 1);
	}

}
