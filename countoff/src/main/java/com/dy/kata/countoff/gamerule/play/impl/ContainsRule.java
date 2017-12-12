package com.dy.kata.countoff.gamerule.play.impl;

import com.dy.kata.countoff.gamerule.play.PlayRule;
import com.dy.kata.countoff.gamerule.vo.LiteralMapping;
import com.dy.kata.countoff.gamerule.vo.SpecialNumbers;

public class ContainsRule implements PlayRule {
    private boolean isBreak;

    @Override
    public String convert(int number, SpecialNumbers specialNumbers, LiteralMapping literalMapping) {
        int firstNum = specialNumbers.get(0);
        if (String.valueOf(number).contains(String.valueOf(firstNum))) {
            isBreak = true;
            return literalMapping.get(firstNum);
        }
        return "";
    }

    @Override
    public boolean isBreak() {
        return isBreak;
    }
}
