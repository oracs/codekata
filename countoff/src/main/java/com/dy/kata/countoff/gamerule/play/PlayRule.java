package com.dy.kata.countoff.gamerule.play;

import com.dy.kata.countoff.gamerule.vo.LiteralMapping;
import com.dy.kata.countoff.gamerule.vo.SpecialNumbers;

public interface PlayRule {
    String convert(int number, SpecialNumbers specialNumbers, LiteralMapping literalMapping);
    boolean isBreak();
}
