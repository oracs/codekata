package com.dy.kata.stringcompare.analyze.convertor;

public interface Convertor {
    String convert(String str);

    static Convertor transform() {
        return new Transformer();
    }


}
