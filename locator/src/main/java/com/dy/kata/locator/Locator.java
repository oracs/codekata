package com.dy.kata.locator;

import com.dy.kata.locator.model.Student;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Locator {

    public static Student findFirst(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).findFirst().get();
    }

    public static List<Student> findAll(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).collect(toList());
    }
}
