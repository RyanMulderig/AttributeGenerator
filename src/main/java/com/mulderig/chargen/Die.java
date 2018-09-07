package com.mulderig.chargen;

public class Die {
	private static int UNROLLED = Integer.MIN_VALUE;
	private final ValueSource valueSource;
	private final int faces;
	private int value = UNROLLED;
	
	
	Die(int faces, ValueSource valueSource) {
		this.faces = faces;
		this.valueSource = valueSource;
	}
	
	public int getFaces() {
		return faces;
	}
	
	public int getValue() {
		if (wasRolled()) {
			return value;
		}
		throw new DieNotRolledException();
	}
	
	public void roll() {
		value = valueSource.getValue(faces);
	}
	
	public boolean wasRolled() {
		return value != UNROLLED;
	}
	
	public void forceValue(int value) {
		this.value = value; 
	}
	
	public String toString() {
		return "Type: d" + Integer.toString(faces) + " Value: " +Integer.toString(value);
	}

	public Object hasBeenRolled() {
		// TODO Auto-generated method stub
		return null;
	}
}
