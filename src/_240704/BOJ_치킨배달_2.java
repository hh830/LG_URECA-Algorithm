package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 조합
// 집, 치킨집 별도의 자료구조( ArrayList )
public class BOJ_치킨배달_2 {
    static int N, M, houseSize, srcSize, min;
    static List<int[]> house, src, tgt;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        house = new ArrayList<>(); // 집
        src = new ArrayList<>(); // 치킨 집
        tgt = new ArrayList<>(); // 선택된 치킨 집

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
        houseSize = house.size();
        srcSize = src.size();

        comb(0,0);
        System.out.println(min);
    }
    static void comb(int srcIdx, int tgtIdx){
        if(tgtIdx == M){
            // 현재 M개의 치킨집을 선택한 상태
            // 마을 전체의 치킨 거리 중 최소를 선택해야됨
            // 모든 집에 대해 가장 가까운 치킨집까지의 거리를 계산 후 모두 더하고 그것을 min과 비교, 선택
            int sum = 0; // 치킨 거리를 모두 더한 값
            for(int i=0;i<houseSize;i++){ // 각각의 집에 대해
                int minDist = Integer.MAX_VALUE;
                int[] h = house.get(i);
                for(int j=0;j<M;j++){
                    int[] c = tgt.get(j);
                    minDist = Math.min(minDist, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1])); // 현재 i번째 집에서 가장 가까운 치킨집거리

                }
                sum += minDist;
            }
            min = Math.min(min, sum);
            return;
        }
        if(srcIdx == srcSize) return;

        // 선택
        tgt.add(src.get(srcIdx));
        comb(srcIdx + 1, tgtIdx + 1);
        // 비선택
        tgt.remove(src.get(srcIdx));
        comb(srcIdx + 1, tgtIdx);
    }
}
