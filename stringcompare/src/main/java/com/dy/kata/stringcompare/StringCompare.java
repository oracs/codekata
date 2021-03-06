package com.dy.kata.stringcompare;

import com.dy.kata.stringcompare.analyze.StringAnalyzer;
import com.dy.kata.stringcompare.analyze.compare.FastStrComparator;
import com.dy.kata.stringcompare.analyze.compare.StringComparater;
import com.dy.kata.stringcompare.analyze.merge.MergeImpl;
import com.dy.kata.stringcompare.analyze.merge.Merger;
import com.dy.kata.stringcompare.analyze.split.Splitor;
import com.dy.kata.stringcompare.analyze.split.SplitorImpl;
import com.dy.kata.stringcompare.analyze.transform.Transformer;
import com.dy.kata.stringcompare.analyze.transform.TransformerImpl;
import com.dy.kata.stringcompare.model.SplitResult;

public class StringCompare {

    public int compare(String str1, String str2) {
        Transformer transformer = new TransformerImpl();
        Splitor splitor = new SplitorImpl();
        Merger merger = new MergeImpl();

        SplitResult splitedStr1 = new StringAnalyzer(str1)
                                        .analysis(transformer, splitor, merger);

        SplitResult splitedStr2 = new StringAnalyzer(str2)
                                        .analysis(transformer, splitor, merger);

        int result = new StringComparater(splitedStr1, splitedStr2)
                                        .compare(new FastStrComparator());

        return result;
    }

}
