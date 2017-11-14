package com.dy.kata.worldclock.v1.impl;

import com.dy.kata.worldclock.v1.Clock;

public class BeijingClock extends Clock {

    public BeijingClock(int hour) {
        super(hour);
    }


    @Override
    protected int jetlag() {
        return 8;
    }

}
