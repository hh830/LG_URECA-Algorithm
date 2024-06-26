package _240626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 자료구조 1. 배열
// 자료구조 2. ArrayList, Queue
// Queue: 살아있는 사람만 관리, Queue에서 꺼내서 K 번째면 죽이고, 그렇지 않으면 다시 넣는다.
public class 요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();

        // 번호를 채우고
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int temp = queue.remove();
                queue.add(temp);
            }

            if (queue.size() == 1)
                stringBuilder.append(queue.remove());
            else
                stringBuilder.append(queue.remove()).append(", ");
        }

        System.out.println("<" + stringBuilder + ">");
    }

}

