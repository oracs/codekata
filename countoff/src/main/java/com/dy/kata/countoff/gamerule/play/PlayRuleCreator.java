package com.dy.kata.countoff.gamerule.play;

import com.dy.kata.countoff.gamerule.play.impl.Contains2thSpecialNumRule;
import com.dy.kata.countoff.gamerule.play.impl.ContainsRule;
import com.dy.kata.countoff.gamerule.play.impl.MultipleRule;

public class PlayRuleCreator {
    public static PlayRule containsRule() {
        return new ContainsRule();
    }

    public static PlayRule multipleRule() {
        return new MultipleRule();
    }

    public static PlayRule contains2thSpecialNumRule() {
        return new Contains2thSpecialNumRule();
    }
}
