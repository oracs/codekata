package com.dy.kata.stringcompare.analyze.split.action;

import com.dy.kata.stringcompare.model.SplitUnit;

import static com.dy.kata.stringcompare.model.ResultType.letter;

public interface SplitAction {
    SplitUnit split(char[] charArray, int i, StringBuffer sb);

    static SplitAction splitOnlyLetter() {
        return (charArray, i, sb) -> {
            sb.append(charArray[i]);
            if ((i + 1) < charArray.length && !Character.isLetter(charArray[i + 1])
                    || (i + 1) == charArray.length) {  // 下一位还是字符或者已在尾部
                StringBuffer tmp = new StringBuffer(sb);
                sb.setLength(0);
                return new SplitUnit(letter, tmp.toString(), tmp.length());
            }
            return null;
        };
    }

}
