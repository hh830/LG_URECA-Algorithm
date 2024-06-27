package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// 내 풀이
public class 미로탈출 {
    static int arr[][];
    static boolean visit[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int N, M, cnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            str = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(cnt);
    }

    static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y, cnt));
        visit[x][y]= true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || visit[nx][ny]) continue;

                // 이거 안쓰면 N-1 M-1 도달해도 모든 곳을 순회해야 함
                // 안써도 답은 나올텐데 써야 좋음
                if(nx == N-1 && ny == M-1) {
                    cnt = node.cnt + 1;
                    return;
                }
                visit[nx][ny] = true;
                queue.offer(new Node(nx, ny, node.cnt+1));
            }
            cnt = node.cnt;
        }
    }

    static class Node{
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
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