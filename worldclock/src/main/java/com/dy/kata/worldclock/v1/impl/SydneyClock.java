package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class SydneyClock extends Clock{
    public SydneyClock(int hour) {
        super(hour);
    }

    @Override
    public int toUTCTime() {
        return hour - 10;
    }
}
