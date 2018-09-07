package com.mulderig.chargen;

public class MonotonicallyIncreasingValueSource implements ValueSource {
	private int currentValue;
	
	MonotonicallyIncreasingValueSource(int startValue) {
		this.currentValue = startValue;
	}

	@Override
	public int getValue(int range) {
		return currentValue++;
	}
	
	

}
