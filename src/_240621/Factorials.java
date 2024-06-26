package _240621;

public class Factorials {
    public static void main(String[] args) {
        factorial(5);// 5x4x3x2x1
        int result = factorial2(5);
        System.out.println(result);
        factorial3(5, 1);
    }

    // 계산 결과를 static 변수를 이용
    static int result = 1;
    static void factorial(int n){
        if(n==1){
            System.out.println(result);
            return;
        }

        result = result * n;
        factorial(n-1);
    }


    static int factorial2(int n){
        if(n == 1){
            return 1;
        }

        return n * factorial2(n-1);
    }

    static void factorial3(int n, int result){ // result: 이전 단계에서 계산되어 전달된 값
        if(n==1){
            System.out.println(result);
            return;
        }

        factorial3(n - 1, result * n);
    }
}
