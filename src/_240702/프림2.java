package _240702;

// MST
// 정점 중심 - 인접리스트, 인접행렬
// 시작점을 우선순위 큐에 넣고 시작
// 큐에 담긴 (고려하는) 정점 중 가장 비용이 적은 정점을 꺼내서
// 갈 수 있는 새로운 정점을 다시 우선순위 큐에 넣고 이 과정을 반복한다.
// 비용이 가장 작은 정점 선택이 V 개 선택

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그래프 : 인접행렬
// 우선순위 큐
// visit
// cycle 체크는 필요없음 - 간선이 아니라서
public class 프림2 {
    static int V, E, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        V = Integer.parseInt(bufferedReader.readLine());
        E = Integer.parseInt(bufferedReader.readLine());

        matrix = new int[V][V];
        visit = new boolean[V];

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int v1 = Integer.parseInt(stringTokenizer.nextToken());
                int v2 = Integer.parseInt(stringTokenizer.nextToken());
                int c = Integer.parseInt(stringTokenizer.nextToken());

                matrix[v1][v2] = c;
                matrix[v2][v1] = c; // 양방향으로 넣어줘야 함
            }
        }

        // 프림
        // #1
        //priorityQueue.offer(new Vertex(0, 0));
        //int cnt = 0;

        // #2
        visit[0] = true;
        for(int i=0;i<V;i++){
            if(matrix[0][i] == 0) continue;
            priorityQueue.offer(new Vertex(i, matrix[0][i]));
        }
        int cnt = 1;

        while(!priorityQueue.isEmpty()){
            Vertex vertex = priorityQueue.poll();
            if(visit[vertex.v] ) continue;

            // MST를 구성하는 정점이 선택됨
            visit[vertex.v] = true;
            result += vertex.c;
            cnt++;
            if(cnt == V) break;

            // 꺼낸 정점으로부터 갈 수 있고 아직 방문하지 않은 정점이 있으면 우선순위 큐에 추가
            for(int i=0;i<V;i++){
                if(matrix[vertex.v][i] == 0 || visit[i] ) continue;
                priorityQueue.offer(new Vertex(i, matrix[vertex.v][i])); // 정점번호 i, 비용 vertex.v -> i
                // 다익스트라에서는 시작 정점에서의 거리가 들어가지만 프림은 matrix[vertex.v][i]가 들어감
            }
        }

        System.out.println(result);
    }

    static class Vertex{
        int v, c;
        Vertex(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
}

/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0
 */
