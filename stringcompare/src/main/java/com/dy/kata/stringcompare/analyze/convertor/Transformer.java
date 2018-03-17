package com.dy.kata.stringcompare.analyze.convertor;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Transformer implements Convertor {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '/') {
                if (isNumeric(String.valueOf(charArray[i + 1]))) {  // after slash char is numeric
                    int nextNumericCounts = calcNumericCounts(input, i + 1);
                    result.append("#").append(input.substring(i + 1, i + 2 + nextNumericCounts)).append("#");
                    i = i + nextNumericCounts + 1;
                }
            } else {
                result.append(charArray[i]);
            }
        }

        return result.toString();
    }

    private int calcNumericCounts(String input, int position) {
        int length = input.length();
        int result = 0;

        for (int i = 1; i < 3; i++) {
            if ((position + i) < length && isNumeric(String.valueOf(input.charAt(position + i))) ) {
                result = i;
            }
        }

        return result;
    }


}
