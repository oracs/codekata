package com.dy.kata.stringcompare.analyze.compare;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;
import org.junit.Test;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FastStrComparatorTest {
    @Test
    public void test_case1() throws Exception {
        SplitResult r1 = new SplitResult() ;
        r1.add(new SplitUnit(letter, "b", 1));
        r1.add(new SplitUnit(digit, "2", 1));


        SplitResult r2 = new SplitResult() ;
        r1.add(new SplitUnit(letter, "c", 1));
        r1.add(new SplitUnit(digit, "2", 1));

        FastStrComparator comparator = new FastStrComparator();
        assertThat(comparator.compare(r1, r2), is(-1));
    }
}