package T04_Inheritance.A04_01;

import java.util.ArrayList;
import java.util.Arrays;

public class Bouquet {

    public Flower[] flowers;

    public Bouquet(Flower[] flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        return Arrays.toString(flowers);
    }

    public double getPrice() {
        double result = 0.0;
        for (Flower flower: flowers)
            result += flower.getPrice();
        return result;
    }

    public void sort() {
        Arrays.sort(flowers);
    }

    public Bouquet getBouquetByFlowerLength(double bottom, double top) {
        ArrayList<Flower> list = new ArrayList<>();
        for (Flower flower: flowers) {
            if (bottom < flower.getLength() && flower.getLength() < top)
                list.add(flower);
        }
        Flower[] array = list.toArray(new Flower[0]);
        return new Bouquet(array);
    }

}
