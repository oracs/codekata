package com.dy.kata.stringcompare.analyze.merge;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;
import org.junit.Test;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;

public class MergeImplTest {
    @Test
    public void test_letter_merge() throws Exception {
//        ("abc#123#456", 3, asList(letter, letter, digit), asList("abc","123","456"));
        SplitUnit unit1 = new SplitUnit(letter, "abc", 3);
        SplitUnit unit2 = new SplitUnit(letter, "123", 3);
        SplitUnit unit3 = new SplitUnit(digit, "456", 3);

        SplitResult original = new SplitResult() ;
        original.add(unit1);
        original.add(unit2);
        original.add(unit3);

        SplitResult mergedResult = new MergeImpl().merge(original);




    }
}