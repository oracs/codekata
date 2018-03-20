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
        "b2"     | "c2"    || -1
        "Abc"    | "abc"   || -1
        "abc"    | "aBc"   || 1
        "abc"    | "abc"   || 0
        "abc"    | "abcd"  || -1
        "abcd"   | "abc"   || 1
        "123"    | "123"   || 0
        "1234"   | "123"   || 1
        "508"    | "123"   || 1
        "121"    | "123"   || -1
        "12"     | "012"   || -1
        "00900"  | "0900"  || 1
        "0018"   | "0018"  || 0
        "ab123"  | "ab"    || 1
        "ab"     | "ab10"  || -1
        "ab49"   | "ab49"  || 0
        "98ce"   | "98ce"  || 0
        "98"     | "98ff"  || -1
        "98fe"   | "98"    || 1
        "gc0c"   | "gc0c"  || 0
        "gc0f"   | "gc0g"  || -1
        "000h"   | "00h"   || 1

        // more test cases
        "abc/123"        | "abc/123"       || 0
        "abc/123"        | "abc/234"       || -1
        "abc/28"         | "abc/8"         || -1
        "abc/82"         | "abc/8"         || 1
        "abc/1234"       | "abc/1235"      || -1
        "ab0/a"          | "ab97"          || 0
        "dc9/a/a"        | "dc1967"        || -1
        "123/A/888/B456" | "1295/888/B456" || 0
        "4294967/A295bb" | "4294967/A295aa"|| 1

    }
}
