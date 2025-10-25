package T07_Serialization;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class A07_01 {

    /*
    Створити бінарний файл F, компонентами якого є цілі числа. Описати
    який містив би всі компоненти файлу F, що є парними числами.
    */
    public static void main(String[] args) {
        String inp = "src/T07_Serialization/input.int32";
        String out = "src/T07_Serialization/output.int32";

        int[] array = {65, 0, 1, 2, -1, 876, 234, 101, 509};

        write(inp, array);
        array = read(inp);
        System.out.println(Arrays.toString(array));

        var lst = new ArrayList<Integer>();
        for (int j : array) {
            if (j % 2 == 0) {
                lst.add(j);
            }
        }
        writeWithByteBuffer(out, lst);
        array = readWithByteBuffer(out);
        System.out.println(Arrays.toString(array));
    }

    public static int[] read(String inp) {
        int[] result;
        try {
            var finp = new DataInputStream(
                new FileInputStream(inp)
            );
            int count = (int) new File(inp).length() / Integer.BYTES;
            result = new int[count];
            for (int i = 0; i < count; i++) {
                result[i] = finp.readInt();
            }
            finp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void write(String out, int[] array) {
        try {
            var fout = new DataOutputStream(
                new FileOutputStream(out)
            );
            for (int n : array)
                fout.writeInt(n);
            fout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String out, ArrayList<Integer> lst) {
        try {
            var fout = new DataOutputStream(
                new FileOutputStream(out)
            );
            for (int n : lst)
                fout.writeInt(n);
            fout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readWithByteBuffer(String inp) {
        int[] result;
        try {
            var finp = new FileInputStream(inp);
            ByteBuffer bb = ByteBuffer.wrap(finp.readAllBytes());
            result = new int[bb.capacity() / Integer.BYTES];
            for (int i = 0; i < result.length; i++) {
                result[i] = bb.getInt();
            }
            finp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void writeWithByteBuffer(String out, ArrayList<Integer> lst) {
        try {
            var fout = new FileOutputStream(out);
            ByteBuffer bb = ByteBuffer.allocate(lst.size() * Integer.BYTES);
            for (int n : lst)
                bb.putInt(n);
            fout.write(bb.array());
            fout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
