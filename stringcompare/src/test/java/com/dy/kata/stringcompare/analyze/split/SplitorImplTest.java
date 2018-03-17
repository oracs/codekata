package com.dy.kata.stringcompare.analyze.split;

import com.dy.kata.stringcompare.model.ResultType;
import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void test_only_tranformed_letters() throws Exception {
        assertSplitResult("#123#", 1, asList(letter), asList("123"));
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