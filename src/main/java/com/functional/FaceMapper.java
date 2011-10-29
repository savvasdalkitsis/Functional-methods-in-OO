package com.functional;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class FaceMapper implements Function<Character, Face> {

	private final Map<Character, Face> faceMap = ImmutableMap.<Character, Face>builder()
			.put('A', Face.ACE)
			.put('2', Face.TWO)
			.put('3', Face.THREE)
			.put('4', Face.FOUR)
			.put('5', Face.FIVE)
			.put('6', Face.SIX)
			.put('7', Face.SEVEN)
			.put('8', Face.EIGHT)
			.put('9', Face.NINE)
			.put('0', Face.TEN)
			.put('J', Face.JACK)
			.put('Q', Face.QUEEN)
			.put('K', Face.KING)
			.build();
	
	@Override
	public Face apply(Character input) {
		return faceMap.get(input);
	}

}
