package day2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LonelyInteger {

    public static void main(String[] args) {
        // List<Integer> arr = new ArrayList<Integer>();
        // arr.add(1); arr.add(1); arr.add(2); arr.add(3); arr.add(3);
        // List<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3));
        int[] a = {1, 1, 2, 3, 3};
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(lonelyInteger(arr));
    }

    public static int lonelyInteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int elem : a) {
            if (countMap.containsKey(elem)) {
                int update = countMap.get(elem) + 1;
                countMap.replace(elem, update);
            } else {
                countMap.put(elem, 1);
            }
        }
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
