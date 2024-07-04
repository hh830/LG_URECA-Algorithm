package _240703;

import java.util.Arrays;
import java.util.Scanner;

public class SeqSearch {
    static int seqSearch(int[] a, int n, int key){ // n: 길이, key: 찾는 항목
        int i=0;
        while(true){
            if(i==n) return -1; // 못찾음
            if(a[i] == key) return i; // 찾음. 찾은 인덱스
            i++;
        }
    }
    public static void main(String[] args) {
        // 사용자로부터 배열의 길이, 각 배열의 항목을 입력받고 검색하는 코드
        Scanner scanner = new Scanner(System.in);
        System.out.print("요소 수: ");
        int num = scanner.nextInt();
        int[] x = new int[num];

        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(x));

        while(true){
            System.out.print("검색할 값: ");
            int ky = scanner.nextInt();
            if(ky == -1) break;

            int idx = seqSearch(x, num, ky);

            if(idx == -1){
                System.out.println("검색 실패");
            } else{

            }
        }
    }
}
