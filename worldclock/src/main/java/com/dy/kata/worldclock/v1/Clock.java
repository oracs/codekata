package com.dy.kata.worldclock.v1;

import com.dy.kata.worldclock.v1.impl.BeijingClock;

public abstract class Clock {
    protected int localTime;
    protected int syncedTime;

    public Clock(int localTime) {
        this.localTime = localTime;
    }

    public int toUTCTime() {
        return localTime - offset();
    }

    public void syncTime(BeijingClock beijingClock) {
        syncedTime = beijingClock.toUTCTime() + offset();
    }

    public int getSyncedTime() {
        return syncedTime;
    }

    protected abstract int offset();
}
