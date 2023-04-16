package day5;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        MyQueue<Integer> queue = new MyQueue<Integer>();
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (type == 2) {
                queue.dequeue();
            } else {
                System.out.println(queue.peek());
            }
        }
    }
}

class MyQueue<T> {
    Stack<T> leftStack = new Stack<T>();
    Stack<T> rightStack = new Stack<T>();

    void enqueue(T item) {
        leftStack.push(item);
    }

    T dequeue() {
        transferIfNeeded();
        return rightStack.pop();
    }

    T peek() {
        transferIfNeeded();
        return rightStack.peek();
    }

    void transferIfNeeded() {
        if (rightStack.empty()) {
            while (!leftStack.empty()) {
                rightStack.push(leftStack.pop());
            }
        }
    }
}
