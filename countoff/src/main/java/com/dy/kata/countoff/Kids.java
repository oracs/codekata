package com.dy.kata.countoff;

import com.dy.kata.countoff.convertor.NumConvertor;

public class Kids {
    public String countOff(int toNumber) {
        String result = "";
        NumConvertor convertor = new NumConvertor(3, 5, 7);
        for (int i = 1; i <= toNumber; i++) {
            result += convertor.convert(i) + ",";
        }
        return result.substring(0, result.length() - 1);
    }
}
