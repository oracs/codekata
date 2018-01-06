package com.dy.kata.locator.model.predicate;

public interface Matcher<T> {
    boolean match(T t);

    static <T> Matcher<T> eq(T expected) {
        return acture -> acture.equals(expected);
    }

    static Matcher<Integer> gt(Integer expected) {
        return acture -> (acture > expected) ;
    }
}
