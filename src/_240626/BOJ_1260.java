package _240626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_1260 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static boolean[] visit1;
    static int N, M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken()); // 정점
        M = Integer.parseInt(stringTokenizer.nextToken()); // 간선
        int V = Integer.parseInt(stringTokenizer.nextToken()); // 탐색 시작 번호

        visit = new boolean[N+1];
        visit1 = new boolean[N+1];

        for(int i=0;i<=N;i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=0;i<=N;i++){
            Collections.sort(list.get(i));
        }

        dfs(V);
        stringBuilder.append("\n");
        stringBuilder.append(V).append(" ");
        bfs(V);
        System.out.println(stringBuilder);
    }

    static void dfs(int node){
        visit[node] = true;
        stringBuilder.append(node).append(" ");
        List<Integer> nodelist = list.get(node);
        for(Integer i : nodelist){
            if(visit[i]) continue;
            dfs(i);
        }
    }

    static void bfs(int node){
        Queue<Integer> queue = new ArrayDeque<>();
        visit1[node] = true;
        queue.offer(node);

        while(!queue.isEmpty()){
            int num = queue.poll();
            List<Integer> nodeList = list.get(num);
            for(Integer i : nodeList){
                if(visit1[i]) continue;
                stringBuilder.append(i).append(" ");

                visit1[i] = true;
                queue.offer(i);
            }
        }
    }
}
