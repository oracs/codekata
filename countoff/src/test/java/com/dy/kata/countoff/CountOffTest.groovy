package com.dy.kata.countoff

import spock.lang.Specification

class CountOffTest extends Specification {

    def "test_countoff_special_numbers"() {
        given:
        Kids kids = new Kids()

        expect:
        result == kids.countOff(number)

        where:
        number || result
        3      || "石头"
        5      || "剪刀"
        7      || "布"

    }
}
