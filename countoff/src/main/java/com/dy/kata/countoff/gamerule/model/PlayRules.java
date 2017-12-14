package com.dy.kata.countoff.gamerule.model;

import com.dy.kata.countoff.gamerule.play.PlayRule;

import java.util.Arrays;
import java.util.List;

public class PlayRules {
    private final List<PlayRule> playRules;

    public PlayRules(PlayRule[] playRules) {
        this.playRules = Arrays.asList(playRules);
    }

    public int size() {
        return playRules.size();
    }

    public PlayRule get(int index) {
        return playRules.get(index);
    }
}
