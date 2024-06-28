package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1로만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bufferedReader.readLine());

        int dp[] = new int[X+1];
        dp[1] = 0;
        // 현재 수 i를 만드는 최소 방법의 수를 찾는다.
        for(int i=2;i<=X;i++){
            // 이전 수 중 + 1 => i
            dp[i] = dp[i-1] + 1;

            // 이전 수 중 * 2 => i <= i가 2로 나누어 떨어진다.
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if(i % 5 == 0){
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}
