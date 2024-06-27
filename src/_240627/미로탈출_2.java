package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 리팩토링
// Node cnt 추가
public class 미로탈출_2 {
    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static int n, m, ans;
    public static int[][] graph = new int[201][201];
    public static boolean[][] visit = new boolean[201][201];


    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static void bfs() {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visit[0][0] = true;
        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt; // x, y 까지 오는데 cnt 만큼 걸렸다

            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 찾기 공간을 벗어난 경우, 벽인 경우, 방문한 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || graph[nx][ny] == 0) continue;

                // 이거 안쓰면 N-1 M-1 도달해도 모든 곳을 순회해야 함
                // 안써도 답은 나올텐데 써야 좋음
                if(nx == n-1 && ny == m-1) {
                    ans = node.cnt + 1;
                    return;
                }
                visit[nx][ny] = true;
                q.offer(new Node(nx, ny, cnt + 1));

            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N, M을 공백을 기준으로 구분하여 입력 받기
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n][m];
        visit = new boolean[n][m];

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        bfs();
        System.out.println(ans);
    }
}

/*
5 6
101010
111111
000001
111111
111111
10
 */