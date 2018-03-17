package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.SplitResult;
import com.dy.kata.stringcompare.analyze.convertor.Convertor;

public class Analyzer {
    private String outputStr;

    public Analyzer(String inputStr) {
        this.outputStr = inputStr;
    }

    public Analyzer transform(Convertor convertor) {
        outputStr += convertor.convert(outputStr);
        return this;
    }

//    public Analyzer split() {
//        return null;
//    }

    public SplitResult result() {
        return null;
    }
}
