package com.proquest.chess;

import java.util.HashSet;
import java.util.Set;


public class Board
{
	private Piece [][] pieceAt;
	private Set<Piece> whitePieces;
	private Set<Piece> blackPieces;
	
	public Board() {
		pieceAt = new Piece[8][8];
		for (int x=0;   x<8;   ++x) {
			for (int y=0;   y<8;   ++y) {
				pieceAt[x][y] = null;
			}
		}
		
		whitePieces = new HashSet<Piece>();
		blackPieces = new HashSet<Piece>();
	}
	
	public Set<Piece> getPieces (Color color) {
		return (color == Color.White ? whitePieces : blackPieces);
	}
	
	public Piece getPiece (Position position) {
		return (position.isValid() ? pieceAt[position.getX()][position.getY()] : null);
	}
	
	public void placePiece (Piece piece, Position position) {
		if (! position.isValid()) {
			throw new IllegalArgumentException();
		}
		
		removeCapturedPiece(position);
		addNewPieceToItsSide(piece);
		
		piece.setPosition(position);
		pieceAt[position.getX()][position.getY()] = piece;
	}
	
	private void removeCapturedPiece (Position position) {
		Piece capturedPiece = pieceAt[position.getX()][position.getY()];
		if (capturedPiece != null) {
			Set<Piece> pieces = getPieces(capturedPiece.getColor());
			pieces.remove(capturedPiece);
		}
	}
	
	private void addNewPieceToItsSide(Piece piece) {
		Set<Piece> sameColorPieces = getPieces(piece.getColor());
		if (! sameColorPieces.contains(piece))
			sameColorPieces.add(piece);
	}
	
	private static final String rowDivider = "+---+---+---+---+---+---+---+---+";
	
	public String [] preparePrintoutRows() {
		String [] result = new String[17];
		for (int y=0;   y<8;   ++y) {
			result[2*y] = rowDivider;
			StringBuffer row = new StringBuffer("|");
			String edge;
			for (int x=0;   x<8;   ++x) {
				edge = (x+y) % 2 == 0 ? "." : " ";
				Piece piece = pieceAt[x][y];
				row.append (edge + (piece != null ? piece.toString() : edge) + edge + "|");
			}
			result[2*y + 1] = row.toString();
		}
		
		result[16] = rowDivider;
		return result;
	}
	
	public void print() {
		String [] rows = preparePrintoutRows();
		for (int y=rows.length-1;   y>=0;   --y) {
			System.err.println (rows[y]);
		}
	}
	
	
}
