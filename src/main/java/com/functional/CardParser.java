package com.functional;

public class CardParser {

	public Card parse(FunctionalList<Character> description) {
		return (description == null || description.isEmpty() || description.tail().isEmpty()) 
				? null 
				: new Card(description.map(new FaceMapper()).head(),
						   description.map(new SuitMapper()).tail().head());
	} 

}
