package com.dy.kata.locator;

import com.dy.kata.locator.model.Student;

import java.util.List;
import java.util.function.Predicate;

public class Locator {

    public static Student findFirst(List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter(predicate).findFirst().get();
    }
}
