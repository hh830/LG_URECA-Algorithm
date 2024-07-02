package _240701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_파티 {
    static class Node{
        int v, c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
    static List<List<Node>> arrayList = new ArrayList<>();
    static List<List<Node>> r_arrayList = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.v - n2.v);
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        X = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0;i<=N;i++){
            arrayList.add(new ArrayList<>());
            r_arrayList.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.get(v1).add(new Node(v2, c));
            r_arrayList.get(v2).add(new Node(v1, c));
        }

        int d1[] = dijkstra(arrayList);
        int d2[] = dijkstra(r_arrayList);
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            max = Math.max(max, d1[i] + d2[i]);
        }

        System.out.println(max);
    }
    static int[] dijkstra(List<List<Node>> arrayList){
        int cost[] = new int[N+1];
        boolean visit[] = new boolean[N+1];
        priorityQueue.offer(new Node(X, 0));
        Arrays.fill(cost, INF);
        cost[X] = 0;

        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            if(visit[node.v]) continue;

            for(Node n : arrayList.get(node.v)){
                if(visit[node.v]) continue;

                if(cost[n.v] > node.c + n.c)
                {
                    cost[n.v] = node.c + n.c;
                    priorityQueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
        return cost;
    }
}
