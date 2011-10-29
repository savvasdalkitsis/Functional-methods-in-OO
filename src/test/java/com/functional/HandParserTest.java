package com.functional;

import org.junit.Before;
import org.junit.Test;
import static com.functional.Expect.*;

public class HandParserTest
{
	
	private static final FunctionalList<Card> EMPTY_CARD_LIST = FunctionalList.<Card>nil();
	private static final FunctionalList<Card> CARDS_LIST_WITH_ONLY_JACK_OF_CLUBS = 
			FunctionalList.of(new Card(Face.JACK, Suit.CLUBS));
	private static final FunctionalList<Card> CARDS_LIST_WITH_JC_AND_5D = 
			FunctionalList.of(
					new Card(Face.JACK, Suit.CLUBS),
					new Card(Face.FIVE, Suit.DIAMONDS));
	private static final String HAND_WITH_ONLY_JACK_OF_CLUBS = "Jc";
	private static final String HAND_WITH_JC_AND_5D = "Jc 5d";
	private static final String EMPTY_HAND = "";
	private static final String NO_HAND = null;
	private HandParser parser;

	@Before
	public void setUp()
	{
		parser = new HandParser();
	}

	@Test
	public void willReturnEmptyListForEmptyHand()
	{
		expect(cardsListParsedFrom(EMPTY_HAND)).toEqual(EMPTY_CARD_LIST);
	}

	@Test
	public void willReturnListWithOneCardForHandWithOneCard()
	{
		expect(cardsListParsedFrom(HAND_WITH_ONLY_JACK_OF_CLUBS)).toEqual(CARDS_LIST_WITH_ONLY_JACK_OF_CLUBS);
	}

	@Test
	public void willReturnEmptyListForNoHand()
	{
		expect(cardsListParsedFrom(NO_HAND)).toEqual(EMPTY_CARD_LIST);
	}

	@Test
	public void willReturnAListWithTwoCardsForHandWithTwoCards()
	{
		expect(cardsListParsedFrom(HAND_WITH_JC_AND_5D)).toEqual(CARDS_LIST_WITH_JC_AND_5D);
	}

	private FunctionalList<Card> cardsListParsedFrom(String description)
	{
		FunctionalList<Card> cards = parser.parse(description);
		return cards;
	}

}
