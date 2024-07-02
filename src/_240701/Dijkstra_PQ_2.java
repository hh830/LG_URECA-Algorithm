package _240701; // 인접 리스트

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 그래프 자료구조(인접행렬, 인접리스트)
// 비용관리 배열(시작점으로부터 각 정점까지의 최소비용(최단거리)
// 고려하는 큐에 담긴 정점 중 시작점에서부터 최소 비용의 정즘을 찾는 우선순위 큐
// 최소 비용으로 고려했던 정점 관리 visit
// 우선순위 큐에 담을 Vertex(Node) 클래스 (정점번호 , 시작점으로부터의 비용)
public class Dijkstra_PQ_2 {
    static class Node{
        int v; // 정점 번호

        // 인접리스트에 Node를 사용할 경우: 인접리스트 정점 ~> v 정점까지의 비용(거리)
        // 우선순위큐에 Node 를 사용할 경우 : 시작 정점으로부터의 최소 비용(거리)
        int c;

        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }

    static int V, E, start, end;
    static List<List<Node>> adjList = new ArrayList<>(); // 한 정점에서 다른 정점으로 가는 비용, 0은 연결x
    static int[] cost; // 시작점으로부터 각 정점까지의 최소비용
    static boolean[] visit;
    static final int INF = Integer.MAX_VALUE; // cost 배열 초기화
    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(bufferedReader.readLine());
        E = Integer.parseInt(bufferedReader.readLine());

        start = 0;
        end = V - 1;

        cost = new int[V];
        visit = new boolean[V];

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        // 입력 E개 -> 인접리스트 구성
        for(int i=0;i<V;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            adjList.get(v1).add(new Node(v2, c)); // v1 정점에서 갈 수 있는 다른 정점 정보를 가져와 v2, c 넣기
        }

        // 비용 테이블 충분히 큰 값으로 초기화
        Arrays.fill(cost, INF);

        // 다익스트라
        cost[start] = 0;
        priorityQueue.offer(new Node(start, 0)); // 시작 정점을 pq에 넣고 다익스트라 진행

        while(!priorityQueue.isEmpty()){ // 전체를 모두 끝내면 모든 정점에 대한 최단 경로(최소비용)이 완성됨
            Node node = priorityQueue.poll();
            if(visit[node.v]) continue; // 이미 방문한 정점 스킵
            visit[node.v] = true;

            // 모든 정점이 아니라 목표하는 정점만 따질 경우
            if(node.v == end) {
                break;
            }

            // 꺼낸 정점으로부터 갈 수 있는 곳 찾기
            for(Node n : adjList.get(node.v)){
                if(visit[n.v]) continue;
                if(cost[n.v] > cost[node.v] + n.c) { // n.c는 리스트에서 꺼낸거,
                    // node.v는 큐에서 뽑은거 cost[node.v] = node.c 같음
                    cost[n.v] = cost[node.v] + n.c; // 최소 비용 갱신 (n.v)
                    priorityQueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
        System.out.println(cost[end]);
    }
}
/* (노드, 목표, 비용)
5
20
0 1 2
0 2 2
0 3 5
0 4 9
1 0 2
1 2 3
1 3 4
1 4 8
2 0 2
2 1 3
2 3 7
2 4 6
3 0 5
3 1 4
3 2 7
3 4 5
4 0 9
4 1 8
4 2 6
4 3 5
==> 8
4
12
0 1 94
0 2 53
0 3 16
1 0 79
1 2 24
1 3 18
2 0 91
2 1 90
2 3 98
3 0 26
3 1 51
3 2 92
==> 16
*/