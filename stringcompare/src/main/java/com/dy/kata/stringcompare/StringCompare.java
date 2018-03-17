package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.SplitResult;
import com.dy.kata.stringcompare.analyze.split.SplitorImpl;
import com.dy.kata.stringcompare.analyze.transform.TransformerImpl;

public class StringCompare {

    public int compare(String str1, String str2) {
        SplitResult splitedStr1 = new StringAnalyzer(str1)
                                        .transform(new TransformerImpl())
                                        .split(new SplitorImpl());


        return -1;
    }

}
