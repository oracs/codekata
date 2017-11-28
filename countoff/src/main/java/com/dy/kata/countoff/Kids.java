package com.dy.kata.countoff;

public class Kids {
    public String countOff(int number) {
        String result = "";

        if (String.valueOf(number).contains("3")) return "石头";

        if (number % 3 == 0) {
            result += "石头";
        }
        if (number % 5 == 0) {
            result += "剪刀";
        }
        if (number % 7 == 0) {
            result += "布";
        }

        if (result.equals("")) {
            result = String.valueOf(number);
        }

        return result;
    }
}
