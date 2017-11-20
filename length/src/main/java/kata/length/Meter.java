package kata.length;

public class Meter extends AbstractLength {
    public Meter(int number) {
        super(number);
    }

    @Override
    public int base() {
        return 100 * number;
    }

    @Override
    public String unitName() {
        return "m";
    }
}
