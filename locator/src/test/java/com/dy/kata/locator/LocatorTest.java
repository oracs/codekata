package com.dy.kata.locator;

import com.dy.kata.locator.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocatorTest {
    private List<Student> students;

    @Before
    public void setUp() throws Exception {
        students = Arrays.asList(
                new Student("no1", 11),
                new Student("no2", 12),
                new Student("no3", 13),
                new Student("no4", 12)
                );
    }

    @Test
    public void test_find_first_student_of_age_equals_12() throws Exception {
        assertThat(Locator.findFirst(students, s -> s.getAge() == 12).getName(), is("no2"));
    }
}
