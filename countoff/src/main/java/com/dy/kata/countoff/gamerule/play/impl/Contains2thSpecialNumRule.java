package com.dy.kata.countoff.gamerule.play.impl;

import com.dy.kata.countoff.gamerule.model.LiteralMapping;
import com.dy.kata.countoff.gamerule.model.SpecialNumbers;
import com.dy.kata.countoff.gamerule.play.PlayRule;

public class Contains2thSpecialNumRule implements PlayRule {
    private boolean isBreak;

    @Override
    public String convert(int number, SpecialNumbers specialNumbers, LiteralMapping literalMapping) {
        int secondNum = specialNumbers.get(1);
        if (String.valueOf(number).contains(String.valueOf(secondNum))) {
            isBreak = true;
            return literalMapping.get(secondNum);
        }
        return "";
    }

    @Override
    public boolean isBreak() {
        return isBreak;
    }
}
