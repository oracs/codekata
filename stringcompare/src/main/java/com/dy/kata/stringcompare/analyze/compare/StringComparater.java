package com.dy.kata.stringcompare.analyze.compare;

import com.dy.kata.stringcompare.model.SplitResult;

public class StringComparater {
    private SplitResult result1;
    private SplitResult result2;

    public StringComparater(SplitResult result1, SplitResult result2) {
        this.result1 = result1;
        this.result2 = result2;
    }

    public int compare(StrComparator comparator) {
        return comparator.compare(result1, result2);
    }
}
