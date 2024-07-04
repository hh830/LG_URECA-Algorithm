package _240702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_최소스패닝트리 {
    static int[] parent;
    static int v, e, result;
    static Edge[] edges;

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
        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[v+1];
        edges = new Edge[e];

        for(int i=0;i<e;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            edges[i] = new Edge(v1, v2, c);
        }

        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

        makeSet();

        int cnt = 0;
        for(Edge edge:edges){
            if(union(edge.v1, edge.v2)){
                result += edge.c;
                cnt++;
                if(cnt == v-1) break;
            }
        }
        System.out.println(result);
    }

    private static void makeSet() {
        for(int i=0;i<v;i++){
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
