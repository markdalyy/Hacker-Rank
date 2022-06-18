package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumBribes {
    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>(Arrays.asList(2, 1, 5, 3, 4));

        int totalBribes = 0;
        for (int i = q.size()-1; i >= 0; i--) {
            int elem = i + 1;
            if (q.get(i) != elem) {
                if ((i - 1 >= 0) && (q.get(i - 1) == elem)) {
                    totalBribes++;
                    //Integer temp = q.get(i - 1);
                    //q.set(i - 1, q.get(i));
                    //q.set(i, temp);
                    swap(q, i-1, i);
                } else if ((i - 2 >= 0) && (q.get(i - 2) == elem)) {
                    totalBribes += 2;
                    //Integer temp = q.get(i - 2);
                    //q.set(i - 2, q.get(i - 1));
                    //q.set(i - 1, temp);
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                    //temp = q.get(i - 1);
                    //q.set(i - 1, q.get(i));
                    //q.set(i, temp);

                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(totalBribes);
    }

    static void swap(List<Integer> q, int index1, int index2){
        int temp = q.get(index1);
        q.set(index1, q.get(index2));
        q.set(index2, temp);
    }


}
