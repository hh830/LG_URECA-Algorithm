package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BOJ_쿼드트리 {
    static int arr[][], N;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            String str = bufferedReader.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        method(0, 0, N);
        System.out.println(stringBuilder);
    }

    static void method(int x, int y, int size) {
        if (test(x, y, size)) {
            stringBuilder.append(arr[x][y]);
        } else {
            stringBuilder.append("(");
            int s = size /= 2;

            method(x, y, s); // 1사분면
            method(x, y + s, s); // 2사분면
            method(x + s, y, s); // 3사분면
            method(x + s, y + s, s); // 4사분면

            stringBuilder.append(")");
        }
    }
    static boolean test(int x, int y, int size){
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[x][y] != arr[i][j]) {
                    // 압축 불가능
                    return false;
                }
            }
        }
        return true;
    }
}
