package com.dy.kata.worldclock.v2.clocks;

public class SydneyClock extends Clock {
    public SydneyClock() {
    }

    @Override
    protected int offset() {
        return 10;
    }
}
