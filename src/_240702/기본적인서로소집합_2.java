package _240702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정점과 간선 정보를 사용해 집합 소속 관계를 따지려 함 -> 1차원 배열로 따짐
// path compression
public class 기본적인서로소집합_2 {
    static int v, e; // 정점, 간선
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        v = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());

        parent = new int[v + 1]; // 1번 정점부터

        // parent[3] = 4라는 의미: 3 정점은 4가 부모인 집합에 포함되어 있다
        makeSet(); // 자료구조를 집합관계로 만들어라 // 각 정점은 모두 서로소인 상태가 됨

        // 간선을 통해 연결 하는 과정에서 cycle이 발생하는지 판단
        boolean cycle = false;
        for(int i=0;i<e;i++){ // 간선
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            if(findSet(x) == findSet(y)) {
                System.out.println(x+", "+y);
                cycle = true;
                break;
            } else{
                union(x, y);
            }
        }
        if(cycle) {
            System.out.println("사이클 발생");
        } else{
            System.out.println("사이클 발생 x");
        }

        // 인덱스
        for(int i=1;i<=v;i++){
            System.out.print(i+ " ");
        }
        System.out.println();
        /*
        // 부모 집합
        for(int i=1;i<=v;i++){
            System.out.print(findSet(i)+ " ");
        }
        System.out.println();
*/
        // parent 배열
        for(int i=1;i<=v;i++){
            System.out.print(parent[i]+ " ");
        }
        System.out.println();
    }

    static void makeSet(){
        for(int i=1;i<=v;i++){
            parent[i] = i;
        }
    }

    // 하나의 집합이 길게 이어질 경우 findSet을 많이 써야되서 비효율적 -> 일렬로  나열하는 것보다 부모만 알면 됨
    static int findSet(int x){ // 정점의 부모를 찾는 기능 // 어떤 정점의 부모가 누군지를 알아야 함
        if(parent[x] == x) return x; // 자기 자신과 같으면 부모임 // 독립된 집합의 대표
        // 리턴 값이 x의 부모가 됨

        return parent[x] = findSet(parent[x]);
    }

    static void union(int x, int y){ // 두 부모의 수 중 작은 수를 부모로
        // 두 정점을 하나의 집합으로 만듬
        int px = findSet(x); // x의 대표 부모
        int py = findSet(y); // y의 대표 부모
        if(px < py) parent[py] = px;
        else parent[px] = py; // 이미 같은 집합에 대한 처리 포함

    }
}
/*
1번 정점은 어느 집합에 들어가 있는지 ...
1차원 배열 사용
3 3
1 2
1 3
2 3


사이클 확인
7 9
1 2
1 5
5 6
2 3
2 6
3 4
6 4
6 7
4 7

-- 2 6 맨 뒤로
7 9
1 2
1 5
5 6
2 3
3 4
6 4
6 7
4 7
2 6
-- 2 6 6 4 제거
7 7
1 2
1 5
5 6
2 3
3 4
6 7
4 7
-- 4 7 제거
7 6
1 2
1 5
5 6
2 3
3 4
6 7
*/
