package _240705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_게리맨더링 {
    static int people[], num[];
    static boolean visit[][];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        people = new int[N+1];
        num = new int[N+1];
        visit = new boolean[N+1][N+1];

        for(int i=1;i<=N;i++){
            people[i] = Integer.parseInt(stringTokenizer.nextToken());
            graph.add(new ArrayList<>());
        }

        for(int i=1;i<=N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
            for(int j=0;j<num[i];j++){
                graph.get(i).add(j);
            }
        }
        dfs(1, 1);

    }


    // 노드 번호와 제외할 노드 번호
    static void dfs(int node, int exception){
        visit[node][exception] = true;
        List <Integer> list = graph.get(node);
        for(Integer i : list){
            if(visit[i][exception]) continue;
            dfs(i, exception);
        }
    }
}
