package com.dy.kata.poker.v1;

public class PokerGame {
    public String play(String hand1, String hand2) {
        Player player1 = parseHand(hand1);
        Player player2 = parseHand(hand2);

        Result result = play1.compare(play2, rules(highcardRule()));

        return String.format("%s wins. - with ", result.getWinner(), result.getReason());
    }

    private Player parseHand(String hand) {
        return new Parser().parse(hand);
    }
}
