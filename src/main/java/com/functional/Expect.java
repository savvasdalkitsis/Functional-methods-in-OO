package com.functional;

import com.pivotallabs.greatexpectations.matchers.*;

import static com.pivotallabs.greatexpectations.GreatExpectations.wrapped;

public class Expect {
    public static <T extends Object, M extends ObjectMatcher<T, M>> ObjectMatcher<T, ?> expect(T actual) {
        return wrapped(ObjectMatcher.class, actual);
    }
    public static BooleanMatcher<Boolean, ?> expect(boolean actual) {
        return wrapped(BooleanMatcher.class, actual);
    }
    public static <T extends Boolean, M extends BooleanMatcher<T, M>> BooleanMatcher<T, ?> expect(T actual) {
        return wrapped(BooleanMatcher.class, actual);
    }
    public static <T extends java.util.Date, M extends DateMatcher<T, M>> DateMatcher<T, ?> expect(T actual) {
        return wrapped(DateMatcher.class, actual);
    }
    public static <T extends Iterable<X>, X, M extends IterableMatcher<T, X, M>> IterableMatcher<T, X, ?> expect(T actual) {
        return wrapped(IterableMatcher.class, actual);
    }
    public static <T extends String, M extends StringMatcher<T, M>> StringMatcher<T, ?> expect(T actual) {
        return wrapped(StringMatcher.class, actual);
    }
}