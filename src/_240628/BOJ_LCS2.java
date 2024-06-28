package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_LCS2 {
    public static void main(String[] args) throws Exception{
        // 다르면 LCS[i-1][j], LCS[i][j-1] 중 큰 값
        // 같으면 LCS[i-1][j-1] + 1
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    int max = Math.max(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = max;
                }
            }
        }

        int n = str1.length();
        int m = str2.length();
        while(n>=1 && m>=1){
            if(dp[n][m] == dp[n][m-1]){
                // 위
                m--;
            } else if(dp[n][m] == dp[n-1][m]){
                // 왼
                n--;
            } else{
                stringBuilder.append(str2.charAt(m-1));
                m--;
                n--;
            }
        }
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.reverse());
    }
}
