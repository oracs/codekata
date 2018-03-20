package com.dy.kata.stringcompare.analyze.split;

import com.dy.kata.stringcompare.model.ResultType;
import com.dy.kata.stringcompare.model.SplitResult;
import org.junit.Test;

import java.util.List;

import static com.dy.kata.stringcompare.analyze.helper.TestHelper.assertSplitResult;
import static com.dy.kata.stringcompare.analyze.helper.TestHelper.assertSplitResultPro;
import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;
import static java.util.Arrays.asList;

public class SplitorImplTest {
    @Test
    public void test_only_letters() throws Exception {
        assertSplit("abc", 1, asList(letter), asList("abc"));
    }

    @Test
    public void test_only_numeric() throws Exception {
        assertSplit("123", 1, asList(digit), asList("123"));
    }

    @Test
    public void test_contains_transformed_letter() throws Exception {
        assertSplit("#123#", 1, asList(letter), asList("123"));
        assertSplit("abc#123#456", 3, asList(letter, letter, digit), asList("abc","123","456"));
        assertSplit("#123#a#32#1", 4, asList(letter, letter, letter, digit), asList("123", "a", "32", "1"));
    }

    @Test
    public void test_contains_transformed_digit() throws Exception {
        assertSplitPro("@65@", 1, asList(digit), asList("65"), asList(1));
        assertSplitPro("@65@@65@", 2, asList(digit, digit), asList("65", "65"), asList(1, 1));
        assertSplitPro("@65@A@65@", 3, asList(digit, letter, digit), asList("65", "A", "65"), asList(1, 1, 1));
    }

    @Test
    public void test_complex_case() throws Exception {
        assertSplitPro("abc#12#cd#345#6eA@66@@65@1" , 9,
                asList(letter, letter, letter, letter, digit, letter, digit, digit, digit),
                asList("abc", "12", "cd", "345", "6", "eA", "66", "65", "1"),
                asList(3, 2, 2, 3, 1, 2, 1, 1, 1));
    }

//    "123/A/888/B456"
    @Test
    public void test_complex_case2() throws Exception {
        assertSplitPro("123@65@#888#@66@456" , 5,
                asList(digit, digit, letter, digit, digit),
                asList("123", "65", "888", "66", "456"),
                asList(3, 1, 3, 1, 3));
    }

    //  "1295/888/B456"
    @Test
    public void test_complex_case3() throws Exception {
        assertSplitPro("1295#888#@66@456" , 4,
                asList(digit, letter, digit, digit),
                asList("1295", "888", "66", "456"),
                asList(4, 3, 1, 3));
    }

    public void assertSplit(String input, int expectSize, List<ResultType> resultTypes, List<String> contents) {
        SplitResult splitResult = new SplitorImpl().split(input);
        assertSplitResult(splitResult, expectSize, resultTypes, contents);
    }

    public void assertSplitPro(String input, int expectSize, List<ResultType> resultTypes, List<String> contents,  List<Integer> expectLengths) {
        SplitResult splitResult = new SplitorImpl().split(input);
        assertSplitResultPro(splitResult, expectSize, resultTypes, contents, expectLengths);
    }
}