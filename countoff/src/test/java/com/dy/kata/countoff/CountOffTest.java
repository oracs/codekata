package com.dy.kata.countoff;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountOffTest {
    private Kids kids;

    @Before
    public void setup() throws Exception {
        kids = new Kids();
    }

    @Test
    public void test_countoff_special_number_of_3() throws Exception {
        assertThat(kids.countOff(3), is("ʯͷ"));
    }
}
