package com.mulderig.chargen;

import java.util.Random;

public class RandomValueSource implements ValueSource {
	private Random random = new Random();
	
	@Override
	public int getValue(int faces) {
		return random.nextInt(faces) + 1;
	}

}
