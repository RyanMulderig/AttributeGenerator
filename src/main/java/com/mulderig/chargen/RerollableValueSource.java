package com.mulderig.chargen;

public class RerollableValueSource implements ValueSource {
	private final ValueSource underlyingSource;
	private int minValue = 1;
	private int maxRolls = 1;
	private int rollCount;
	
	public RerollableValueSource(ValueSource underlyingSource) {
		this.underlyingSource = underlyingSource;
	}
	
	public void setDieMinimum(int minValue) {
		this.minValue = minValue;
	}

	public void setRollsAllowed(int count) {
		this.maxRolls = count;
	}

	@Override
	public int getValue(int faces) {
		int value;
		do { 
			value = underlyingSource.getValue(faces);
			rollCount++;
		} while (rollCount < maxRolls && value < minValue);
		return value;
	}
}
