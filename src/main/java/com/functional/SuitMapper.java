package com.functional;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class SuitMapper implements Function<Character, Suit> {

	private final Map<Character, Suit> mapOfSuits = ImmutableMap.of(
			'c', Suit.CLUBS,
			'd', Suit.DIAMONDS,
			'h', Suit.HEARTS,
			's', Suit.SPADES 
			);

	@Override
	public Suit apply(Character input) {
		return mapOfSuits.get(input);
	}

}
