package com.dy.kata.worldclock.v2.clocks;

public class BaseClock {
    private int localTime;

    public BaseClock(int localTime) {
        this.localTime = localTime;
    }

    public int getSyncedTime() {
        return 0;
    }
}
