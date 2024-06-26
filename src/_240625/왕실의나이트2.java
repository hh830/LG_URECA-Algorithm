package _240625;

import java.util.Scanner;

public class 왕실의나이트2 {
    static int y, x, result;
    // 나이트가 이동할 수 있는 8가지 방향 정의
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력받기
        String inputData = sc.nextLine();
        int y = inputData.charAt(1) - '0';
        int x = inputData.charAt(0) - 'a' + 1;

        // 중앙은 똑같이 8방향 다 되니까 for문 돌릴 필요 없음
        if(y > 2 && y < 7 && x > 2 && x < 7){
            System.out.println(8);
            return;
        }

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (ny < 1 && ny > 8 && nx < 1 && nx > 8) {
                result += 1;
            }
        }

        System.out.println(result);

    }
}
