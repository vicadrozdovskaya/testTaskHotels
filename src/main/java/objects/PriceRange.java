package objects;

public enum PriceRange {
    FIRST(0, 39.99), SECOND(40, 79.99), THIRD(80, Double.MAX_VALUE);

    private double min;
    private double max;

    PriceRange (double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin () {
        return min;
    }

    public double getMax () {
        return max;
    }
}
