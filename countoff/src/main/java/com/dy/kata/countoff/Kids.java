package com.dy.kata.countoff;

import com.dy.kata.countoff.convertor.NumConvertor;
import com.dy.kata.countoff.literal.Literal;

public class Kids {
    private Literal literal;

    public Kids(Literal literal) {
        this.literal = literal;
    }

    public String countOff(int toNumber) {
        String result = "";
        NumConvertor convertor = new NumConvertor(literal);
        for (int i = 1; i <= toNumber; i++) {
            result += convertor.convert(i) + ",";
        }
        return result.substring(0, result.length() - 1);
    }
}
