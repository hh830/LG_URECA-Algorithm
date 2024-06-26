package _240625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노 {
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int max = 0, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]);
        M = Integer.parseInt(str.split(" ")[1]);

        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; stringTokenizer.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visit[i][j] = false;

                checkShape(i, j);
            }
        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) { // 4개의 블록 선택됨
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    static void checkShape(int x, int y) {
        int[][] shapes = {
                {0, 1, 0, -1, 1, 0}, // 'ㅜ'
                {0, 1, 0, -1, -1, 0}, // 'ㅗ'
                {1, 0, -1, 0, 0, 1}, // 'ㅏ'
                {1, 0, -1, 0, 0, -1} // 'ㅓ'
        };

        for (int k = 0; k < 4; k++) {
            int sum = arr[x][y];
            boolean valid = true;

            for (int l = 0; l < 3; l++) {
                int nx = x + shapes[k][2 * l];
                int ny = y + shapes[k][2 * l + 1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    valid = false;
                    break;
                }
                sum += arr[nx][ny];
            }

            if (valid) {
                max = Math.max(max, sum);
            }
        }
    }
}
