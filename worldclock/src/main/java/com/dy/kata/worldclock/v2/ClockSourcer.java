package com.dy.kata.worldclock.v2;

import com.dy.kata.worldclock.v2.clocks.Clock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClockSourcer {
    private int adjustTime;
    private List<Clock> syncClocks = new ArrayList<>();

    public void addSyncClocks(Clock... clock) {
        syncClocks.addAll(Arrays.asList(clock));
    }

    public void notifyAllClocks() {
        for (Clock clock : syncClocks) {
            clock.syncTime(this.adjustTime);
        }
    }

    public void setTime(int time) {
        this.adjustTime = time;
    }
}
