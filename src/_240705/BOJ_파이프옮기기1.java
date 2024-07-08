package _240705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_파이프옮기기1 {
    static int N, cnt=0;
    static int arr[][];
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        arr = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dfs(2,1,1);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int d){ // d 방향 가로1, 세로2, 대각3

        if(x == N && y == N){
            cnt++;

            return;
        }

        if(d==1){
            // 가로
            if(check(x+1, y)){
                dfs(x+1, y, 1); // 가로에서 가로로
            }
            if(check(x+1, y) && check(x+1, y+1) && check(x, y+1)){
                dfs(x+1, y+1, 3); // 대각선 오른쪽 아래로
            }
        } else if(d==2){
            // 세로
            if(check(x, y+1)){
                dfs(x, y+1, 2); // 세로에서 세로
            }
            if(check(x+1, y) && check(x+1, y+1) && check(x, y+1)){
                dfs(x+1, y+1, 3); // 대각선 오른쪽 아래로
            }
        } else if(d==3){
            // 대각선
            if(check(x+1, y)){
                dfs(x+1, y, 1); // 대각선에서 가로로
            }

            if(check(x, y+1)){
                dfs(x, y+1, 2); // 세로에서 세로
            }

            if(check(x+1, y) && check(x+1, y+1) && check(x, y+1)){
                dfs(x+1, y+1, 3); // 대각선 오른쪽 아래로
            }
        }
    }

    static boolean check(int x, int y){
        if(x <= 0 || y <= 0 || x > N || y > N || arr[y][x]==1){
            return false;
        }
        return true;
    }


}
