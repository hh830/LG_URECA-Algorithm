package _240703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_오큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[N+1];

        Stack<Integer> stack = new Stack();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<N;i++){
            boolean flag = false;
            if(!stack.isEmpty() && stack.peek() <= arr[i]){
                // 최대 수 보다 크면 -1처리
                stringBuilder.append(-1).append(" ");
                continue;
            }
            for(int j=i+1;j<=N;j++){ // 탐색 시작
                if(arr[i] < arr[j]){
                    // 큰 수 중 오른쪽에 가장 먼저 나오는 것
                    stringBuilder.append(arr[j]).append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                // 없으면 stack보다 작은 수인데 오른쪽에 큰 수가 없는 것
                stack.push(arr[i]);
                stringBuilder.append(-1).append(" ");
            }
        }
        stringBuilder.append(-1); // 끝에는 무조건 -1
        System.out.println(stringBuilder);
    }
}
