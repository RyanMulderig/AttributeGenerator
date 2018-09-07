package com.mulderig.chargen;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DieSetTest {
	@Test
	void testGetValue() {
		ValueSource  valueSource = new FixedValueSource(2);
		DieSet dice = new DieSet(3, 6, valueSource);
		dice.roll();
		assertTrue(dice.getValue() == 6);
	}

	@Test
	void testWasRolled() {
		ValueSource  valueSource = new RandomValueSource();
		DieSet dice = new DieSet(3, 6, valueSource);
		assertFalse(dice.wasRolled());
	}
	
	

}
