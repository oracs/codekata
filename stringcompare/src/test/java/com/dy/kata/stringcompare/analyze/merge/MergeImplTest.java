package com.dy.kata.stringcompare.analyze.merge;

import com.dy.kata.stringcompare.analyze.helper.TestHelper;
import com.dy.kata.stringcompare.model.ResultType;
import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;
import org.junit.Test;

import java.util.List;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;
import static java.util.Arrays.asList;

public class MergeImplTest {
    @Test
    public void test_letter_merge() throws Exception {
        SplitResult original = new SplitResult() ;

        original.add(new SplitUnit(letter, "abc", 3));
        original.add(new SplitUnit(letter, "123", 3));
        original.add(new SplitUnit(digit, "456", 3));

        assertMergeResult(original, 2, asList(letter, digit), asList("abc123", "456"));
    }

    @Test
    public void test_letter_differ() throws Exception {
        SplitResult original = new SplitResult() ;

        original.add(new SplitUnit(digit, "234", 3));
        original.add(new SplitUnit(letter, "abc", 3));
        original.add(new SplitUnit(digit, "456", 3));

        assertMergeResult(original, 3, asList(digit, letter, digit), asList("234", "abc", "456"));
    }

    @Test
    public void test_digit_merge() throws Exception {
        SplitResult original = new SplitResult() ;

        original.add(new SplitUnit(digit, "123", 3));
        original.add(new SplitUnit(digit, "65", 1));
        original.add(new SplitUnit(digit, "456", 3));
        original.add(new SplitUnit(letter, "XYZ", 3));

        assertMergeResultPro(original, 2,
                asList(digit, letter),
                asList("12365456", "XYZ"),
                asList(7, 3));
    }



    public void assertMergeResult(SplitResult original, int expectSize, List<ResultType> resultTypes, List<String> contents) {
        SplitResult mergedResult = new MergeImpl().merge(original);
        TestHelper.assertSplitResult(mergedResult, expectSize, resultTypes, contents);
    }

    public void assertMergeResultPro(SplitResult original, int expectSize, List<ResultType> resultTypes, List<String> contents, List<Integer> expectLengths) {
        SplitResult mergedResult = new MergeImpl().merge(original);
        TestHelper.assertSplitResultPro(mergedResult, expectSize, resultTypes, contents, expectLengths);
    }
}