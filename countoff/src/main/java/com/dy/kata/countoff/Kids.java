package com.dy.kata.countoff;

public class Kids {
    public String countOff(int number) {
        String result = "";
        if (number % 3 == 0) {
            result = "石头";
        } else if (number % 5 == 0) {
            result = "剪刀";
        } else if (number % 7 == 0) {
            result = "布";
        } else {
            result = String.valueOf(number);
        }

        return result;
    }
}
