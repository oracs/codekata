package com.dy.kata.poker.v1;

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
}
