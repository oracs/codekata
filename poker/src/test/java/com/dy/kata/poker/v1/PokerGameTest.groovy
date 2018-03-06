package com.dy.kata.poker.v1

import spock.lang.Specification


class PokerGameTest extends Specification {
    def "test_comparing_poker_hands"() {
        expect:
        result == new PokerGame().play(hand1, hand2)

        where:
        hand1                     | hand2                     || result
        "Black: 2H 3D 5S 9C KD"   | "White: 2C 3H 4S 8C AH"   || "White wins. - with high card"

    }
}
