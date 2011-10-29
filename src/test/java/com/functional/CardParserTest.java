package com.functional;
import org.junit.Before;
import org.junit.Test;

import static com.functional.Expect.*;

public class CardParserTest
{
	
	private static final String EMPTY_DESCRIPTION = "";
	private static final String ACE_OF_SPADES = "As";
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
