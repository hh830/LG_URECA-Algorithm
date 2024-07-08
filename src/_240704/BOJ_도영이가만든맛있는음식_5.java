package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs
// 부분집합은 하나가 완성된 상태로 따짐
// dfs는 각 단계마다 재료 선택, 비선택을 누적으로 갖고 다님
public class BOJ_도영이가만든맛있는음식_5 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] src; // 재료(신, 쓴)
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine()); // 재료수
        src = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            src[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            src[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        dfs(0, 1, 0); // 첫 번째 재료부터 시작
        System.out.println(min);
    }

    // dfs
    static void dfs(int srcIdx, int sinSum, int ssnSum){ // sinSum, ssnSum: 현 단계 이전까지의 신맛과 쓴맛의 합
        if(srcIdx == N) return;

        // 매단계마다 신맛, 쓴맛 계산
        int currSin = src[srcIdx][0] * sinSum;
        int currSsn = src[srcIdx][1] + ssnSum;

        min = Math.min(min, Math.abs(currSin-currSsn));

        // 현재 재료를 선택하고 계속 가는 경우
        dfs(srcIdx+1, currSin, currSsn);
        // 현재 재료를 선택하지 않고 계속 가는 경우
        dfs(srcIdx+1, sinSum, ssnSum);
    }
}
