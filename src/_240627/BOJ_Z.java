package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 분할 정복
public class BOJ_Z {
    static int N, r, c, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]); // 2의 제곱수
        r = Integer.parseInt(str.split(" ")[1]);
        c = Integer.parseInt(str.split(" ")[2]);

        N = (int) Math.pow(2, N); // N을 2^N 으로 보정

        // 원점으로부터 (r,c)까지 거리
        int x = 0;
        int y = 0;

        // 반복문으로 분할 정복
        // (r, c) 위치까지 찾아질 동안 계속 분할 처리
        while(true){
            if( N == 1 ) break;

            N /= 2;

            if( r < y + N && c < x + N){
                // 분할 영역

            } else if(r<y+N && c >= x + N){ // 2사분면
                ans +=  N * N * 1;
                x += N; // 원점 이동
            } else if(r >= y+N && c < x + N){  // 3사분면
                ans +=  N * N * 2;
                y += N; // 원점 이동
            } else{ // 4사분면
                ans +=  N * N * 3;
                x += N; // 원점 이동
                y += N;
            }
        }
        System.out.println(ans);
    }
}
