package _240624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int arr[] = new int[N];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            int min = Integer.MAX_VALUE;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;stringTokenizer.hasMoreTokens();j++){
                min = Math.min(min, Integer.parseInt(stringTokenizer.nextToken()));
            }
            arr[i] = min;
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
