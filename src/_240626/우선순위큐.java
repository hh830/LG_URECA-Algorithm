package _240626;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// PriorityQueue ( 우선순위 - 정렬된 결과를 추출, heap으로 이루어짐)
// 원점에서 가장 가까운, 비용이 가장 싼 것부터, 등의 문제에서 사용 가능
public class 우선순위큐 {
    public static void main(String[] args) {
        //Integer
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.offer(7);
        priorityQueue.offer(5);
        priorityQueue.offer(9);

//        while(!priorityQueue.isEmpty()){ // 집어넣은 순서와 무관하게 가장 작은애부터 나옴
//            System.out.println(priorityQueue.poll());
//        }

        // String
        PriorityQueue<String> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer("z3");
        priorityQueue1.offer("a2");
        priorityQueue1.offer("x7");
        priorityQueue1.offer("d5");
        priorityQueue1.offer("s9");

        while(!priorityQueue1.isEmpty()){ // 집어넣은 순서와 무관하게 가장 작은애부터 나옴
            System.out.println(priorityQueue1.poll());
        }

        for(Integer i : priorityQueue){ // 입력 순 x
            System.out.println(i);
        }

        PriorityQueue<Node> priorityQueue2 = new PriorityQueue<>();
        priorityQueue2.offer(new Node(3,5,2));
        priorityQueue2.offer(new Node(7,1,4));
        priorityQueue2.offer(new Node(5,2,9));
        priorityQueue2.offer(new Node(1,1,5));

        while(!priorityQueue2.isEmpty()){
            System.out.println(priorityQueue2.poll());
        }

        // 람다
        PriorityQueue<Node> priorityQueue3 = new PriorityQueue<>( (n1, n2) -> n1.y - n2.y );
        priorityQueue3.offer(new Node(3,5,2));
        priorityQueue3.offer(new Node(7,1,4));
        priorityQueue3.offer(new Node(5,2,9));
        priorityQueue3.offer(new Node(1,1,5));

        while(!priorityQueue3.isEmpty()){
            System.out.println(priorityQueue3.poll());
        }

        // 배열
        PriorityQueue<int[]> priorityQueue4 = new PriorityQueue<>( (a1, a2) -> a1[0] - a2[0]);
        priorityQueue4.offer(new int[] { 3, 5, 2 });
        priorityQueue4.offer(new int[] { 7, 1, 4 });
        priorityQueue4.offer(new int[] { 5, 2, 9 });
        priorityQueue4.offer(new int[] { 1, 1, 5 });

        while(!priorityQueue4.isEmpty()){
            System.out.println(Arrays.toString(priorityQueue4.poll()));
        }

    }
    static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node o) {
            return this.y == o.y ? this.x - o.x : this.y - o.y; // y로 정렬, 같으면 x로 정렬
        }
    }
}
