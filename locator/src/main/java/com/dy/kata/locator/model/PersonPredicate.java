package com.dy.kata.locator.model;

import java.util.function.Predicate;

public class PersonPredicate <T extends Student>{
    public <T> static Predicate<T> age(Matcher m) {
        return s -> m.match(s.getAge());
    }

    public static Predicate<Student> name(Matcher m) {
        return s -> m.match(s.getName());
    }
}
