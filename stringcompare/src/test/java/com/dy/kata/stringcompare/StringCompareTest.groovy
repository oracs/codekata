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
        "B2"     | "C2"    || -1
        "B3"     | "B2"    || 1
        "B2"     | "B2"    || 0
        "B002"   | "B2"    || 1
        "B2C"    | "B2"    || 1
        "B01"    | "B11"   || -1
        // more test cases
        "123/A/888/B456" | "1295/888/B456" || 0


    }
}
