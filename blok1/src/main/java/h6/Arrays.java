package h6;

import h7.Telefoon;

import java.util.Random;

public class Arrays {

    public static void main(String[] args) {

        for (String arg : args) {
            System.out.println(arg);
        }

        int[] numbers = {1, 2, 3, 4, 5};
        int number = numbers[0];
        // numbers[1] = 10;

        incrementEachElement(numbers);

        int length = numbers.length;
        int number5 = numbers[length - 1];

        Telefoon[] telefoons = new Telefoon[10];
        telefoons[0] = new Telefoon();
        telefoons[1] = new Telefoon("Samsung", 89d, "06...");

        int[][] tabel = {
                {1, 2},
                {5},
                {7, 4, 7}
        };

        tabel[0][1] = 56;
        tabel[1][0] = 156;
        tabel[2][2] = 256;

        for (int[] ints : tabel) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < tabel.length; i++) {
            int[] ints = tabel[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.println(tabel[i][j]);
            }
        }

        int[] result = createArray(10, 50);

        System.out.println("Einde");
    }

    private static void incrementEachElement(int[] eenArray) {
        for (int i = 0; i < eenArray.length; i++) {
            eenArray[i]++;
        }
    }

    public static int[] createArray(int length, int upperBound) {
        Random random = new Random();
        int[] tempArr = new int[length];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = random.nextInt(upperBound) + 1;
            double random1 = Math.random() * 50;
        }
        return tempArr;
    }

}
