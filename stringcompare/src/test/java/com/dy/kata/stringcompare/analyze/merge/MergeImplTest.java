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
    public void test_differ_merge() throws Exception {
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
                asList("13406", "XYZ"),
                asList(7, 3));
    }

    @Test
    public void test_compex_merge() throws Exception {
        SplitResult original = new SplitResult() ;

        original.add(new SplitUnit(letter, "abc", 3));
        original.add(new SplitUnit(letter, "12", 2));
        original.add(new SplitUnit(letter, "cd", 2));
        original.add(new SplitUnit(letter, "345", 3));
        original.add(new SplitUnit(digit, "6", 1));
        original.add(new SplitUnit(letter, "eA", 2));
        original.add(new SplitUnit(digit, "66", 1));
        original.add(new SplitUnit(digit, "65", 1));
        original.add(new SplitUnit(digit, "1", 1));

        assertMergeResultPro(original, 4,
                asList(letter, digit, letter, digit),
                asList("abc12cd345", "6", "eA", "7251"),
                asList(10, 1, 2, 3));
    }

    @Test
    public void test_complex_merge_case1() throws Exception {
        SplitResult original = new SplitResult() ;

        original.add(new SplitUnit(digit, "123", 3));
        original.add(new SplitUnit(digit, "65", 1));
        original.add(new SplitUnit(letter, "888", 3));

        assertMergeResultPro(original, 2,
                asList(digit, letter),
                asList("1295", "888"),
                asList(4, 3));
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