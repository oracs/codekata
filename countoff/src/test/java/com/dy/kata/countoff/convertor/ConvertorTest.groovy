package com.dy.kata.countoff.convertor

import com.dy.kata.countoff.gamerule.MappingBuilder
import spock.lang.Specification

class ConvertorTest extends Specification {

    def "test_convert_special_numbers_357"() {
        given:
        NumConvertor convertor = new NumConvertor(new MappingBuilder()
                                                    .from(3, 5, 7)
                                                    .to("石头", "剪刀", "布")
                                                    .build());

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

    def "test_convert_special_numbers_579"() {
//        given:
//        NumConvertor convertor = new NumConvertor(new Literal1(5, 7, 9))
//
//        expect:
//        result == convertor.convert(number)
//
//        where:
//        number || result
//        1      || "1"
//        2      || "2"
//        3      || "3"
//        4      || "4"
//        5      || "石头"
//        6      || "6"
//        7      || "剪刀"
//        8      || "8"
//        9      || "布"
//        10     || "石头"
//        13     || "13"
//        14     || "剪刀"
//        15     || "石头"
//        18     || "布"
//        21     || "剪刀"
//        23     || "23"
//        33     || "33"
//        35     || "石头"
//        45     || "石头"
//        63     || "剪刀布"
//        105    || "石头"
    }
}