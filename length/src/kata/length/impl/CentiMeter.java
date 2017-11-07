package kata.length.impl;

import kata.length.AbstractLength;

public class CentiMeter extends AbstractLength {
    public CentiMeter(int number) {
        super(number);
    }

    @Override
    public int base() {
        return number;
    }

    @Override
    public String unitName() {
        return "cm";
    }

}
