package com.dy.kata.poker.v1;

import static com.dy.kata.poker.v1.Rule.highcardRule;
import static com.dy.kata.poker.v1.Rule.rules;

public class PokerGame {
    public String play(String hand1, String hand2) {
        Player player1 = parseHand(hand1);
        Player player2 = parseHand(hand2);

        Result result = player1.compare(player2, rules(highcardRule()));

        return String.format("%s wins. - with %s", result.getWinner(), result.getReason());
    }

    private Player parseHand(String hand) {
        return new Parser().parse(hand);
    }
}
