package com.dy.kata.stringcompare.analyze.split;

import com.dy.kata.stringcompare.model.SplitResult;
import com.dy.kata.stringcompare.model.SplitUnit;

import static com.dy.kata.stringcompare.model.ResultType.digit;
import static com.dy.kata.stringcompare.model.ResultType.letter;

//"abc#12#cd#345#6eA@66@@65@1"
public class SplitorImpl implements Splitor {
    @Override
    public SplitResult split(String input) {
        SplitResult result = new SplitResult();

        char[] charArray = input.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < charArray.length; i++) {
            // letter
            if (Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
                if ((i + 1) < input.length() && !Character.isLetter(charArray[i + 1])
                        || (i + 1) == input.length()) {  // 下一位还是字符或者已在尾部
                    result.add(new SplitUnit(letter, sb.toString(), sb.length()));
//                    System.out.println("letter: " + sb);
                    sb.setLength(0);
                }
            }

            // digit
            if (Character.isDigit(charArray[i])) {
                sb.append(charArray[i]);
                if ((i + 1) < input.length() && !Character.isDigit(charArray[i + 1])
                        || (i + 1) == input.length()) {
                    result.add(new SplitUnit(digit, sb.toString(), sb.length()));
//                    System.out.println("digit: " + sb);
                    sb.setLength(0);
                }
            }

            // transformed letter
            if (charArray[i] == '#') {
                for (int x = i + 1; x < charArray.length; x++) {
                    sb.append(charArray[x]);
                    if (charArray[x] == '#') {
                        result.add(new SplitUnit(letter, sb.deleteCharAt(sb.length() - 1).toString(), sb.length()));
                        i = i + sb.length() + 1;
//                        System.out.println("transformed letter: " + sb);
                        sb.setLength(0);
                        break;
                    }
                }
            }

            // transformed digit
            if (charArray[i] == '@') {
                for (int x = i + 1; x < charArray.length; x++) {
                    sb.append(charArray[x]);
                    if (charArray[x] == '@') {
                        result.add(new SplitUnit(digit, sb.deleteCharAt(sb.length() - 1).toString(), 1));
                        i = i + sb.length() + 1;
//                        System.out.println("transformed digit: " + sb);
                        sb.setLength(0);
                        break;
                    }
                }
            }
        }

        return result;
    }

}
