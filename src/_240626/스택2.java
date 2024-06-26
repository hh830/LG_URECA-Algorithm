package _240626;

import java.util.ArrayDeque;
import java.util.Deque;

// stack 대신 ArrayDeque
public class 스택2 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(5);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty()); // q.Empty 쓰면 안됨.
    }
}
