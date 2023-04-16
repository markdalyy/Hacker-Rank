package day6;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        Scanner scanner = new Scanner(System.in);
        long Q = scanner.nextInt();
        int type;

        String s = "";
        Stack<String> history = new Stack<String>();
        history.push(s);

        while(Q-- > 0) {
            type = scanner.nextInt();
            switch (type) {
                case 1 -> {
                    s += scanner.next();
                    history.push(s);
                }
                case 2 -> {
                    s = s.substring(0, s.length() - scanner.nextInt());
                    history.push(s);
                }
                case 3 -> System.out.println(s.charAt(scanner.nextInt() - 1));
                case 4 -> {
                    history.pop();
                    s = history.peek();
                    //assumes stack is not empty on peek
                }
            }
        }
        scanner.close();
    }

}
