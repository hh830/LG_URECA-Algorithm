package _240701;

import java.util.Scanner;

// 완탐 - dfs
public class BOJ_설탕배달_2 {
    static int N, min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = 5000;

        dfs(0, 0); //5kg 0개, 3kg 0개


    }

    static void dfs(int five, int three){
        int sum = five * 5 + three * 3;
        if(sum == N){
            min = Math.min(min, five + three); // 최소값 갱신
            return;
        } else if(sum > N){
            return; // 실패한 경우
        }

        dfs(five + 1, three);
        dfs(five, three + 1);
    }
}
