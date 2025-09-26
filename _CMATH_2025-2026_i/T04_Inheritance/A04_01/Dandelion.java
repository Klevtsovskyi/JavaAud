package T04_Inheritance.A04_01;

public class Dandelion extends Flower {

    public Dandelion(double length, double freshness) {
        super(length, freshness);
    }

    @Override
    public String toString() {
        return "Кульбаба довжини " + getLength() +
                " та свіжості " + getFreshness();
    }

    @Override
    public double getPrice() {
        return 5.0 + getLength() * 0.3 + getFreshness();
    }
}
