package com.dy.kata.worldclock.v1;

import com.dy.kata.worldclock.v1.impl.BeijingClock;

public abstract class Clock {
    protected int currentTime;
    protected int syncedTime;

    public Clock(int currentTime) {
        this.currentTime = currentTime;
    }

    public int toUTCTime() {
        return currentTime - jetlag();
    }

    public void syncTime(BeijingClock beijingClock) {
        syncedTime = beijingClock.toUTCTime() + jetlag();
    }

    public int getSyncedTime() {
        return syncedTime;
    }

    protected abstract int jetlag();
}
