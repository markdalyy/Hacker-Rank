package day1;

import java.util.*;

public class miniMaxSum {
    public static void main(String[] args) {
        // Write your code here
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        System.out.println(arr);
        //Arrays.sort(arr);
        Collections.sort(arr);
        System.out.println(arr);
        long minSum = 0;
        //for (int i = 0; i < arr.length-1; i++) {
        for (int i = 0; i < arr.size()-1; i++) {
            //minSum += arr[i];
            minSum += arr.get(i);
        }
        long maxSum = minSum - arr.get(0) + arr.get(arr.size()-1);
        System.out.println(minSum + " " + maxSum);
        //System.out.printf("%d %d", minSum, maxSum);
    }
}
