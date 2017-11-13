package com.dy.kata.worldclock.v1;

public abstract class Clock {

    protected int hour;

    public Clock(int hour) {
        this.hour = hour;
    }

    public abstract int toUTCTime();
}
