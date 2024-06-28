package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// Arrays.binarySearch() 사용
public class 부품찾기_2 {
    static int arr[], N, M;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine()); // 가게 부품
        arr = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(bufferedReader.readLine()); // 손님 부품 확인 요청

        int input;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            input = Integer.parseInt(stringTokenizer.nextToken());

            int result = Arrays.binarySearch(arr, input);
            if (result >= 0) {
                stringBuilder.append("yes ");
            } else {
                stringBuilder.append("no ");
            }
        }
        System.out.println(stringBuilder);
    }
}
/*
5
8 3 7 9 2
3
5 7 9
no yes yes
 */