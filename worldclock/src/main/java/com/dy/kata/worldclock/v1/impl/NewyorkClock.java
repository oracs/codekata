package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class NewyorkClock extends Clock {
    public NewyorkClock(int hour) {
        super(hour);
    }

    @Override
    public int toUTCTime() {
        return hour + 5;
    }

}
