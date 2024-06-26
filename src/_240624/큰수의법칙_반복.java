package _240624;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙_반복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // m개가 될 때까지 가장 큰수를 우선적으로 k번 사용 + 두번째 수 1번 사용 .. m번 더할 때까지
        int result = 0;
        int totalCnt = 0;
        int kCnt = 0;

        while(true){
            if(totalCnt == m) break; // 모든 숫자를 m번 사용
            if(kCnt == k){
                 // 현재 first를 k번 연속으로 사용
                // second 사용해야됨
                result += second;
                kCnt = 0;
            } else{
                result += first;
                kCnt++;
            }
            totalCnt++;
        }
        System.out.println(result);
    }
}
