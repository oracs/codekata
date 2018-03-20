package com.dy.kata.stringcompare.analyze;

import com.dy.kata.stringcompare.analyze.merge.Merger;
import com.dy.kata.stringcompare.analyze.split.Splitor;
import com.dy.kata.stringcompare.analyze.transform.Transformer;
import com.dy.kata.stringcompare.model.SplitResult;

public class StringAnalyzer {
    private String outputStr;
    private SplitResult splitResult;

    public StringAnalyzer(String inputStr) {
        this.outputStr = inputStr;
    }

    public StringAnalyzer transform(Transformer transformer) {
        outputStr = transformer.convert(outputStr);
        return this;
    }

    public StringAnalyzer split(Splitor splitor) {
        splitResult = splitor.split(outputStr);
        return this;
    }

    public SplitResult merge(Merger merger) {
        return merger.merge(splitResult);
    }
}
