package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        /*int numPairs = 0;
        for (int i=0; i<arr.size(); i++) {
            if (arr.contains(arr.get(i) + k)) {
                numPairs++;
            }
            if (arr.contains(arr.get(i) - k)) {
                numPairs++;
            }
            arr.remove(i);
            i--;
        }*/
        Collections.sort(arr);
        int numPairs = 0;

        for (int i=0; i<arr.size(); i++) {

            if (binarySearch(arr, arr.get(i) + k)) {
                numPairs++;
            }
            if (binarySearch(arr, arr.get(i) - k)) {
                numPairs++;
            }
            arr.remove(i);
            i--;
        }
        return numPairs;
    }

    private static boolean binarySearch(List<Integer> arr, Integer data) {
        int first = 0;
        int last = arr.size() - 1;

        while (first <= last) {
            int mid = (first + last) / 2;
            Integer currentVal = arr.get(mid);
            if (currentVal.equals(data)) {
                return true;
            } else if (currentVal.compareTo(data) == 1) {
                last = mid-1;
            } else {
                first = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1); arr.add(2); arr.add(3); arr.add(4);
        System.out.println(pairs(1, arr));
    }

}
