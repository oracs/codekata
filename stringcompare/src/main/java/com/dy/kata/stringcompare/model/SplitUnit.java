package com.dy.kata.stringcompare.model;

public class SplitUnit {
    private ResultType type;
    private String content;
    private int length;

    public SplitUnit(ResultType type, String content) {
        this.type = type;
        this.content = content;
    }

    public SplitUnit(ResultType type, String content, int length) {
        this.type = type;
        this.content = content;
        this.length = length;
    }

    public ResultType type() {
        return type;
    }

    public String content() {
        return content;
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        return "SplitUnit{" +
                "type=" + type +
                ", content='" + content + '\'' +
                ", length=" + length +
                '}';
    }
}
