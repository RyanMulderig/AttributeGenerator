package com.mulderig.chargen;

public class Attribute  {
	private static int DIE = 6;
	DieSet dice; 
	
	public Attribute() {
		ValueSource underlyingSource = new RandomValueSource();
		RerollableValueSource valueSource = new RerollableValueSource(underlyingSource);
		valueSource.setRollsAllowed(2);
		valueSource.setDieMinimum(2);
		dice = new DieSetDropsLowest(4, DIE, valueSource);
		dice.roll();
	}
	
	public int getValue() {
		return dice.getValue();
	}
}
