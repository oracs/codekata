package com.dy.kata.countoff.gamerule;

import com.dy.kata.countoff.gamerule.model.LiteralMapping;
import com.dy.kata.countoff.gamerule.model.Literals;
import com.dy.kata.countoff.gamerule.model.PlayRules;
import com.dy.kata.countoff.gamerule.model.SpecialNumbers;
import com.dy.kata.countoff.gamerule.play.PlayRule;

public class GameRule {
    private final SpecialNumbers specialNumbers;
    private final PlayRules playRules;
    private final LiteralMapping literalMapping = new LiteralMapping();

    public GameRule(SpecialNumbers specialNumbers, Literals literals, PlayRules playRules) {
        this.specialNumbers = specialNumbers;
        this.playRules = playRules;
        initTextMapping(specialNumbers, literals);
    }

    private void initTextMapping(SpecialNumbers specialNumbers, Literals literals) {
        for (int i = 0; i < specialNumbers.size(); i++) {
            literalMapping.put(specialNumbers.get(i), literals.get(i));
        }
    }

    public String convert(int number) {
        String result = "";
        for (int i = 0; i < playRules.size(); i++) {
            PlayRule playRule = playRules.get(i);
            result += playRule.convert(number, specialNumbers, literalMapping);
            if (playRule.isBreak()) break;
        }
        return result.equals("") ? String.valueOf(number) : result;
    }
}
