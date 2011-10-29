package com.functional;

public class Main
{

	public static void main(String[] args)
	{
		final String hand = "2c 5d 5c Jc Kd";
		final Card cardFound = new CardFinder().find(Face.JACK, hand);
		System.out.println(
			(cardFound == null 
				? "No card found with face Jack" 
				: "Suit of card with face of Jack is " + cardFound.getSuit())
			+ " in hand " + hand);
	}
	
}
