package com.functional;

public class Card {

	private final Face face;
	private final Suit suit;

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}
	
    @Override
    public boolean equals(Object obj) {
    	if (obj == null || !(obj instanceof Card))
    	{
    		return false;
    	}
    	if (this == obj)
    	{
    		return true;
    	}
    	Card card = (Card) obj;
    	return face == card.getFace() && suit == card.getSuit();
    }

}
