package com.dy.kata.worldclock.v2;

import com.dy.kata.worldclock.v2.clocks.BeijingClock;
import com.dy.kata.worldclock.v2.clocks.SydneyClock;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WorldClock2Test {
    private SydneyClock sydneyClock;
    private BeijingClock beijingClock;

    @Before
    public void setup(){
        sydneyClock = new SydneyClock();
        beijingClock = new BeijingClock();
    }

    @Test
    public void test_sync_clocks() throws Exception {
        ClockSourcer clockSourcer = new ClockSourcer();

        clockSourcer.addSyncClocks(sydneyClock, beijingClock);

        clockSourcer.setTime(15);

        clockSourcer.notifyAllClocks();

        assertThat(beijingClock.getSyncedTime(), is(15));
        assertThat(sydneyClock.getSyncedTime(), is(17));

    }
}
