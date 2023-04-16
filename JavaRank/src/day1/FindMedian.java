package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMedian {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(8);
        //arr.add(5);
        arr.add(4);
        arr.add(2);
        System.out.println(findMyMedian(arr));
    }

    public static double findMyMedian(List<Integer> arr) {
        Collections.sort(arr);
        int len = arr.size();
        if(len % 2 != 0) {
            return arr.get(len/2);
        } else {
            return (double)(arr.get(len/2-1) + arr.get(len/2)) / 2;
        }
    }
}
