package com.proquest.chess;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PositionTest
{
	@Test
	public void shouldReportSquaresInsideBoard_asValid() {
		Position pos;
		for (int x=0;   x<8;   ++x) {
			for (int y=0;  y<8;   ++y) {
				pos = new Position(x, y);
				assertTrue (pos.isValid());
			}
		}
	}
	
	@Test
	public void shouldReportSquaresOutsideBoard_asInvalid() {
		assertFalse ((new Position(-1,  0)).isValid());
		assertFalse ((new Position( 0, -1)).isValid());
		assertFalse ((new Position( 8,  8)).isValid());
	}
	
	@Test
	public void shouldAdd() {
		Position pos1 = new Position(3, 4);
		Position delta = new Position (1, 1);
		Position sum   = pos1.add(delta);
		assertTrue (sum.equals(new Position (4, 5)));
	}

}
