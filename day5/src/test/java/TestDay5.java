import day5.ex1.Exercise1;
import day5.ex2.Exercise2;
import day5.ex3.Exercise3;
import day5.ex4.Exercise4;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestDay5 {
    public static void main(String[] args) {
        Integer[] ar = {1, 2, 3, 4, -1, -2, -3, -4, 0, 5};
        new Exercise1().countOddAndPrimeNumbers(ar);

        System.out.println(String.format("Origin array: %s", Arrays.toString(ar)));
        new Exercise2().exchange(ar, 0, 2);
        System.out.println(String.format("Array after exchange: %s", Arrays.toString(ar)));

        int begin = 0;
        int end = 10;
        System.out.println(String.format("Maximal of list %s from index %d to index %d is: %s",
                Arrays.toString(ar), begin, end, new Exercise3().findMax(Arrays.asList(ar), begin, end)));

        System.out.println("Run Exercise 4!");
        try {
            Exercise4.cat(new File("src\\main\\java\\day5\\ex4\\test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
