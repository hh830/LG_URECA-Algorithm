package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기_2 {
    public static int n, m, result = 0;
    public static char[][] graph;

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static void dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (y<0 || x<0 || x>=n || y >= m) {
            return;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == '0') {
            // 해당 노드 방문 처리
            graph[x][y] = '1';
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
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
                // 현재 위치에서 DFS 수행
                if (graph[i][j] == '0') {
                    dfs(i, j);
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
 */