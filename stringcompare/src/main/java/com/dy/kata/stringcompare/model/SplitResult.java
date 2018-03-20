package com.dy.kata.stringcompare.model;

import java.util.ArrayList;
import java.util.List;

public class SplitResult {
    private List<SplitUnit> SplitUnits = new ArrayList<>();

    public List<SplitUnit> getSplitUnits() {
        return SplitUnits;
    }

    public int size() {
        return SplitUnits.size();
    }

    public void add(SplitUnit splitUnit) {
        SplitUnits.add(splitUnit);
    }


}
