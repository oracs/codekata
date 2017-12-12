package com.dy.kata.countoff.gamerule;

import com.dy.kata.countoff.gamerule.play.PlayRule;
import com.dy.kata.countoff.gamerule.vo.LiteralMapping;
import com.dy.kata.countoff.gamerule.vo.Literals;
import com.dy.kata.countoff.gamerule.vo.PlayRules;
import com.dy.kata.countoff.gamerule.vo.SpecialNumbers;

public class GameRule {
    private final SpecialNumbers specialNumbers;
    private final PlayRules playRules;
    private final LiteralMapping literalMapping = new LiteralMapping();

    public GameRule(SpecialNumbers specialNumbers, Literals literals, PlayRules playRules) {
        this.specialNumbers = specialNumbers;
        this.playRules = playRules;
        initMapping(specialNumbers, literals);
    }

    private void initMapping(SpecialNumbers specialNumbers, Literals literals) {
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
