package com.dy.kata.countoff.gamerule.play;

import com.dy.kata.countoff.gamerule.model.LiteralMapping;
import com.dy.kata.countoff.gamerule.model.SpecialNumbers;

public interface PlayRule {
    String convert(int number, SpecialNumbers specialNumbers, LiteralMapping literalMapping);
    boolean isBreak();
}
