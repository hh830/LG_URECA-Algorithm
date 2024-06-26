package _240625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
// moveTypes, delta 제거 : switch 변경
// x <-> y
// plans 배열의 필요성 ???
public class 상하좌우2 {
    static int n;
    static char[] plans;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int count = stringTokenizer.countTokens();
        plans = new char[count];

        for(int i=0;i<count;i++){
            plans[i] = stringTokenizer.nextToken().charAt(0);
        }

        // 풀이
        int y = 1, x = 1;

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < count; i++) {
            int ny = y;
            int nx = x;

            switch (plans[i]){
                case 'L':
                    nx = nx - 1;
                    break;
                case 'R':
                    nx = nx + 1;
                    break;
                case 'U':
                    ny = ny - 1;
                    break;
                case 'D':
                    ny = ny + 1;
                    break;
            }

            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }

        System.out.println(y + " " + x);
    }
}
