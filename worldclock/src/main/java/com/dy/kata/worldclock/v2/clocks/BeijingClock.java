package com.dy.kata.worldclock.v2.clocks;

public class BeijingClock extends Clock {
    public BeijingClock() {
    }

    @Override
    protected int offset() {
        return 8;
    }
}
