package com.mulderig.chargen;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class RerollableValueSourceTest {
	@Test
	public void testRoll() {
		MonotonicallyIncreasingValueSource underlyingSource = new MonotonicallyIncreasingValueSource(1);
		RerollableValueSource source = new RerollableValueSource(underlyingSource);
		source.setDieMinimum(5);
		source.setRollsAllowed(8);
		int val = source.getValue(6);
		assertTrue(val == 5);
	}
}
