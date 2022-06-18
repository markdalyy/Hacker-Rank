package day3;

public class PalindromeIndex {

    public static void main(String[] args) {
        String s1 = "aaab";
        String s2 = "baa";
        String s3 = "aaa";
        String s4 = "abccccc";
        System.out.println(palindromeIndex(s1));
        System.out.println(palindromeIndex(s2));
        System.out.println(palindromeIndex(s3));
        System.out.println(palindromeIndex(s4));

    }

    public static int palindromeIndex(String s) {
        // Write your code here
        /*
        int len = s.length();
        int mid = len/2;

        String part1;
        if (len % 2 != 0) {
            part1 = s.substring(0, mid+1);
        } else {
            part1 = s.substring(0, mid);
        }
        String part2 = s.substring(mid, len);

        if (part1.equals(part2)) {
            return -1;
        }*/
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if ( isPalindrome(s, i + 1, j) ) {
                    return i;
                } else {
                    //either return j or -1 (no solution)
                    StringBuilder sb = new StringBuilder(s);
                    sb.deleteCharAt(j);
                    s = sb.toString();
                    return isPalindrome(s, i, j-1) ? j : -1;
                }
            }
        }
        return -1; // is palindrome
    }

    static boolean isPalindrome(String s, int beginIndex, int endIndex) {
        for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
