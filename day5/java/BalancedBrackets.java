package day5;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String s = "{{[[(())]]}}";
        /*
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if ( current=='}' && stack.peek() == '{' ) {
                stack.pop();
            } else if ( current==')' && stack.peek() == '(' ) {
                stack.pop();
            } else if ( current==']' && stack.peek() == '[' ) {
                stack.pop();
            } else {
                stack.push(current);
            }
            //System.out.println(stack);
        }*/
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else {
                if( stack.isEmpty() || c != stack.peek()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
