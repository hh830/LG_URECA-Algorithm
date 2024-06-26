package _240624;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙_6 {
    static int n, m, k, result;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기 O(N log N)
        int first = first(); // 가장 큰 수
        int second = second(); // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        // 큰 수가 F 두번째수가 S라고 하면
        // m : 8 k : 3
        // FFFS + FFFS <- (k+1) + (k+1)
        // m:10이면 FFFS + FFFS + FF <- (k+1) + (k+1) + 2
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
    }

    static int first(){
        int first = 0; // max
        int firstIndex = 0;

        for(int i=0;i<n;i++){ // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if(arr[i] >= first){
                first = arr[i];
                firstIndex = i;
            }
        }
        return first;
    }

    static int second(){
        int second = 0;

        for(int i=0;i<n;i++){
            if(arr[i] > second){ // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
                second = arr[i];
            }
        }
        return second;
    }
}
