package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 자를 높이의 range가 중요. 이 range를 이진탐색으로 처리
public class 떡볶이떡만들기 {
    static int N, M, ans=0;
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        int end = 0, start = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            end = Math.max(arr[i], end);
        }

        method(start, end);
        System.out.println(ans);
    }
    static void method(int start, int end){
        while(start<=end){
            int total = 0;
            int mid = (start + end) / 2;

            for(int i=0;i<arr.length;i++){
                if(arr[i] > mid){
                    // 떡이 가운데보다 길면
                    total += arr[i] - mid;
                }
            }
            if(total < M){
                // 떡 길이가 총 길이보다 작은 경우
                end = mid - 1;
            } else if(total >= M){
                // 떡 길이가 총 길이보다 긴 경우
                start = mid + 1;
                ans = mid;
            }
        }
    }
}
