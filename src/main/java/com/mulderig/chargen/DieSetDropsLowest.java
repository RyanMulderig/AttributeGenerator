package com.mulderig.chargen;

import static java.util.Comparator.comparingInt;

public class DieSetDropsLowest extends DieSet {
	DieSetDropsLowest(int numberOfDice, int faces, ValueSource valueSource) {
		super(numberOfDice, faces, valueSource);
	}
	
	public void roll() {
		super.roll();
		dice.sort(comparingInt(Die::getValue));
		dice.remove(0);
	}
}
