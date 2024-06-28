package _240626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 알고스팟 {
    static int matrix[][], visit[][];
    static int cnt = 0, N, M;
    static int dx[] = { 1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[N+1][M+1];
        visit = new int[N+1][M+1];

        for(int i=1;i<=M;i++){
            String str = bufferedReader.readLine();
            for(int j=1;j<=N;j++){
                matrix[j][i] = Integer.parseInt(str.split("")[j-1]);
            }
        }
        bfs(1, 1);
        System.out.println(cnt);
    }

    static void bfs(int x, int y){
        PriorityQueue<Node> queue = new PriorityQueue<>((p1, p2) -> p1.cnt - p2.cnt);
        queue.offer(new Node(x, y, 0));
        visit[x][y] = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            // 도착점
            if(node.x == N && node.y == M){
                cnt = node.cnt;
                break;
            }

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx <= 0 || ny <= 0 || nx > N || ny > M) continue;

                // 벽이 없는 곳
                if(matrix[nx][ny] == 0 && visit[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny, node.cnt));
                    visit[nx][ny] = 1;
                }

                // 벽이 있는 곳
                if(matrix[nx][ny] == 1 && visit[nx][ny] == 0){
                    queue.offer(new Node(nx, ny, node.cnt + 1));
                    visit[nx][ny] = 1;
                }
            }
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
