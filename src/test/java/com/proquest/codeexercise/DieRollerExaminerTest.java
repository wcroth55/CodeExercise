package com.proquest.codeexercise;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.proquest.codeexercise.DieRoller;
import com.proquest.codeexercise.DieRollerExaminer;


public class DieRollerExaminerTest {
	private DieRoller mockDieRoller;
	private DieRollerExaminer examiner;
	
	@Before
	public void setup() {
		mockDieRoller = EasyMock.createMock(DieRoller.class);
		examiner = new DieRollerExaminer(mockDieRoller);
	}
	
	@Test
	public void shouldRollDieOnce_andGetAverageOfRollValue() {
		expect (mockDieRoller.getNextRoll()).andReturn(3);
		
		EasyMock.replay(mockDieRoller);
		examiner.roll(1);
		float average = examiner.getAverage();
		EasyMock.verify(mockDieRoller);
		
		assertEquals (1, examiner.getRecordedRolls());
		assertEquals (3.0, average, 0.001);
	}
	
	@Test
	public void shouldRollDieFourTimes_andGetAverage() {
		expect (mockDieRoller.getNextRoll()).andReturn(3).times(2);
		expect (mockDieRoller.getNextRoll()).andReturn(4).times(2);
		
		EasyMock.replay(mockDieRoller);
		examiner.roll(4);
		float average = examiner.getAverage();
		EasyMock.verify(mockDieRoller);
		
		assertEquals (4, examiner.getRecordedRolls());
		assertEquals (3.5, average, 0.001);
	}
	
	@Test
	public void shouldDetectWrongNumberOfRolls_whenExceptionHappens() {
		expect (mockDieRoller.getNextRoll()).andReturn(6).times(2);
		expect (mockDieRoller.getNextRoll()).andThrow(new NullPointerException());
		
		EasyMock.replay(mockDieRoller);
		examiner.roll(4);
		EasyMock.verify(mockDieRoller);
		
		assertEquals (2, examiner.getRecordedRolls());
	}

}
