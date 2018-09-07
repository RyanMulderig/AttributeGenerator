package com.mulderig.chargen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DieTest {
	@Test
	public void testWasRolled() {
		int max = 6;
		Die d = new Die(max, new FixedValueSource(1));
		assertFalse(d.wasRolled());
	}


	@Test
	public void testGetValue() {
		int max = 6;
		Die d = new Die(max, new FixedValueSource(1));
		d.roll();
		int value = d.getValue();
		assertTrue(value <= max);
	}

	@Test 
	void testFair() {
		int numberOfDieToRoll = 100000;
		int dieType = 6;
		DieSet dice= new DieSet(numberOfDieToRoll, dieType, new RandomValueSource());
		dice.roll();
		double value = dice.getValue();
		double average = value / numberOfDieToRoll;
		checkAverage(average, dieType);
		checkFreqency(dice, dieType, numberOfDieToRoll);
	}

	void checkAverage(double average, int dieType) {
		double expectedValue = (dieType + 1.0) / 2.0;
		double allowedDistanceFromExpectedAverage = 0.01;
		double averageTooHighThreshold = expectedValue  + allowedDistanceFromExpectedAverage;
		double averageTooLowThreshold  = expectedValue  - allowedDistanceFromExpectedAverage;
		boolean tooHigh = average > averageTooHighThreshold;
		boolean tooLow  = average < averageTooLowThreshold;
		if (!tooLow && !tooHigh) {
			return;
		}
		
		String format = 
				"Average of %f implies die is not fair because the value is too %s"; 
		
		String message = null;
		if (tooHigh) {
			message = String.format(format, average, "high");
		}
		if (tooLow) {
			message = String.format(format, average, "low");
		}
		System.out.println(message);
		assertTrue(false);
	}


	void checkFreqency(DieSet dice, int dieType, int rollCount) {
//		double expectedOccuranceFrequency = 1.0 / dieType;
//		double varianceFromExpectedFrequencyThreshold = 0.01;
//		double tooCommonThreshold = expectedOccuranceFrequency + varianceFromExpectedFrequencyThreshold;
//		double tooRareThreshhold = expectedOccuranceFrequency - varianceFromExpectedFrequencyThreshold;
//
//		for (int face = 1; face <= dieType; face++) {
//			boolean tooCommon = valueFrequency > tooCommonThreshold;
//			boolean tooRare = valueFrequency < tooRareThreshhold;
//			if (tooCommon) {
//				System.out.println("Occurance frequency of " + valueFrequency + " for " + face 
//						+ " implies die is not fair because the value occurs too often");
//				assertTrue(false);
//			}
//			if (tooRare) {
//				System.out.println("Occurance frequency of " + valueFrequency + " for " + face 
//						+ " implies die is not fair because the value occurs too rarely");
//				assertTrue(false);
//			}
//
//		}
	}
}
