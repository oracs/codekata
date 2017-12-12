package com.dy.kata.countoff.gamerule.play.impl;

import com.dy.kata.countoff.gamerule.play.PlayRule;
import com.dy.kata.countoff.gamerule.vo.LiteralMapping;
import com.dy.kata.countoff.gamerule.vo.SpecialNumbers;

public class MultipleRule implements PlayRule {
    private String result = "";

    @Override
    public String convert(int number, SpecialNumbers specialNumbers, LiteralMapping literalMapping) {
        for (int i = 0; i < specialNumbers.size(); i++) {
            if ((number % specialNumbers.get(i)) == 0) {
                result += literalMapping.get(specialNumbers.get(i));
            }
        }

        return result;
    }

    @Override
    public boolean isBreak() {
        return false;
    }
}
