package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class MoscowClock extends Clock{
    public MoscowClock(int hour) {
        super(hour);
    }

    @Override
    public int toUTCTime() {
        return hour - 4;
    }
}
