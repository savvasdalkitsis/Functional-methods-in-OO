package com.functional;

public class CharacterList
{
	public static FunctionalList<Character> getCharacterList(String characterList)
	{
		return characterList == null || characterList.trim().equals("") 
				? FunctionalList.<Character>nil()
				: FunctionalList.cons(characterList.charAt(0), getCharacterList(characterList.substring(1)));
	}
	
	public static FunctionalList<String> getStringListSplitBySpaces(String description)
	{
		return (description == null || "".trim().equals(description))
				? FunctionalList.<String>nil()
				: FunctionalList.of(description.split(" +"));
	}

	

}
