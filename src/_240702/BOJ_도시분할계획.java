package _240702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_도시분할계획 {
    static Edge[] edges;
    static int N, M, result;
    static int parent[];
    static class Edge{
        int v1, v2, c;
        Edge(int v1, int v2, int c){
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[N+1];
        edges = new Edge[M];

        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());
            edges[i] = new Edge(A, B, C);
        }

        Arrays.sort(edges, (n1, n2) -> n1.c - n2.c);
        makeSet();

        int cnt = 0;
        int max = 0;
        for(Edge edge : edges){
            if(union(edge.v1, edge.v2)){
                result += edge.c;
                max = Math.max(max, edge.c);
                cnt++;
            }
            if(cnt == N-1){
                break;
            }
        }
        System.out.println(result - max);
    }

    static void makeSet(){
        for(int i=0;i<N;i++){
            parent[i] = i;
        }
    }

    static int findSet(int x){
        if(parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);

        if(px == py) return false;

        if(px < py) parent[py] = px;
        else parent[px] = py;

        return true;
    }
}
