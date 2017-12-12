package com.dy.kata.countoff.gamerule.vo;

import java.util.Arrays;
import java.util.List;

public class Literals {
    private final List<String> literals;

    public Literals(String[] texts) {
        literals = Arrays.asList(texts);
    }

    public String get(int index) {
        return literals.get(index);
    }
}
