package com.proquest.codeexercise;

import java.util.ArrayList;
import java.util.List;


public class DieRollerExaminer {
	private DieRoller roller;
	private List<Integer> rolls;
	
	public DieRollerExaminer (DieRoller roller) {
		this.roller = roller;
		rolls = new ArrayList<Integer>();
	}
	
	public void roll(int times) {
		for (int i=0;   i<times;  ++i) {
			try {
				Integer result = roller.getNextRoll();
				rolls.add(result);
			}
			catch (Exception e) {
				break;
			}
		}
	}
	
	public float getAverage() {
		int sum = 0;
		for (int i=0;   i<rolls.size();   ++i)  
			sum += rolls.get(i);
		return ((float) sum) / ((float) rolls.size());
	}
	
	public int getRecordedRolls() {
		return rolls.size();
	}

}
