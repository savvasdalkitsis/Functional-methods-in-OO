package com.functional;
import java.util.NoSuchElementException;

public abstract class FunctionalList<T> {
    public static <T> FunctionalList<T> nil() {
        return new Nil<T>();
    }

    public static <T> FunctionalList<T> cons(final T head, final FunctionalList<T> tail) {
        return new Cons<T>(head, tail);
    }

    public static <T> FunctionalList<T> of(final T... items) {
        return fromArray(items, 0, items.length);
    }

    private static <T> FunctionalList<T> fromArray(final T[] items, final int start, final int end) {
        return start == end
                   ? FunctionalList.<T>nil()
                   : cons(items[start], fromArray(items, start + 1, end));
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj == null || !(obj instanceof FunctionalList))
    	{
    		return false;
    	}
    	if (this == obj)
    	{
    		return true;
    	}
    	FunctionalList<?> list = (FunctionalList<?>) obj;
    	if (isEmpty() != list.isEmpty()) // Not the same size
    	{
    		return false;
    	}
    	if (isEmpty())
    	{
    		return true;
    	}
    	return head().equals(list.head()) && tail().equals(list.tail());
    }

    public abstract boolean isEmpty();

    public abstract T head();

    public abstract FunctionalList<T> tail();

    public <U> FunctionalList<U> map(final Function<T, U> mapping) {
        return isEmpty()
                   ? FunctionalList.<U>nil()
                   : cons(mapping.apply(head()), tail().map(mapping));
    }

	public FunctionalList<T> reduce(Function<T, Boolean> predicate) {
		return  isEmpty()
				? FunctionalList.<T>nil()
				:
					predicate.apply(head())
					? 
						FunctionalList.cons(head(),	tail().reduce(predicate))
					: 
						tail().reduce(predicate);
	}

    public static final class Nil<T> extends FunctionalList<T> {
        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public T head() {
            throw new NoSuchElementException();
        }

        @Override
        public FunctionalList<T> tail() {
            throw new NoSuchElementException();
        }
    }

    public static final class Cons<T> extends FunctionalList<T> {
        private final T head;
        private final FunctionalList<T> tail;

        public Cons(final T head, final FunctionalList<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public T head() {
            return head;
        }

        @Override
        public FunctionalList<T> tail() {
            return tail;
        }
    }
}
