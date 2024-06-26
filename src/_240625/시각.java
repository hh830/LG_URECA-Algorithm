package _240625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int cnt = 0;
        long start = System.nanoTime();

        for(int i = 0;i <= N;i++){
            for(int j = 0;j < 60;j++){
                for(int k = 0;k < 60;k++){
                    if(check(i,j,k)) cnt++;
                }
            }
        }
        long end = System.nanoTime();

        System.out.println(cnt);
        System.out.println(end - start);
    }

    static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3){
            return true;
        }
        return false;
    }
}
