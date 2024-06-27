package _240627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 내 풀이
public class 음료수얼려먹기 {
    static int arr[][];
    static boolean visit[][];
    static int dx[] = { -1, 1, 0, 0};
    static int dy[] = { 0, 0, -1, 1};
    static int cnt = 0, count = 0, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 0 && !visit[i][j]) {
                    dfs(i, j);
                    cnt++;
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(cnt + " " + count);
    }

    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(arr[nx][ny] == 0 && !visit[nx][ny]){
                dfs(nx, ny);
            }
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){
            int p[] = queue.poll();
            for(int i=0;i<4;i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 0 && !visit[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
