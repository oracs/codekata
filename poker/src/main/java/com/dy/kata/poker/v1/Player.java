package com.dy.kata.poker.v1;

import java.util.List;

public class Player {
    private String name;
    private String handText;

    public Player(String name, String handText) {
        this.name = name;
        this.handText = handText;
    }

    public String getName() {
        return name;
    }

    public String getHand() {
        return handText;
    }

    public Result compare(Player otherPlayer, List<Rule> rules) {
        return new Result("", "");
    }
}
