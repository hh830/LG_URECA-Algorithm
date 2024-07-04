package _240703;

// 부분집합은 조합의 합
// select 배열을 parameter 화
// select 배열 대신 bitmasking
// <<, & |
public class Subset_Param_BitMask {

    static int[] src = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
//		boolean[] select = new boolean[src.length];
        subset(0, 0);
    }

    static void subset(int srcIdx, int mask) { // mask <- select 대체
        // 기저조건
        if( srcIdx == src.length ) {
            printSubset(mask);
            return;
        }

        // 현재 srcIdx 에 대해서 선택, 비선택 이어간다.
        subset(srcIdx + 1, mask | 1 << srcIdx); // mask 의 bit 표현 중 srcIdx 자리를 1 로 변경
        subset(srcIdx + 1, mask);
    }

    static void printSubset(int mask) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < src.length; i++) {
            if( (mask & 1 << i) != 0 ) sb.append(src[i]).append(" ");
        }

        System.out.println(sb);
    }
}