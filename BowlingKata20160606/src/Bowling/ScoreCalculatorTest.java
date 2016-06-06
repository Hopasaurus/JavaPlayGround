package Bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class ScoreCalculatorTest extends TestCase {
	private ScoreCalculator calculator;
	
	protected void setUp() throws Exception {
		// This is the setup common to all test cases in this test class
		// all of the tests will need to use the calculator so we
		// instantiate it here:
		calculator = new ScoreCalculator();
		
		super.setUp();
	}

	public void testGetScore_ReturnsZero_WhenNoBallsRolled() {
		// One common testing style is: "Arrange, Act, Assert"
		// This is where the test is laid out in a very clear style
		// with each of the stages of the test clearly separated.
		
		//Arrange - perform any setup specific to this test case
		List<Integer> rolls = new ArrayList<Integer>();
		Integer expectedScore = 0;

		//Act - perform the action under test
		Integer actualScore = calculator.GetScore(rolls);
		
		//Assert - check the results of the test
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsOne_WhenSinglePinIsDowned() {
		List<Integer> rolls = Arrays.asList(1);
		Integer expectedScore = 1;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsTwenty_WhenSpareIsFollowedByFive() {
		List<Integer> rolls = Arrays.asList(3,7,5);
		Integer expectedScore = 20;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsTen_WhenSpareIsNotFollowedByAnything() {
		List<Integer> rolls = Arrays.asList(3,7);
		Integer expectedScore = 10;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsSixteen_WhenStrikeIsFoolowedByThree() {
		List<Integer> rolls = Arrays.asList(10,3);
		Integer expectedScore = 16;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsTwenty_WhenStrikeIsFoolowedByThreeAndTwo() {
		List<Integer> rolls = Arrays.asList(10,3,2);
		Integer expectedScore = 20;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}

	public void testGetScore_ReturnsThreeHundred_WhenRollingPerfectGame() {
		List<Integer> rolls = Arrays.asList(10,10,10,10,10,10,10,10,10,10,10);
		Integer expectedScore = 300;

		Integer actualScore = calculator.GetScore(rolls);
		
		assertEquals(expectedScore, actualScore);
	}
}
