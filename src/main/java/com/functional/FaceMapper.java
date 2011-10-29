package com.functional;

public class FaceMapper implements Function<Character, Face> {

	@Override
	public Face apply(Character input) {
		return Character.valueOf('J').equals(input)
				? Face.JACK
				: Face.NO_FACE;
	}

}
