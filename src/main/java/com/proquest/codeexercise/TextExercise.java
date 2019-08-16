package com.proquest.codeexercise;

/**
 * A collection of java code and unit-test exercises.
 * 
 * @author Charles Roth (with ideas stolen from a variety of places).
 *
 */
public class TextExercise {
	
	/**
	 * In English, words on a line are read left-to-right.  In some other languages, words are read
	 * right-to-left instead.
	 * 
	 * For this exercise, assume that we have been given a single text string, containing 0, 1, or more 
	 * lines (separated by the newline character \n).   Reverse the order of the words in *each* line,
	 * and return a new String containing the resulting text.  Maintain the same number of lines.
	 * 
	 * Assume that words are separated by (one or more) spaces.  You do not need to preserve multiple 
	 * spaces between words.  Do not worry about punctuation at the end of a word, just treat it as
	 * part of the word.
	 * 
	 * So, for example, "Hello, world!" should be transformed into "world! Hello,".
	 * 
	 * There is already one unit-test in the TextExerciseTest class that verifies the "Hello, world!"
	 * case.  Use that to get your code working.  If you have time, add new unit-tests for the
	 * 0 line, and 2 or greater line cases, including lines that contain nothing but a newline.
	 * Decide how you want to handle a null input, and write a test for it.  
	 * 
	 * Don't worry about whether the last line should end in a newline -- either "yes" or "no" 
	 * is acceptable.  You chose.  If possible, "test drive" your code with TDD.
	 * 
	 * You may use any existing methods in the regular Java.lang.String package.  Do not worry
	 * about making it efficient at first, just get it working.  Then think about how 
	 * it might be simpler or more efficient, while still passing all the tests.
	 */
	public String reverseWordPositionsInAllLines (String text) {
		return text;
	}

}
