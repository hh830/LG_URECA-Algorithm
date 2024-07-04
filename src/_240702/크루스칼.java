package _240702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST
// 간선 중심으로 가장 비용이 적은 노드부터 - 간선 리스트
public class 크루스칼 {
    static int[] parent;
    static int v, e, result; // 정점, 간선, MST를 연결했을 때 총 비용
    static Edge[] edges; // 간선 리스트 // 동적으로 만ㄴ들어야되면 arraylist쓰면 됨
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[v]; // 1번 정점부터
        edges = new Edge[e];

        // 입력처리
        for(int i=0;i<e;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        // 크루스칼
        // 간선 정렬 v-1개의 간선이 필요
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

        // 집합 배열 처리
        makeSet();

        // 사이클 관계 따지면서 값이 작은것부터 처리
        int cnt = 0; // v-1개를 만들면 된다. (cycle이 없는)
        for(Edge edge : edges){
            // cycle 체크 -> union을 할지 말지 결정
            if(union(edge.v1, edge.v2)){
                result += edge.c;
                cnt++;
                if(cnt == v-1) break; // 다 선택된 것

            }
        }
        System.out.println(result);
    }

    static void makeSet(){
        for(int i=0;i<v;i++){
            parent[i] = i;
        }
    }

    // 하나의 집합이 길게 이어질 경우 findSet을 많이 써야되서 비효율적 -> 일렬로  나열하는 것보다 부모만 알면 됨
    static int findSet(int x){ // 정점의 부모를 찾는 기능 // 어떤 정점의 부모가 누군지를 알아야 함
        if(parent[x] == x) return x; // 자기 자신과 같으면 부모임 // 독립된 집합의 대표
        // 리턴 값이 x의 부모가 됨

        return parent[x] = findSet(parent[x]);
    }

//    static void union(int x, int y){ // 두 부모의 수 중 작은 수를 부모로
//        // 두 정점을 하나의 집합으로 만듬
//        int px = findSet(x); // x의 대표 부모
//        int py = findSet(y); // y의 대표 부모
//        if(px < py) parent[py] = px;
//        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
//
//    }

    static boolean union(int x, int y){ // 크루스칼 사용 버전 - findSet을 두번 하고 유니온을 할 필요가 없어짐
        // 두 정점을 하나의 집합으로 만듬
        int px = findSet(x); // x의 대표 부모
        int py = findSet(y); // y의 대표 부모

        if(py == px) return false; // 두 부모가 같다. cycle 발생

        if(px < py) parent[py] = px;
        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함
        return true;
    }

    // 간선
    static class Edge{
        int v1, v2, c;
        Edge(int v1, int v2, int c){
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}
/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
==>10
----------------------------------
7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14
==>31
 */