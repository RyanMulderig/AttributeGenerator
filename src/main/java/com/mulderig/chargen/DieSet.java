package com.mulderig.chargen;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DieSet  {
	protected List<Die> dice = new LinkedList<>();
	
	DieSet(int numberOfDice, int faces, ValueSource valueSource) {
		for (int idx = 0; idx < numberOfDice; idx++) {
			Die die = new Die(faces, valueSource);
			dice.add(die);
		}
	}
	
	public void roll() {
		dice.forEach(Die::roll);
	}
	
	public int getValue() {
		return dice.stream()
				   .mapToInt(d -> d.getValue())
			       .sum();
	}

	public boolean wasRolled() {
		return dice.stream()
				.allMatch(d -> d.wasRolled());
	}
	
	
	public String toString() {
		return dice.stream()
 				   .map(d -> d.toString())
                   .collect(Collectors.joining(","));
	}

}
