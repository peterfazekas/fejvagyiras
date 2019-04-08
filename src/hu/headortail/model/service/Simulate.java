package hu.headortail.model.service;

import java.util.Random;

public class Simulate {

	private static final String[] SIDES = {"F", "I"} ;
	
	private final Random random;

	public Simulate(Random random) {
		this.random = random;
	}
	
	public String tossUp() {
		return SIDES[random.nextInt(2)];
	}
	
}
