package day1;

public class PlusMinus {
    public static void main(String[] args) {
        int [] arr = {-4, 3, -9, 0, 4, 1};
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;

        for(int elem : arr) {
            if(elem > 0) {
                posCount++;
            } else if(elem < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        int total = posCount + negCount + zeroCount;

        System.out.printf("%.6f \n", (double)posCount/total);
        System.out.printf("%.6f \n", (double)negCount/total);
        System.out.printf("%.6f \n", (double)zeroCount/total);
    }
}
