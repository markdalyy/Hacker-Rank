package day4;

public class SuperDigit {
    public static void main(String[] args) {
        String n = "9875";
        int k = 4;
        System.out.println(superDigit(n, k));
    }
    /*public static int superDigit(String n, int k) {
        // Write your code here
        int superSum = 0;
        StringBuilder p = new StringBuilder(n);
        for (int time = 1; time < k; time++) {
            p.append(n);
        }
        System.out.println(p);
        for (int i = 0; i < p.length(); i++) {
            System.out.print(p.charAt(i));
            superSum += Character.getNumericValue(p.charAt(i));
        }
        System.out.println();
        return superSum;
    }*/

    public static int superDigit(String n, int k) {
        if ((n.length() <= 1) && (k == 1)) {
            return Integer.parseInt(n);
        }
        int superSum = 0;
        for (int i = 0; i < n.length(); i++) {
            superSum += Character.getNumericValue(n.charAt(i));
        }
        superSum *= k;
        String next = String.valueOf(superSum);
        return superDigit(next, 1);
    }
}
