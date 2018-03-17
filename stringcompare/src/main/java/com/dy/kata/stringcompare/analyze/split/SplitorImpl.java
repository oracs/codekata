package com.dy.kata.stringcompare.analyze.split;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import static com.dy.kata.stringcompare.model.ResultType.letter;

//"abc#12#cd#345#6eA@66@@65@1"
public class SplitorImpl implements Splitor {
    @Override
    public SplitResult split(String input) {
        SplitResult result = new SplitResult();

        char[] charArray = input.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
                if ((i + 1) < input.length() && !Character.isLetter(charArray[i + 1])
                        || (i + 1) == input.length()) {  // 下一位还是字符或者已在尾部
                    result.add(new SplitUnit(letter, sb.toString()));
                    sb.setLength(0);
                }
            }
        }

        return result;
    }
}
