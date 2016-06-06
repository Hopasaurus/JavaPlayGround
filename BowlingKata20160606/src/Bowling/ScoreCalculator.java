package Bowling;

import java.util.List;

public class ScoreCalculator {
	private Integer score = 0;
	private Integer rollIndex = 0;
	private Integer frameIndex = 0;
	private Integer frameScore = 0;

	public Integer GetScore(List<Integer> rolls) {
		Integer rollCount = rolls.size();
		
		for (rollIndex = 0; rollIndex < rollCount; ++rollIndex) {
			accumulateNewPins(rolls);
			manageFrame(rolls);
		}
		
		return score;
	}

	private void accumulateNewPins(List<Integer> rolls) {
		int pins = rolls.get(rollIndex);
		frameScore += pins;
		score += pins;
	}

	private void manageFrame(List<Integer> rolls) {
		if(frameComplete()) {
			calculateStrikeBonus(rolls);
			calculateSpareBonus(rolls);
			resetFrame();
		} else {
			moveToSecondHalfOfFrame();
		}
	}

	private boolean frameComplete() {
		return frameIndex > 1 || frameScore == 10;
	}

	private void calculateStrikeBonus(List<Integer> rolls) {
		if(isStrike()) {
			getBonusFromFutureRoll(rolls, 1);
			getBonusFromFutureRoll(rolls, 2);
		}
	}

	private void getBonusFromFutureRoll(List<Integer> rolls, int offset) {
		if(rollIndex + offset < rolls.size()) {
			score += rolls.get(rollIndex + offset);
		}
	}

	private boolean isStrike() {
		return frameIndex == 0 && frameScore == 10;
	}

	private void calculateSpareBonus(List<Integer> rolls) {
		if(isSpare()) {
			getBonusFromFutureRoll(rolls, 1);
		}
	}
	
	private boolean isSpare() {
		return frameIndex == 1 && frameScore == 10;
	}

	private void resetFrame() {
		frameScore = 0;
		frameIndex = 0;
	}

	private void moveToSecondHalfOfFrame() {
		frameIndex += 1;
	}
}
