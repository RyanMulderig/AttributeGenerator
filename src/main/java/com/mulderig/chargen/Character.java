package com.mulderig.chargen;

import static java.util.Comparator.comparingInt;

import java.util.LinkedList;
import java.util.List;

public class Character {
	List<Attribute> attributes = new LinkedList<>();
	
	Character() {
		for (int index = 0; index < 6; index++) {
			attributes.add(new Attribute());
		}
		attributes.sort(comparingInt(Attribute::getValue));
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Attribute a: attributes) {
			s.append(Integer.toString(a.getValue()));
			s.append(" ");
		}
		return s.toString();
	}
}
