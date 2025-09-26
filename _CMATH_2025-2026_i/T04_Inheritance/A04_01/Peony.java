package T04_Inheritance.A04_01;

public class Peony extends Flower {

    public Peony(double length, double freshness) {
        super(length, freshness);
    }

    @Override
    public String toString() {
        return "Пеон довжини " + getLength() +
                " та свіжості " + getFreshness();
    }

    @Override
    public double getPrice() {
        return 10.0 + 0.5 * getFreshness() + 0.7 * getLength();
    }
}
