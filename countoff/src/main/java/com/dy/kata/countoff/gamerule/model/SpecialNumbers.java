package com.dy.kata.countoff.gamerule.model;

import java.util.Arrays;
import java.util.List;

public class SpecialNumbers {
    private final List<Integer> specialNumbers;

    public SpecialNumbers(Integer[] numbers) {
        specialNumbers = Arrays.asList(numbers);
    }

    public int size() {
        return specialNumbers.size();
    }

    public int get(int index) {
        return specialNumbers.get(index);
    }
}
