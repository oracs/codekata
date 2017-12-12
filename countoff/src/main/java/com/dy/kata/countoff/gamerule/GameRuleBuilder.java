package com.dy.kata.countoff.gamerule;

import com.dy.kata.countoff.gamerule.play.PlayRule;
import com.dy.kata.countoff.gamerule.vo.Literals;
import com.dy.kata.countoff.gamerule.vo.PlayRules;
import com.dy.kata.countoff.gamerule.vo.SpecialNumbers;

public class GameRuleBuilder {
    private SpecialNumbers specialNumbers;
    private Literals literals;
    private PlayRules playRules;

    public GameRuleBuilder specailNum(Integer... numbers) {
        specialNumbers = new SpecialNumbers(numbers);
        return this;
    }

    public GameRuleBuilder toText(String... texts) {
        literals = new Literals(texts);
        return this;
    }

    public GameRuleBuilder applyRule(PlayRule... playRules) {
        this.playRules = new PlayRules(playRules);
        return this;
    }

    public GameRule build() {
        return new GameRule(specialNumbers, literals, playRules);
    }
}
