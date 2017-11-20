package com.dy.kata.worldclock.v1;

import java.util.ArrayList;
import java.util.List;

public class WallClocks {
    List<Clock> clocks = new ArrayList<Clock>();

    public WallClocks(Clock... clocks) {
        for (Clock clock: clocks) {
            this.clocks.add(clock);
        }
    }

    public List<Clock> clocks() {
        return clocks;
    }
}
