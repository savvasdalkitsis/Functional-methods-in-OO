package com.functional;

import org.junit.Test;
import static com.functional.Expect.*;

public class ListReduceTest
{
	
	private static final String GOODBYE_WORLD = "Goodbye world";
	private static final String HELLO_WORLD = "Hello World";
	private static final FunctionalList<String> HELLO_AND_GOODBYE_WORLD_LIST = 
												FunctionalList.of(HELLO_WORLD, GOODBYE_WORLD);
	private static final FunctionalList<String> HELLO_WORLD_LIST = FunctionalList.of(HELLO_WORLD);
	private static final FunctionalList<Object> EMPTY_OBJECT_LIST = FunctionalList.<Object>nil();
	private static final FunctionalList<String> EMPTY_STRING_LIST = FunctionalList.<String>nil();
	
	@Test
	public void willReturnEmptyListForEmptyList()
	{
		expect(reducedListFrom(EMPTY_OBJECT_LIST, whereItemsEqual(null))).toEqual(EMPTY_OBJECT_LIST);
	}
	
	@Test
	public void willReturnListWithOneItemForListWithOneItemIfPredicateSucceeds()
	{
		expect(reducedListFrom(HELLO_WORLD_LIST, whereItemsEqual(HELLO_WORLD))).toEqual(HELLO_WORLD_LIST);
	}
	
	@Test
	public void willReturnListWithNoItemsForListWithOneItemIfPredicateFails()
	{
		expect(reducedListFrom(HELLO_WORLD_LIST, whereItemsEqual(GOODBYE_WORLD))).toEqual(EMPTY_STRING_LIST);
	}
	
	@Test
	public void willReturnListWithOneItemsForListWithTwoItemsWhenPredicateSucceedsOnlyForOne()
	{
		expect(reducedListFrom(HELLO_AND_GOODBYE_WORLD_LIST, whereItemsEqual(HELLO_WORLD))).toEqual(HELLO_WORLD_LIST);
	}

	private <T> FunctionalList<T> reducedListFrom(
			FunctionalList<T> fromList,
			Function<T, Boolean> helloWorldPredicate) {
		return fromList.reduce(helloWorldPredicate);
	}

	private <T> Function<T, Boolean> whereItemsEqual(final T objectToCheckAgainst) {
		return new Function<T, Boolean>() {
			
			@Override
			public Boolean apply(T input) {
				return objectToCheckAgainst.equals(input);
			}
		};
	}

}
