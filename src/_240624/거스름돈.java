package _240624;
// 그리디 한 생각을 자바 코드로 변환 연습 필요
public class 거스름돈 {
    public static void main(String[] args) {
        int money = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10}; // 동전 크기가 큰 순서대로 배열

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += money / coin; // 몫 12/5
            money %= coin;
        }

        System.out.println(cnt);
    }
}
