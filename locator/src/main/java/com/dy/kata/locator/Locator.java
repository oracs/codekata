package com.dy.kata.locator;

import com.dy.kata.locator.model.person.Person;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Locator {
    public  static Person findFirst(List<? extends Person> lists, Predicate<Person> predicate) {
        return lists.stream().filter(predicate).findFirst().get();
    }

    public static List<Person> findAll(List<? extends Person> lists, Predicate<Person> predicate) {
        return lists.stream().filter(predicate).collect(toList());
    }
}
