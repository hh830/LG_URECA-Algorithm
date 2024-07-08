package _240708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_외판원순회 {
    static int N, arr[][], dp[][], INF = 987654321;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        arr = new int[N][N];
        dp = new int[N][(1 << N)-1];

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0,1));
    }

    static int dfs(int node, int bit){
        if(bit == (1 << N) - 1){
            // 모두 탐색
            if(arr[node][0] == 0)
                return INF;

            return arr[node][0]; // 끝 -> 시작도시까지 거리
        }

        // 이미 방문한 노드
        if(dp[node][bit] != -1){
            return dp[node][bit];
        }
        dp[node][bit] = INF;

        for(int i=0;i<N;i++) {
            if ((bit & (1 << i)) == 0 && arr[node][i] != 0) { // 해당 노드 방문하지 않았고 도시에 길이 있을 경우
                int d = dfs(i, bit | (1 << i));
                dp[node][bit] = Math.min(dp[node][bit], d + arr[node][i]);
            }
        }

        return dp[node][bit];
    }
}
