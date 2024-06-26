package _240626;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class bfsdfs_list {
    // 정점 1, 2, 3, 4
    // 연결 정보
    // 1 -> 2, 4
    // 2 -> 3, 4
    // 3 -> 2
    // 4 -> 3

     static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit; // 중복 방문 방지
    static boolean[] visit1;
    public static void main(String[] args) {
        // 자료구조
        for(int i=0;i<5;i++){ // 0 dummy List
            adjList.add(new ArrayList<Integer>()); // 0, 1, 2, 3, 4 ArrayList 객체가 만들어짐
        }

        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(2).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(2);
        adjList.get(4).add(3);

        visit = new boolean[5];
        visit1 = new boolean[5];

        bfs(1);
        System.out.println("");
        dfs(1);
    }

    static void bfs(int n){ // n: 시작 정점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visit[n] = true;

        while(!queue.isEmpty()){
            // 정점을 꺼낸다.
            int v = queue.poll();
            // 필요한 처리를 수행한다.
            System.out.print(v + " -> ");

            // 계속 방문을 이어간다.
            List<Integer> list = adjList.get(v);
            for(Integer i : list){
                if(visit[i]){
                    continue;
                }
                queue.offer(i);
                visit[i] = true;
            }
        }
    }

    // stack 대신 동일한 효과 더 편한 재귀 호출을 이용
    static void dfs(int n){ // n: 시작 정점
        visit1[n] = true;

        System.out.print(n + " -> ");

        // 계속 방문을 이어간다.
        List<Integer> list = adjList.get(n);
        for(Integer i : list){
            if(visit1[i]){
                continue;
            }
            dfs(i);
        }
    }
}
