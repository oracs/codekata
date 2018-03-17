package com.dy.kata.stringcompare.model;

public class SplitUnit {
    private ResultType type;
    private String content;

    public SplitUnit(ResultType type, String content) {
        this.type = type;
        this.content = content;
    }

    public ResultType type() {
        return type;
    }

    public String content() {
        return content;
    }
}
