package T04_Inheritance.A04_01;

public abstract class Flower implements Comparable<Flower> {

    private double length;
    private double freshness;

    public Flower(double length, double freshness) {
        this.length = length;
        this.freshness = freshness;
    }

    public double getLength() {return length;}
    public void setLength(double length) {this.length = length;}
    public double getFreshness() {return freshness;}
    public void setFreshness(double freshness) {this.freshness = freshness;}

    public abstract double getPrice();

    @Override
    public int compareTo(Flower other) {
//        return Double.compare(freshness, other.freshness);
        if (freshness > other.freshness)
            return 1;
        else if (freshness < other.freshness)
            return -1;
        else
            return 0;
    }
}
