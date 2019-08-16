package com.proquest.codeexercise;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.proquest.codeexercise.TextExercise;

public class TextExerciseTest {
	
	@Test
	public void shouldReverseHelloWorld() {
		TextExercise exercise = new TextExercise();
		assertEquals ("world! Hello,", exercise.reverseWordPositionsInAllLines("Hello, world!"));
	}

}


