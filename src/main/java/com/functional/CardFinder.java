package com.functional;

public class CardFinder {

	public Card find(Face faceOfCardToLookFor, String handString) {
		final FunctionalList<Card> reducedList = 
				new HandParser().parse(handString).reduce(hasSameFaceAs(faceOfCardToLookFor));
		return reducedList.isEmpty()
					? null
					: reducedList.head();
	}

	private Function<Card, Boolean> hasSameFaceAs(final Face faceOfCardToLookFor) {
		return new Function<Card, Boolean>() {
			
			@Override
			public Boolean apply(Card input) {
				return input.getFace() == faceOfCardToLookFor;
			}
		};
	}

}
