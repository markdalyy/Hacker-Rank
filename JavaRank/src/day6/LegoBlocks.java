package day6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LegoBlocks {

    private static final BigInteger MOD = BigInteger.valueOf(1000000007);
    private static final BigInteger ZERO = BigInteger.valueOf(0);

    public static List<BigInteger> tetranacci(int m) {
        List<BigInteger> arr = new ArrayList<>();
        arr.add(BigInteger.valueOf(1)); arr.add(BigInteger.valueOf(2));
        arr.add(BigInteger.valueOf(4)); arr.add(BigInteger.valueOf(8));

        if (m <= 4) {
            return arr.subList(0, m);
        }

        for (int i = 4; i < m; i++) {
            BigInteger sum = ZERO;
            for (int j = i - 4; j < i; j++) {
                sum = sum.add(arr.get(j));
            }
            arr.add(sum.mod(MOD));
        }
        return arr;
    }

    public static int legoBlocks(int n, int m) {
        // Compute all possible wall combinations
        List<BigInteger> allWalls = new ArrayList<>();
        for (BigInteger v : tetranacci(m)) {
            allWalls.add( v.modPow(BigInteger.valueOf(n), MOD) );
        }

        // Find number of unstable wall configurations
        List<BigInteger> solidWalls = new ArrayList<>(); solidWalls.add(BigInteger.valueOf(1)); int lenSolid = 1;

        for (int i = 1; i < m; i++) {
            BigInteger sum = ZERO;
            for (int j = 0; j < i; j++) {
                sum = sum.add( ( allWalls.get(j).multiply(solidWalls.get(lenSolid-j-1)) ).mod(MOD) );
            }
            solidWalls.add(( allWalls.get(i).subtract(sum) ).mod(MOD));
            lenSolid++;
        }

        // return number of solid wall combinations
        return solidWalls.get(lenSolid-1).intValue();
    }

    public static void main(String[] args) {
        int n = 8; // height
        int m = 6; // width
        System.out.println(legoBlocks(n, m));
//        Scanner scanner = new Scanner(System.in);
//        int q = scanner.nextInt();
//        while (q-- > 0) {
//            n = scanner.nextInt();
//            m = scanner.nextInt();
//            System.out.println(legoBlocks(n, m));
//        }
    }
}
