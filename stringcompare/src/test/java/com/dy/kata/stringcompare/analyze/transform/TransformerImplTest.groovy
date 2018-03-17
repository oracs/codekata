package com.dy.kata.stringcompare.analyze.transform

import spock.lang.Specification

class TransformerImplTest extends Specification {

    def "test transform slash character"() {
        given:
        Transformer transformer = new TransformerImpl()

        expect:
        result == transformer.convert(str)

        where:
        str                    ||  result
        // numerics after splash
        "abc/1"                ||  "abc#1#"
        "abc/12"               ||  "abc#12#"
        "abc/123"              ||  "abc#123#"
        "abc/1234"             ||  "abc#123#4"
        "0/1234"               ||  "0#123#4"
        "/1a"                  ||  "#1#a"
        "abc/12cdefg"          ||  "abc#12#cdefg"
        "0/123abc/4"           ||  "0#123#abc#4#"
        "0/123/4321"           ||  "0#123##432#1"
        "abc/12cd/3456e"       ||  "abc#12#cd#345#6e"
        // alphabets after splash
        "1/A"                  ||  "1@65@"
        "1/A/A"                ||  "1@65@@65@"
        "1/A/A3"               ||  "1@65@@65@3"
        "1/A/AA"               ||  "1@65@@65@A"
        "A/B/A1"               ||  "A@66@@65@1"
        // complex
        "abc/12cd/3456eA/B/A1" ||  "abc#12#cd#345#6eA@66@@65@1"
    }
}
