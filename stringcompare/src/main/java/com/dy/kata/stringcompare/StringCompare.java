package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.SplitResult;
import com.dy.kata.stringcompare.analyze.convertor.Transformer;

public class StringCompare {

    public int compare(String str1, String str2) {
        SplitResult splitedStr1 = new Analyzer(str1)
                                        .transform(new Transformer())
//                                        .split()
                                        .result();


        return -1;
    }

}
