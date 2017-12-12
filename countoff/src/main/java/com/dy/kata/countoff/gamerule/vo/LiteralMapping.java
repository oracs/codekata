package com.dy.kata.countoff.gamerule.vo;

import java.util.HashMap;
import java.util.Map;

public class LiteralMapping {
    private final Map<Integer, String> mapping = new HashMap<>();

    public void put(int number, String literal) {
        mapping.put(number, literal);
    }

    public String get(int number) {
        return mapping.get(number);
    }
}
