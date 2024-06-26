package _240626;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 큐3 {
    public static void main(String[] args) {
        // user defined class
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(3, 0, 1));
        queue.offer(new Node(1,2,3));
        queue.offer(new Node(7, 4, -3));
        queue.offer(new Node(6,5,7));

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        // 배열 new int 붙여주기
        Queue<int[]> queue1 = new ArrayDeque<>();
        queue1.offer(new int[]{3, 0, 1});
        queue1.offer(new int[]{1, 2, 3});
        queue1.offer(new int[]{7, 4, -3});
        queue1.offer(new int[]{6,5,7});

        while(!queue.isEmpty()){
            System.out.println(Arrays.toString(queue1.poll()));
        }
    }

    static class Node{
        int y, x, c;
        Node(int y, int x, int c){
            this.y=y;
            this.x=x;
            this.c=c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", c=" + c +
                    '}';
        }
    }
}
