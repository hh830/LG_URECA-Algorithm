package _240701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class 전보 {

    static class Node{
        int v, c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 도시의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 통로의 개수
        int C = Integer.parseInt(stringTokenizer.nextToken()); // 메세지를 보내고자 하는 도시

        boolean visit[] = new boolean[N+1];
        int cost[] = new int[N+1];
        int count = 0;

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            list.get(v1).add(new Node(v2, c));
        }
        Arrays.fill(cost, INF);

        cost[C] = 0;
        priorityQueue.offer(new Node(C, 0));

        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            if(visit[node.v]) continue;
            visit[node.v] = true;

            for(Node n : list.get(node.v)){
                if(visit[n.v]) continue;

                if(cost[n.v] > node.c + n.c){
                    cost[n.v] = node.c + n.c;
                    priorityQueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }

        int max_cost = 0;
        for(int i=1;i<=N;i++){
            if(cost[i] == INF) continue;
            count++;
            max_cost = Math.max(max_cost, cost[i]);
        }

        // 받은 도시만 계산해야 되서 시작 도시는 뺀다. (-1)
        System.out.println(count-1 + " " + max_cost);

    }
}
