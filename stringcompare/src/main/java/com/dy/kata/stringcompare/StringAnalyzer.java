package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.SplitResult;
import com.dy.kata.stringcompare.analyze.split.Splitor;
import com.dy.kata.stringcompare.analyze.transform.Transformer;

public class StringAnalyzer {
    private String outputStr;

    public StringAnalyzer(String inputStr) {
        this.outputStr = inputStr;
    }

    public StringAnalyzer transform(Transformer transformer) {
        outputStr += transformer.convert(outputStr);
        return this;
    }

    public SplitResult split(Splitor splitor) {
        return splitor.split(outputStr);
    }


}
