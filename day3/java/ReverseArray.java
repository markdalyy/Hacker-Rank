package day3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

    public static void main(String[] args) {
        // Integer[] numbers = {1, 2, 3, 4, 5};
        // List<Integer> list = Arrays.asList(numbers);
        // Collections.reverse(list);

        int[] numbers = {1, 2, 3, 4, 5};
        int len = numbers.length;

        for (int i = 0; i < len/2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[len-i-1];
            numbers[len-i-1] = temp;
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

}
