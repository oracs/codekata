package com.dy.kata.stringcompare.analyze.compare;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;

public class FastStrComparator implements StrComparator {
    @Override
    public int compare(SplitResult r1, SplitResult r2) {
        int result;

        int count = calcCount(r1, r2);
        for (int i = 0; i < count; i++) {
            result = compareUnit(r1.getSplitUnits().get(i), r2.getSplitUnits().get(i));
            if (result != 0) {
                return result;
            }
        }

        int x = r1.size() - r2.size();
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }

        return 0;
    }

    private int compareUnit(SplitUnit u1, SplitUnit u2) {
        if (u1.type() != u2.type()) {
            if (u1.type() == digit) {
                return -1;
            }

            if (u2.type() == digit) {
                return 1;
            }
        } else {
            if (u1.type() == digit) {
                return digitCompare(u1, u2);
            }

            if (u1.type() == letter) {
                return letterCompare(u1, u2);
            }
        }

        return -3;
    }

    private int letterCompare(SplitUnit u1, SplitUnit u2) {
        return u1.content().compareTo(u2.content());
    }

    private int digitCompare(SplitUnit u1, SplitUnit u2) {
        int n1 = Integer.parseInt(u1.content());
        int n2 = Integer.parseInt(u2.content());

        if (n1 > n2) {
            return 1;
        } else if ( n1 < n2) {
            return -1;
        } else {
            int c1 = u1.length();
            int c2 = u2.length();
            if (c1 > c2) {
                return 1;
            } else if (c1 < c2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private int calcCount(SplitResult r1, SplitResult r2) {
        int x = r1.size() - r2.size();
        if (x > 0) {
            return r2.size();
        } else if (x < 0 ){
            return r1.size();
        } else {
            return r1.size();
        }
    }
}
