package _240624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1이될때까지2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int result = 0;

        while(N>1) {
            if (N % K == 0) { // 나눠 떨어지면 나누기
                N /= K;
                result++;
            } else { // 나눠 떨어지지 않을 경우 빼기
                int target = ( N / K ) * K; // k로 나눌 수 있는 수
                result += (N - target); // ex) 18 4면 target = 16, 18 - 16 = 2 -> 뺄 수 있는 수
                N = target; // 나눌 수 있는 수

            }
        }

        System.out.println(result);
    }
}
