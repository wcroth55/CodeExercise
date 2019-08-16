package com.proquest.kata;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class PrimeFactorizerTest
{
	private PrimeFactorizer factorizer;
	
	@Before
	public void setup() {
	   factorizer = new PrimeFactorizer();
	}

	@Test
	public void test1() {
	   assertEquals (listOf(), factorizer.getFactors(1));
	}

	private List<Integer> listOf(Integer ... numbers) {
	   List<Integer> results = new ArrayList<Integer>();
	   for (Integer number: numbers)
	      results.add(number);
	   return results;
	}

}
