package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class LondonClock extends Clock {
    public LondonClock(int hour) {
        super(hour);
    }

    @Override
    protected int offset() {
        return 0;
    }

}
