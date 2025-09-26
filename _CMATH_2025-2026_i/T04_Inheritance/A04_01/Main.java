package T04_Inheritance.A04_01;

public class Main {

    public static void main(String[] args) {
        Flower[] flowers = {
                new Dandelion(6.0, 3.2),
                new Peony(4.5, 6.1),
                new Peony(5.2, 3.0),
                new Dandelion(6.7, 1.0),
                new Dandelion(8.2, 5.6)
        };
        Bouquet bouquet = new Bouquet(flowers);
        System.out.println(bouquet);
        System.out.println("Ціна: " + bouquet.getPrice());
        bouquet.sort();
        System.out.println(bouquet);
        System.out.println(bouquet.getBouquetByFlowerLength(2.5, 5.5));
    }
}
