package _240621;

public class FactorialTest {
    public static void main(String[] args) {
        factorial(5);// 5x4x3x2x1
        int result = factorial2(5);
        System.out.println(result);
        factorial3(5, 1);
    }

    // 계산 결과를 static 변수를 이용
    static int result = 1;
    static void factorial(int n){
        // 기저 조건
        // 1. 재귀호출을 끝내야 한다.
        // 2. 문제에서 원하는 상태가 완료됐다.

        if(n==1){ // 0일 때 끝내도 됨
            // 계산 결과 출력
            System.out.println(result);
            return;
        }

        // 계산
        result = result * n; //1이 아닐 경우 5*4*3*2

        // 재귀 호출
        factorial(n-1);
    }

    // 5 <- 4 <- 3 <- 2 <- 1
    static int factorial2(int n){
        // 기저 조건
        if(n==1){
            return 1;
        }
        // 계산 & 재귀호출
        // - 3 단계 입장은 4에게 2*1의 결과에 3 자신을 곱해서 리턴
        // 나보다 1 작은 재귀호출을 수행하고 그 결과에 나를 곱한 다음 리턴
        return n * factorial2(n-1);
    }

    static void factorial3(int n, int result){ // result: 이전 단계에서 계산되어 전달된 값
        if(n == 1){
            System.out.println(result);
            return;
        }
        // 재귀 호출 + 계산
        factorial3(n - 1, result * n);
    }
}

