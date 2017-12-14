package com.dy.kata.worldclock.v1;


import com.dy.kata.worldclock.v1.impl.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WorldClockTest {
    private LondonClock londonClock;
    private BeijingClock beijingClock;
    private MoscowClock moscowClock;
    private SydneyClock sydneyClock;
    private NewyorkClock newyorkClock;

    @Before
    public void setup(){
        londonClock = new LondonClock(14);
        beijingClock = new BeijingClock(14);
        moscowClock = new MoscowClock(14);
        sydneyClock = new SydneyClock(14);
        newyorkClock = new NewyorkClock(14);
    }

    @Test
    public void test_London_time_to_UTC_time() throws Exception {
        assertThat(londonClock.toUTCTime(), is(14));
    }

    @Test
    public void test_Beijing_time_to_UTC_time() throws Exception {
        assertThat(beijingClock.toUTCTime(), is(6));
    }

    @Test
    public void test_Moscow_time_to_UTC_time() throws Exception {
        assertThat(moscowClock.toUTCTime(), is(10));
    }

    @Test
    public void test_Sydney_time_to_UTC_time() throws Exception {
        assertThat(sydneyClock.toUTCTime(), is(4));
    }

    @Test
    public void test_Newyork_time_to_UTC_time() throws Exception {
        assertThat(newyorkClock.toUTCTime(), is(19));
    }

    @Test
    public void test_sync_time() {
        WallClocks wallclocks = new WallClocks(londonClock,
                beijingClock,
                moscowClock,
                sydneyClock,
                newyorkClock);

        new Waiter().syncTime(wallclocks, new BeijingClock(15));

        assertThat(beijingClock.getSyncedTime(), is(15));
        assertThat(londonClock.getSyncedTime(), is(7));
        assertThat(moscowClock.getSyncedTime(), is(11));
        assertThat(sydneyClock.getSyncedTime(), is(17));
        assertThat(newyorkClock.getSyncedTime(), is(2));

    }
}