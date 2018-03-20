package com.dy.kata.stringcompare.analyze;

import com.dy.kata.stringcompare.analyze.merge.Merger;
import com.dy.kata.stringcompare.analyze.split.Splitor;
import com.dy.kata.stringcompare.analyze.transform.Transformer;
import com.dy.kata.stringcompare.model.SplitResult;

public class StringAnalyzer {
    private String inputStr;

    public StringAnalyzer(String inputStr) {
        this.inputStr = inputStr;
    }

    public SplitResult analysis(Transformer transformer, Splitor splitor, Merger merger) {
        return merger.merge(splitor.split(transformer.convert(inputStr)));
    }

}
