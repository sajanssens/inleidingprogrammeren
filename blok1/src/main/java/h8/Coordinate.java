package h8;

public class Coordinate extends Object {

    public double x;
    public double y;

    @Override
    public boolean equals(Object o) {
        Coordinate c2 = (Coordinate) o;
        return this.x == c2.x && this.y == c2.y;
    }

    @Override
    public String toString() {
        return "X=" + this.x + " en Y=" + this.y;
    }

    @Override
    protected void finalize() throws Throwable {
        
    }
}
