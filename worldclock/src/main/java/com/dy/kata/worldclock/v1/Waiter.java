package com.dy.kata.worldclock.v1;

import com.dy.kata.worldclock.v1.impl.BeijingClock;

public class Waiter {
    public void syncTime(WallClocks wallclocks, BeijingClock adjTime) {
        for (Clock clock: wallclocks.clocks) {
            clock.syncTime(adjTime);
        }
    }
}
