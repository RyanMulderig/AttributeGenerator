package com.mulderig.chargen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DieSetDropsLowestTest {
	@Test
	void testRoll() {
		MonotonicallyIncreasingValueSource generator = new MonotonicallyIncreasingValueSource(1); 
		DieSetDropsLowest dice = new DieSetDropsLowest(3, 6, generator);
		dice.roll();
		assertTrue(dice.getValue() == 5);
	}
}
