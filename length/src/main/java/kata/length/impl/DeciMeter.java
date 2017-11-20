package kata.length.impl;

import kata.length.AbstractLength;

public class DeciMeter extends AbstractLength {

    public DeciMeter(int number) {
        super(number);
    }

    @Override
    public int base() {
        return 10 * number;
    }

    @Override
    public String unitName() {
        return "dm";
    }

}
