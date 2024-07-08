package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_빵집 {
    static char arr[][];
    static boolean visit[][];
    static int R, C, sum = 0;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        arr = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            flag = false;
            dfs(0, i);
        }
        System.out.println(sum);
    }

    static void dfs(int x, int y) {
        visit[y][x] = true;

        if (x == C - 1) {
            flag = true;
            sum++;
            return;
        }


        if (check(x + 1, y - 1) && arr[y - 1][x + 1]=='.') {
            // 오른쪽 대각선 위 갈 수 있음
            dfs(x + 1, y - 1);
            if (flag) {
                return;
            }
        }
        if (check(x + 1, y) && arr[y][x + 1]=='.') {
            // 오른쪽 갈 수 있음
            dfs(x + 1, y);
            if (flag) return;
        }
        if (check(x + 1, y + 1) && arr[y + 1][x + 1]=='.') {
            // 오른족 아래 갈 수 있음
            dfs(x + 1, y + 1);
            if (flag) return;
        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= C || y >= R || visit[y][x]) {
            return false;
        }
        return true;
    }
}
