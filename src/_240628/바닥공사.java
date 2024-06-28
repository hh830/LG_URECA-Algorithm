package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 바닥공사 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int dp[] = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 796796;
        }
        System.out.println(dp[N]);
    }
}
