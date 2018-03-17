package com.dy.kata.stringcompare.analyze.transform;


public class TransformerImpl implements Transformer {
    @Override
    public String convert(String input) {
        StringBuilder result = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '/') {
                if (Character.isDigit(charArray[i + 1])) {  // after slash char is numeric
                    int nextNumericCounts = calcNumericCounts(input, i + 1);
                    result.append("#").append(input.substring(i + 1, i + 2 + nextNumericCounts)).append("#");
                    i = i + nextNumericCounts + 1;
                } else {
                    result.append("@").append((int) charArray[i + 1]).append("@");
                    i = i + 1;
                }
            } else {
                result.append(charArray[i]);
            }
        }

        return result.toString();
    }

    private int calcNumericCounts(String input, int position) {
        int result = 0;

        for (int i = 1; i < 3; i++) {
            if ((position + i) < input.length() && Character.isDigit(input.charAt(position + i)) ) {
                result = i;
            }
        }

        return result;
    }


}
