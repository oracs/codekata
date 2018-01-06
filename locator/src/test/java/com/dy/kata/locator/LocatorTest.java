package com.dy.kata.locator;

import com.dy.kata.locator.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dy.kata.locator.model.Matcher.eq;
import static com.dy.kata.locator.model.Matcher.gt;
import static com.dy.kata.locator.model.PersonPredicate.age;
import static com.dy.kata.locator.model.PersonPredicate.name;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocatorTest {
    private List<Student> students;

    @Before
    public void setUp() throws Exception {
        students = Arrays.asList(
                new Student("no1", 11),
                new Student("no2", 12),
                new Student("thomas", 13),
                new Student("no4", 12)
                );
    }

    @Test
    public void test_find_first_student_of_name_is_thomas() throws Exception {
        assertThat(Locator.findFirst(students, name(eq("thomas"))).getName(), is("thomas"));
    }

    @Test
    public void test_find_students_of_age_greater_than_11() throws Exception {
        assertThat(Locator.findAll(students, age(gt(11))).size(), is(3));
    }
}
