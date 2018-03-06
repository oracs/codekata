package com.dy.kata.poker.v1;

public class Parser {
    public Player parse(String hand) {
        String[] handText = hand.split(":");
        return new Player(handText[0], handText[1].trim());
    }
}
