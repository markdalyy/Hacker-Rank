package day6;

import java.util.List;
import java.util.PriorityQueue;

public class SweetCookies {

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : A) pq.add(i);
        int operations = 0;

        while (pq.peek() < k && pq.size() >= 2){
            int smaller = pq.remove();
            int small = pq.remove();
            int mix = smaller + (small * 2);
            pq.add(mix);
            operations++;
        }

        return (pq.peek() >= k) ? operations : -1;

    }

}
