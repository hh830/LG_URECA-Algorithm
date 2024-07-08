package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_도영이가만든맛있는음식 {
    static int N, S[], B[], min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        S = new int[N];
        B = new int[N];

        for(int i=0;i<N;i++) {
            String str = bufferedReader.readLine();
            S[i] = Integer.parseInt(str.split(" ")[0]); // 신맛
            B[i] = Integer.parseInt(str.split(" ")[1]); // 쓴맛
        }
        // 신맛과 쓴 맛의 차이가 가장 작은 요리
        dfs(0, 1,0);
        System.out.println(min);
    }

    static void dfs(int level, int s_food, int b_food){
        int food = Math.abs(s_food - b_food);

        if(level == N) {
            return;
        }
        min = Math.min(food, min);

        dfs(level+1, s_food*S[level], b_food+B[level]); //선택
        dfs(level+1, s_food, b_food); //선택x
    }

}
