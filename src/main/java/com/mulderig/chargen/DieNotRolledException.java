package com.mulderig.chargen;

public class DieNotRolledException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Must roll die to be able to get value.";

	public DieNotRolledException() {
		super(MESSAGE);
	}
}
