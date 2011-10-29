package com.functional;

public class CharacterList
{
	public static FunctionalList<Character> getCharacterList(String characterList) {
		return characterList == null || characterList.equals("") 
				? FunctionalList.<Character>nil()
				: FunctionalList.cons(characterList.charAt(0), getCharacterList(characterList.substring(1)));
	}
	

}
