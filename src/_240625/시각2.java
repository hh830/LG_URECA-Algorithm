package _240625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각2 {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        long start = System.nanoTime();

        for(int h = 0;h <= N;h++){
            if(h % 10 == 3){
                cnt += 3600;
                continue;
            }
            for(int m = 0;m < 60;m++){
                if(m / 10 == 3 || m % 10 == 3){
                    cnt += 60;
                    continue;
                }
                for(int s = 0;s < 60;s++){
                    if(s / 10 == 3 || s % 10 == 3){
                        cnt++;
                    }
                }
            }
        }

        long end = System.nanoTime();

        System.out.println(cnt);
        System.out.println(end - start);
    }


}
// 5 11475