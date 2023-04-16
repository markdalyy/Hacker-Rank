package day2;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        System.out.println(countingSort(arr));
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] freq = new int[100];
        for (Integer val : arr) {
            freq[val]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int f : freq) {
            result.add(f);
        }
        return result;

    }

}
