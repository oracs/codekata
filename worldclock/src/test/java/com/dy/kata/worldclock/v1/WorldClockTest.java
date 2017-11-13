package com.dy.kata.worldclock.v1;


import com.dy.kata.worldclock.v1.impl.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WorldClockTest {
    @Test
    public void test_London_time_to_UTC_time() throws Exception {
        assertThat(new LondonClock(14).toUTCTime(), is(14));   // 时间简单表示成xx，重点关注核心业务
    }

    @Test
    public void test_Beijing_time_to_UTC_time() throws Exception {
        assertThat(new BeijingClock(14).toUTCTime(), is(6));
    }

    @Test
    public void test_Moscow_time_to_UTC_time() throws Exception {
        assertThat(new MoscowClock(14).toUTCTime(), is(10));
    }

    @Test
    public void test_Sydney_time_to_UTC_time() throws Exception {
        assertThat(new SydneyClock(14).toUTCTime(), is(4));
    }

    @Test
    public void test_Newyork_time_to_UTC_time() throws Exception {
        assertThat(new NewyorkClock(14).toUTCTime(), is(19));
    }
}
