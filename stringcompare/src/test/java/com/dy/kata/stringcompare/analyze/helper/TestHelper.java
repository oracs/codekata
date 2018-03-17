package com.dy.kata.stringcompare.analyze.helper;

import com.dy.kata.stringcompare.model.ResultType;
import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestHelper {
    public static void assertSplitResultPro(SplitResult splitResult, int expectSize, List<ResultType> expectResultTypes, List<String> expectContents, List<Integer> expectLengths) {
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

    public static void assertSplitResult(SplitResult splitResult, int expectSize, List<ResultType> resultTypes, List<String> contents) {
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
