package T07_Serialization;

import java.util.List;

public class A07_02 {

    public static void main(String[] args) {
        String inp = "src/T07_Serialization/input.luggage";
        String out = "src/T07_Serialization/output.luggage";

        Luggage[] array = {
            new Luggage("John", 10, 500.0),
            new Luggage("James", 1, 5.0),
            new Luggage("Vasya z rayouny", 3, 20.0)
        };
        List<Luggage> lst = List.of(array);

        Luggage.write(inp, lst);

        System.out.println(
            Luggage.read(inp)
        );

    }
}
