package com.dy.kata.bowling

import com.dy.kata.bowing.BowingGame
import spock.lang.Specification


class BowingGameTest extends Specification {

    def "test_bowing_games"() {
        given:
        BowingGame game = new BowingGame()

        expect:
        score == game.play(frame)

        where:
        frame                         ||   score
        "X|X|X|X|X|X|X|X|X|X||XX"     ||   300
    }
}
