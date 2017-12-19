package com.dy.kata.countoff.gamerule;

import com.dy.kata.countoff.gamerule.model.Literals;
import com.dy.kata.countoff.gamerule.model.PlayRules;
import com.dy.kata.countoff.gamerule.model.SpecialNumbers;
import com.dy.kata.countoff.gamerule.play.PlayRule;

public class GameRuleBuilder {
    private SpecialNumbers specialNumbers;
    private Literals literals;
    private PlayRules playRules;

    public GameRuleBuilder specailNum(Integer... numbers) {
        specialNumbers = new SpecialNumbers(numbers);
        return this;
    }

    public GameRuleBuilder to(String... texts) {
        literals = new Literals(texts);
        return this;
    }

    public GameRuleBuilder apply(PlayRule... playRules) {
        this.playRules = new PlayRules(playRules);
        return this;
    }

    public GameRule build() {
        return new GameRule(specialNumbers, literals, playRules);
    }
}
