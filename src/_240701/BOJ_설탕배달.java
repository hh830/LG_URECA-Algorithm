package _240701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ_설탕배달 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        for (int i = 1; i <= N; i++) {
            if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE - 1) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE - 1) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
