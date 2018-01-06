package com.dy.kata.locator.model.predicate;

import com.dy.kata.locator.model.person.Person;

import java.util.function.Predicate;

public class PersonPredicate {
    public static Predicate<Person> age(Matcher m) {
        return s -> m.match(s.getAge());
    }

    public static Predicate<Person> name(Matcher m) {
        return s -> m.match(s.getName());
    }
    public static Predicate<Person> sex(Matcher m) {
        return s -> m.match(s.getSex());
    }
}
