package com.dy.kata.worldclock.v2;

import com.dy.kata.worldclock.v2.clocks.BaseClock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClockSourcer {
    private int adjustTime;
    private List<BaseClock> syncClocks = new ArrayList<>();

    public void addSyncClocks(BaseClock... baseClock) {
        syncClocks.addAll(Arrays.asList(baseClock));
    }

    public void notifyAllClocks() {
        
    }

    public void setTime(int time) {
        this.adjustTime = time;
    }
}
