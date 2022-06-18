package day3;

public class CaesarCipher {

    public static void main(String[] args) {
        String s = "There's-Mark-oh-hi-Mark-z";
        s = "a";
        int k = 52;
        System.out.println(caesarCipher(s, k));
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        // A-Z = 65-90
        // a-z = 97-122
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (Character.isLetter(letter)) {
                int asciiVal = (int)letter + k % 26;

                if ( Character.isLowerCase(letter) && (asciiVal > (int)'z') ) {
                    asciiVal = asciiVal % (int)'z' + (int)'a' - 1;
                } else if ( Character.isUpperCase(letter) && (asciiVal > (int)'Z') ) {
                    asciiVal = asciiVal % (int)'Z' + (int)'A' - 1;
                }
                letters[i] = (char)asciiVal;
            }
        }
        s = String.valueOf(letters);
        return s;
    }

}
