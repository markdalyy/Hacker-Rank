package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findMedian {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        System.out.println(findMyMedian(arr));
    }

    public static int findMyMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get(arr.size()/2);
    }
}
