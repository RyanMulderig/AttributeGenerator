package com.mulderig.chargen;

public class FixedValueSource implements ValueSource {
	private final int fixedValue;

	public FixedValueSource(int fixedValue) {
		this.fixedValue = fixedValue;
	}
	
	
	@Override
	public int getValue(int max) {
		return fixedValue;
	}


}
