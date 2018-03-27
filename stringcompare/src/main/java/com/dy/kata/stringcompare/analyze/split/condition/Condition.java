package com.dy.kata.stringcompare.analyze.split.condition;

public interface Condition {
    boolean matches(Character c);

    static Condition isLetter() {
        return Character::isLetter;
    }
}
