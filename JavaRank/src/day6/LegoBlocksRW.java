package day6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LegoBlocksRW {
    private static final int MOD = 1000000007; // (int)Math.pow(10, 9) + 7;

    public static List<Integer> tetranacci(int m) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
        if (m <= 4) {
            return arr.subList(0, m);
        }
        else {
            for (int i = 4; i < m; i++) {
                int sum = 0;
                for (int j = i - 4; j < i; j++) {
                    sum += arr.get(j);
                }
                arr.add(sum % MOD);
            }
        }
        return arr;
    }

    /*public static int tetranaccI(int n) {
        // function specific to this problem as 0s in sequence not needed
        int f1 = 0; int f2 = 0; int f3 = 1; int f4 = 1;
        int tetra = 1; // returns 1 if n<2
        for (int i=2; i<n+1; i++) {
            tetra = f1 + f2 + f3 + f4;
            f1 = f2; f2 = f3; f3 = f4; f4 = tetra;
        }
        return tetra;
    }

    public static int tetRa(int n) {
        if (n < 0) { return 0; }
        else if (n == 0) { return 1; }
        else {
            return tetRa(n-1) + tetRa(n-2) + tetRa(n-3) + tetRa(n-4);
        }
    }/*

    /*public static <T> List<List<T>> zip(List<T>... lists) {
        List<List<T>> zipped = new ArrayList<List<T>>();
        for (List<T> list : lists) {
            for (int i = 0, listSize = list.size(); i < listSize; i++) {
                List<T> list2;
                if (i >= zipped.size())
                    zipped.add(list2 = new ArrayList<T>());
                else
                    list2 = zipped.get(i);
                list2.add(list.get(i));
            }
        }
        return zipped;
    }*/

    public static int legoBlocks(int n, int m) {

        List<BigInteger> a = new ArrayList<>();
        for (Integer v : tetranacci(m)) {
            System.out.print(v + " ");
            // a.add((int)Math.pow(v, n) % MOD);
            a.add(BigInteger.valueOf(v).pow(n));
//            a.add( BigInteger.valueOf(v).modPow(BigInteger.valueOf(n), BigInteger.valueOf(MOD)).intValue() );
        }
        System.out.println();
        System.out.println(a);
        List<BigInteger> s = new ArrayList<>(); s.add(BigInteger.valueOf(1));
        int lenA = a.size(); int lenS = 1;

        for (int i=1; i<lenA; i++) {
            BigInteger sum = BigInteger.valueOf(0);
//            Collections.reverse(s);
//            List<List<Integer>> zipped = zip(a.subList(0, i), s);
//            for (List<Integer> list : zipped) {
//                sum += list.get(0) * list.get(1);
//            }
            for (int j=0; j<i; j++) {
                // sum += a.get(j) * s.get(lenS-j-1);
                sum = sum.add(a.get(j).multiply(s.get(lenS-j-1)));
//                System.out.print(sum + " ");
            }
//            Collections.reverse(s);
            // s.add((a.get(i) - sum) % MOD);
            BigInteger result = a.get(i).subtract(sum);
            s.add( result.mod( BigInteger.valueOf(MOD) ) );
            lenS++;
//            System.out.println(s);
        }
        return s.get(lenS-1).intValue();

//        int allWalls = (int)Math.pow(tetranaccI(m), n) % MOD;
//        int dodgyWalls = 0;
//        for (int i=1; i<m; i++) {
//            dodgyWalls += s.get(s.size()-i) * tetranaccI(m-i);
//        }
//        return allWalls - dodgyWalls;
        //sum{X=1..{W-1}}(S(X,H)*A(W-X,H))
    }


    public static void main(String[] args) {
        int n = 8; // height
        int m = 6; // width
        System.out.println(legoBlocks(n, m));
//        4
//        2 2
//        3 2
//        2 3
//        4 4

//        System.out.println(tetranacci(6));
//        System.out.println(tetranaccI(11)-52);
//        System.out.println(tetRa(6));
        /*
        all possible walls for n = 1
        m = 0 -> 1

        m = 1 -> 1
        -
        m = 2 -> 2
        - -, --
        m = 3 -> 4
        - - -, -- -, - --, ---
        m = 4 -> 8
        - - - -, -- - -, - - --, - -- -, -- --, --- -, - ---, ----
        0, 0, 0, 1, 1, 2, 4, 8, 15 = Tetranacci sequence
        1+1+2+4 = 8
        1+2+4+8 = 15
         */

        /*
        vertical divisions for n = 1
        m = 2 -> 1
        m = 3 -> 3
        m = 4 -> 7
        m = 5 -> 15
         */
    }
}
