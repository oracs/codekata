package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class MoscowClock extends Clock{
    public MoscowClock(int hour) {
        super(hour);
    }

    @Override
    protected int offset() {
        return 4;
    }


}
