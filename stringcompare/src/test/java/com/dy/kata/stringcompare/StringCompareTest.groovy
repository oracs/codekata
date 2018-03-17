package com.dy.kata.stringcompare

import spock.lang.Specification


class StringCompareTest extends Specification{

    def "test string compare"() {
        given:
        StringCompare comparator = new StringCompare()

        expect:
        result == comparator.compare(str1, str2)

        where:
        str1     | str2    || result
        "B2C"    | "B2"    || -1
//        "B2"     | "B2"    || 0
    }
}