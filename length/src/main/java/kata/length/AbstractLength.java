package kata.length;

import kata.length.impl.Length;

import static kata.length.LengthFactory.*;

public abstract class AbstractLength implements Length {
    protected int number;

    public AbstractLength(int number) {
        this.number = number;
    }

    public boolean eq(Length other) {
        return this.base() == other.base();
    }

    public boolean lt(Length other) {
        return this.base() < other.base();
    }

    public boolean gt(Length other) {
        return this.base() > other.base();
    }

    public String alias() {
        if (number == 0) return "";
        return String.valueOf(number) + unitName();
    }

    public String convert() {
        return transTo(base());
    }

    private String transTo(int base) {
        int mCount = base / 100;
        int dmCount = base % 100 / 10;
        int cmCount = base % 100 % 10;
        return m(mCount).alias() + dm(dmCount).alias() + cm(cmCount).alias();
    }

    public String add(Length other) {
        return transTo(this.base() + other.base());
    }

}
