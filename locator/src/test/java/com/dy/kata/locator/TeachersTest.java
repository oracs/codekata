package com.dy.kata.locator;

import com.dy.kata.locator.model.person.Teacher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dy.kata.locator.model.predicate.Matcher.eq;
import static com.dy.kata.locator.model.predicate.PersonPredicate.sex;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TeachersTest {
    private List<Teacher> teachers;

    @Before
    public void setUp() throws Exception {
        teachers = Arrays.asList(
                new Teacher("no1", 21, "F"),
                new Teacher("no2", 22, "M"),
                new Teacher("no2", 23, "F"),
                new Teacher("no4", 22, "M")
        );
    }

    @Test
    public void test_find_first_teacher_of_sex_is_female() throws Exception {
        assertThat(Locator.findFirst(teachers, sex(eq("F"))).getName(), is("no1"));
    }
}
