package com.dy.kata.poker.v1;

public class Result {
    private String winner;
    private String reason;

    public Result(String winner, String reason) {
        this.winner = winner;
        this.reason = reason;
    }

    public String getWinner() {
        return winner;
    }

    public String getReason() {
        return reason;
    }
}
