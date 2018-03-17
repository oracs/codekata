package com.dy.kata.stringcompare.analyze.split;

import com.dy.kata.stringcompare.model.ResultType;
import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitorImplTest {
    @Test
    public void test_only_letters() throws Exception {
        assertSplitResult("abc", 1, asList(letter), asList("abc"));
    }

    @Test
    public void test_only_numeric() throws Exception {
        assertSplitResult("123", 1, asList(digit), asList("123"));
    }

    @Test
    public void test_contains_transformed_letter() throws Exception {
        assertSplitResult("#123#", 1, asList(letter), asList("123"));
        assertSplitResult("abc#123#456", 3, asList(letter, letter, digit), asList("abc","123","456"));
        assertSplitResult("#123#a#32#1", 4, asList(letter, letter, letter, digit), asList("123", "a", "32", "1"));
    }

    @Test
    public void test_contains_transformed_digit() throws Exception {
        assertSplitResultPro("@65@", 1, asList(digit), asList("65"), asList(1));
        assertSplitResultPro("@65@@65@", 2, asList(digit, digit), asList("65", "65"), asList(1, 1));
        assertSplitResultPro("@65@A@65@", 3, asList(digit, letter, digit), asList("65", "A", "65"), asList(1, 1, 1));
    }

    @Test
    public void test_complex_case() throws Exception {
        assertSplitResultPro("abc#12#cd#345#6eA@66@@65@1" , 9,
                asList(letter, letter, letter, letter, digit, letter, digit, digit, digit),
                asList("abc", "12", "cd", "345", "6", "eA", "66", "65", "1"),
                asList(3, 2, 2, 3, 1, 2, 1, 1, 1));
    }

    private void assertSplitResultPro(String input, int expectSize, List<ResultType> expectResultTypes, List<String> expectContents, List<Integer> expectLengths) {
        SplitResult splitResult = new SplitorImpl().split(input);

        List<ResultType> types = new ArrayList<>();
        List<String> contents = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();

        for (SplitUnit unit : splitResult.getSplitUnits()) {
            types.add(unit.type());
            contents.add(unit.content());
            lengths.add(unit.length());
        }

        assertThat(splitResult.size(), is(expectSize));
        assertThat(types, is(expectResultTypes));
        assertThat(contents, is(expectContents));
        assertThat(lengths, is(expectLengths));
    }

    private void assertSplitResult(String input, int expectSize, List<ResultType> resultTypes, List<String> contents) {
        SplitResult splitResult = new SplitorImpl().split(input);

        List<ResultType> expectedTypes = new ArrayList<>();
        List<String> expectedContents = new ArrayList<>();

        for (SplitUnit unit : splitResult.getSplitUnits()) {
            expectedTypes.add(unit.type());
            expectedContents.add(unit.content());
        }

        assertThat(splitResult.size(), is(expectSize));
        assertThat(expectedTypes, is(resultTypes));
        assertThat(expectedContents, is(contents));
    }
}