package kata.length;

import kata.length.impl.CentiMeter;
import kata.length.impl.DeciMeter;

public class LengthFactory {
    public static Meter m(int number) {
        return new Meter(number);
    }

    public static CentiMeter cm(int number) {
        return new CentiMeter(number);
    }

    public static DeciMeter dm(int number) {
        return new DeciMeter(number);
    }

}
