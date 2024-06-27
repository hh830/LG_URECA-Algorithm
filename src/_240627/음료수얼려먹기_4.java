package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수얼려먹기_4 {
    public static int n, m, result = 0;
    public static char[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};
    static Queue<Node> queue = new ArrayDeque<>();

    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static void bfs(int x, int y) {
        graph[x][y] = '1';
        queue.offer(new Node(x,y));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d=0;d<4;d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || graph[nx][ny] != '0'){
                    continue;
                }
                graph[nx][ny] = '1';
                queue.offer(new Node(nx, ny));
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        graph = new char[n][m];

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            graph[i] = bufferedReader.readLine().toCharArray();
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 BFS 수행
                if (graph[i][j] == '0') {
                    bfs(i, j);
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력
    }
}
/*
4 5
0 0 1 1 0
0 0 0 1 1
1 1 1 1 1
0 0 0 0 0

3
 */