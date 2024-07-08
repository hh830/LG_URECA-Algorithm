package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 조합 + np
public class BOJ_치킨배달_NP {
    static int N, M, houseSize, srcSize, min;
    static int[] index; // np
    static List<int[]> house, src;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        house = new ArrayList<>(); // 집
        src = new ArrayList<>(); // 치킨 집

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                int a = Integer.parseInt(stringTokenizer.nextToken());

                if(a==1) house.add(new int[]{i, j});
                else if(a == 2) src.add(new int[]{i, j});
            }
        }

        min = Integer.MAX_VALUE;
        houseSize = house.size(); // 집
        srcSize = src.size(); // 치킨집

        // NP
        index = new int[srcSize]; // 치킨 집의 수만큼 배열을 생성 - 전부 00000...00
        // M개만큼 뽑고 싶다(조합)
        for(int i=srcSize - M;i<srcSize;i++){ // 0000011111 (M:5) - 제일 작은 수 / 1111100000 - 제일 큰 수
            index[i] = 1;
        }
        // index 배열은 최소를 의미 asc로 정렬된 상태
        while(true){
            // 조합 1개 완성 상태
            int sum = 0;
            for(int i=0;i<houseSize;i++){ // 각 집에 대해
                int minDist = Integer.MIN_VALUE;

                int[] h = house.get(i); //현재 고려하는 집

                for(int j=0;j<srcSize;j++){
                    if(index[j] == 1){
                        int[] c = src.get(j);
                        minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                    }
                }
                sum += minDist;
            }
            min = Math.min(min, sum);
            if(!np()) break;
        }
        System.out.println(min);

    }


    static boolean np() {
        // 3
        // 맨 뒤에서 출발
        int i = index.length - 1;

        // 뒤보다 앞이 크거나 같으면( 내림차순으로 정렬되어 있으면 ) 계속 가다가 그렇지 않으면 멈춘다.
        // 5 <-- 4 <-- 2 까지는 계속
        // 1 X 5 <-- 4 <-- 2
        while( i > 0 && index[i-1] >= index[i] ) --i;

        // 맨 앞까지 왔으면 종료
        if( i == 0 ) return false;

        // 현재 src[i-1] 이 src[i] 보다 작은 상태
        // src[i] 이후 항목 (src[i] 보다 작은) 과 src[i-1]과 비교 필요

        // 맨 뒤에서 출발
        int j = index.length - 1;
        // i 이전 항목 중 src[i-1] 보다 작은 것은 무시하고, 큰 것이 있으면 멈춤
        //  만약 큰 것이 있으면 그것과  없으면 src[i] 와 교환
        while( index[i-1] >= index[j]) --j;
        swap( index, i-1, j ); //src[i] < src[j]

        // i 부터 맨 뒤까지 reverse
        int k = index.length - 1;
        while( i < k ) {
            swap(index, i++, k--);
        }
        return true;

    }

    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
