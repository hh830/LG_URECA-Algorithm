package _240621;

import java.util.Arrays;

public class Comb_Basic {

    static int[] src = {1,2,3,4,5};
    static int[] tgt = new int[3]; /// __ __ __

    // 조합은 select가 필요 x
    // src의 맨 앞에서부터 tgt의 각 자리를 순차적으로 고려하면서 채운다.
    public static void main(String[] args){
        comb(0, 0);
    }

    static void comb(int srcIdx, int tgtIdx){
        // 기저 조건
        if(tgtIdx == tgt.length){
            // 순열 한가지가 완성
            System.out.println(Arrays.toString(tgt));
            return;
        }
        if(srcIdx == src.length) return;

        tgt[tgtIdx] = src[srcIdx]; // tgtIdx 자리에 srcIdx의 수를 채운다. 선택
        comb(srcIdx + 1, tgtIdx + 1); // 위 선택을 받아들이고 다음 자리를 채우러 재귀 호출
        comb(srcIdx + 1, tgtIdx); // 위 선택 무시(비선택) srcIdx 증가시켜서 다음 수를 고려하되 tgtIdx는 그대로 현재 자리를 고려


    }
}
