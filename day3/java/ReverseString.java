package day3;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Hello";
        //StringBuilder sb = new StringBuilder();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
//        int len = s.length();
//        for (int i = len-1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
        String rev = sb.toString();
        System.out.println(rev);
    }
}
