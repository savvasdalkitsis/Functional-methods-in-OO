package com.functional;
import org.junit.Before;
import org.junit.Test;

import static com.functional.Expect.*;

public class CardParserTest
{
	
	private static final String EMPTY_DESCRIPTION = "";
	private static final String ACE_OF_SPADES = "As";
	private static final String TWO_OF_SPADES = "2s";
	private static final String THREE_OF_SPADES = "3s";
	private static final String FOUR_OF_SPADES = "4s";
	private static final String SIX_OF_SPADES = "6s";
	private static final String SEVEN_OF_SPADES = "7s";
	private static final String EIGHT_OF_SPADES = "8s";
	private static final String NINE_OF_SPADES = "9s";
	private static final String TEN_OF_SPADES = "0s";
	private static final String QUEEN_OF_SPADES = "Qs";
	private static final String KING_OF_SPADES = "Ks";
	private static final String TWO_OF_HEARTS = "2h";
	private static final String JACK_WITH_NO_SUIT = "J";
	private static final String JACK_OF_DIAMONDS = "Jd";
	private static final String FIVE_OF_CLUBS = "5c";
	private static final String NO_DESCRIPTION = null;
	private CardParser parser;

	@Before
	public void setUp()
	{
		parser = new CardParser();
	}

	@Test
	public void willReturnNoCardWhenDescriptionIsEmpty()
	{
		expect(cardParsedFrom(EMPTY_DESCRIPTION)).toBeNull();
	}

	@Test
	public void willReturnCardWithFaceOfJackWhenDescriptionIsJack()
	{
		expect(parsedFaceFrom(JACK_OF_DIAMONDS)).toBe(Face.JACK);
	}
	
	@Test
	public void willReturnNoCardWhenThereIsNoDescription()
	{
		expect(cardParsedFrom(NO_DESCRIPTION)).toBeNull();
	}
	
	@Test
	public void willReturnCardWithFaceDifferentThanJackWhenDescriptionIsntJack()
	{
		expect(parsedFaceFrom(FIVE_OF_CLUBS)).not.toBe(Face.JACK);
	}

	@Test
	public void willReturnNoCardWhenDescriptionHasNoSuit()
	{
		expect(cardParsedFrom(JACK_WITH_NO_SUIT)).toBeNull();
	}
	
	@Test
	public void willReturnSuitOfClubsWhenDescriptionHasClubs()
	{
		expect(parsedSuitOf(FIVE_OF_CLUBS)).toBe(Suit.CLUBS);
	}
	
	@Test
	public void willReturnSuitOfDiamondsWhenDescriptionHasDiamonds()
	{
		expect(parsedSuitOf(JACK_OF_DIAMONDS)).toBe(Suit.DIAMONDS);
	}
	
	@Test
	public void willReturnSuitOfHeartsWhenDescriptionHasHearts()
	{
		expect(parsedSuitOf(TWO_OF_HEARTS)).toBe(Suit.HEARTS);
	}
	
	@Test
	public void willReturnSuitOfSpadesWhenDescriptionHasSpades()
	{
		expect(parsedSuitOf(ACE_OF_SPADES)).toBe(Suit.SPADES);
	}
	
	@Test
	public void willRecognizeAllThePossibleFacesOfCards()
	{
		expect(parsedFaceFrom(ACE_OF_SPADES)).toBe(Face.ACE);
		expect(parsedFaceFrom(TWO_OF_SPADES)).toBe(Face.TWO);
		expect(parsedFaceFrom(THREE_OF_SPADES)).toBe(Face.THREE);
		expect(parsedFaceFrom(FOUR_OF_SPADES)).toBe(Face.FOUR);
		expect(parsedFaceFrom(FIVE_OF_CLUBS)).toBe(Face.FIVE);
		expect(parsedFaceFrom(SIX_OF_SPADES)).toBe(Face.SIX);
		expect(parsedFaceFrom(SEVEN_OF_SPADES)).toBe(Face.SEVEN);
		expect(parsedFaceFrom(EIGHT_OF_SPADES)).toBe(Face.EIGHT);
		expect(parsedFaceFrom(NINE_OF_SPADES)).toBe(Face.NINE);
		expect(parsedFaceFrom(TEN_OF_SPADES)).toBe(Face.TEN);
		expect(parsedFaceFrom(JACK_OF_DIAMONDS)).toBe(Face.JACK);
		expect(parsedFaceFrom(QUEEN_OF_SPADES)).toBe(Face.QUEEN);
		expect(parsedFaceFrom(KING_OF_SPADES)).toBe(Face.KING);
	}
	
	private Suit parsedSuitOf(String description)
	{
		Card card = cardParsedFrom(description);
		return card.getSuit();
	}
	
	private Face parsedFaceFrom(String description) {
		Card card = cardParsedFrom(description);
		return card.getFace();
	}
	
	private Card cardParsedFrom(String stringDescription) {
		return parser.parse(CharacterList.getCharacterList(stringDescription));
	}
	
}
