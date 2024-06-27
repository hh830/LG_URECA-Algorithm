package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 분할 정복
public class BOJ_Z_2 {
    static int N, r, c, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        N = Integer.parseInt(str.split(" ")[0]); // 2의 제곱수
        r = Integer.parseInt(str.split(" ")[1]);
        c = Integer.parseInt(str.split(" ")[2]);

        N = (int) Math.pow(2, N); // N을 2^N 으로 보정

        z(0,0);

        System.out.println(ans);
    }
    static void z(int y, int x){
        if(N==1) return;

        N /= 2;

        if( r < y + N && c < x + N){
            // 분할 영역
            z(y, x);
        } else if(r<y+N && c >= x + N){ // 2사분면
            ans +=  N * N * 1;
            z(y, x+N); // 원점 이동
        } else if(r >= y+N && c < x + N){  // 3사분면
            ans +=  N * N * 2;
            z(y+N, x); // 원점 이동
        } else{ // 4사분면
            ans +=  N * N * 3;
            z(y+N, x+N); // 원점 이동
        }
    }
}
