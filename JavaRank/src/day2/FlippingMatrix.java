package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingMatrix {
//    {112, 42, 83, 119},
//    {56, 125, 56, 49},
//    {15, 78, 101, 43},
//    {62, 98, 114, 108}
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size()/2;
        int sum = 0;
        //Find the 4 swaps for each index in the n*n matrix and add the max
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num1 = matrix.get(i).get(j);
                int num2 = matrix.get(i).get(2*n - j - 1);
                int num3 = matrix.get(2*n - i - 1).get(j);
                int num4 = matrix.get(2*n - i - 1).get(2*n - j - 1);
                System.out.println(num1 + " " + num2 + " " + num3 + " " + num4);
                sum += Math.max(num1, Math.max(num2, Math.max(num3, num4)));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        /*List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(112, 42, 83, 119));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(56, 125, 56, 49));
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(15, 78, 101, 43));
        List<Integer> arr4 = new ArrayList<>(Arrays.asList(62, 98, 114, 108));

        arr.add(arr1);
        arr.add(arr2);
        arr.add(arr3);
        arr.add(arr4);*/
        int[][] before = {
                {112, 42, 83, 119},
                {56, 125, 56, 49},
                {15, 78, 101, 43},
                {62, 98, 114, 108}
        };
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < before.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < before[0].length; j++) {
                list.add(before[i][j]);
            }
            arr.add(list);
        }

        System.out.println(flippingMatrix(arr));
    }

}
