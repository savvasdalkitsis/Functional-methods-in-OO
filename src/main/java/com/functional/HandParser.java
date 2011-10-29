package com.functional;

public class HandParser {

	public FunctionalList<Card> parse(String string) {
		final FunctionalList<String> handList = CharacterList.getStringListSplitBySpaces(string);
		return handle(handList);
	}
	
	private FunctionalList<Card> handle(FunctionalList<String> handList)
	{
		final CardParser parser = new CardParser();
		return handList.isEmpty()
				? FunctionalList.<Card>nil()
				: FunctionalList.cons(parser.parse(CharacterList.getCharacterList(handList.head())),
						handle(handList.tail()));
	}

}
