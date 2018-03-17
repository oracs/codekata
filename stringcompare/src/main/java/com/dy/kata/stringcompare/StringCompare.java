package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.StringAnalyzer;
import com.dy.kata.stringcompare.analyze.split.SplitorImpl;
import com.dy.kata.stringcompare.analyze.transform.TransformerImpl;
import com.dy.kata.stringcompare.model.SplitResult;

public class StringCompare {

    public int compare(String str1, String str2) {
        SplitResult splitedStr1 = new StringAnalyzer(str1)
                                        .transform(new TransformerImpl())
                                        .split(new SplitorImpl());


        return -1;
    }

}
