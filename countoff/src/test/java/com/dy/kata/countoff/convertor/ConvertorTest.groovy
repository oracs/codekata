package com.dy.kata.countoff.convertor

import spock.lang.Specification

class ConvertorTest extends Specification {

    def "test_convert_special_numbers"() {
        given:
        NumConvertor convertor = new NumConvertor(3, 5, 7)

        expect:
        result == convertor.convert(number)

        where:
        number || result
        1      || "1"
        2      || "2"
        3      || "石头"
        4      || "4"
        5      || "剪刀"
        6      || "石头"
        7      || "布"
        8      || "8"
        9      || "石头"
        10     || "剪刀"
        13     || "石头"
        14     || "布"
        15     || "石头剪刀"
        21     || "石头布"
        23     || "石头"
        33     || "石头"
        35     || "石头"
        105    || "石头剪刀布"
    }


}
