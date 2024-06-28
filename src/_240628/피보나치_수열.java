package _240628;

public class 피보나치_수열 {
    static long[] memoi = new long[100]; // 이미 계산된 것을 저장 재활용
    public static void main(String[] args) throws Exception{
        memoi[1] = 1;
        memoi[2] = 1;
        for(int i=3;i<=50;i++){
            memoi[i] = memoi[i-1] + memoi[i-2];
        }
        System.out.println(memoi[50]);
    }

    static long fibo(int x){
        if(x==1 || x==2) return 1;
        if(memoi[x] != 0) return memoi[x]; // 이미 계산된 것이 있으면 그것을 return

        memoi[x] = fibo(x-1) + fibo(x-2);
        return memoi[x];
    }
}
