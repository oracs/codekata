package com.dy.kata.worldclock.v2.clocks;

public abstract class Clock {
    private int syncedTime;

    public Clock() {

    }

    public int getSyncedTime() {
        return syncedTime;
    }

    public void syncTime(int sourceTime) {
        // 目前默认先支持酒店在北京，按北京时间对时。
        syncedTime = sourceTime - 8 + offset();
    }

    protected abstract int offset();
}
