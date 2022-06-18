package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TruckTour {
    public static void main(String[] args) {
        int[][] before = {
                {1, 5},
                {10, 3},
                {3, 4},
                {1, 8},
                {5, 2},
                {3, 4}
        };
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < before.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < before[0].length; j++) {
                list.add(before[i][j]);
            }
            arr.add(list);
        }

        System.out.println(truckTour(arr));
    }
    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int numPumps = petrolpumps.size();
        int pump = 0;
        int capacity = 0;
        for (int i = 0; i < numPumps-1; i++) {
            capacity += petrolpumps.get(i).get(0);
            int distance = petrolpumps.get(i).get(1);
            if (capacity < distance) {
                pump = i+1;
                capacity = 0;
            } else {
                capacity -= distance;
            }
        }
        return pump;
    }
}
