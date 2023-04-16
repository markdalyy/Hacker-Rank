package day2;

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(9);
        arr3.add(8);
        arr3.add(9);

        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);
        //System.out.println(arr.get(1).get(1));
        System.out.println("Diagonal Difference: " + diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int ltrSum = 0;
        int rtlSum = 0;
        int len = arr.size(); // num rows
        for (int i = 0; i<len; i++) {
            ltrSum += arr.get(i).get(i);
            rtlSum += arr.get(i).get(len-i-1);
        }
        System.out.println("left to right sum: " + ltrSum);
        System.out.println("right to left sum: " + rtlSum);
        return Math.abs(ltrSum-rtlSum);

    }
}
