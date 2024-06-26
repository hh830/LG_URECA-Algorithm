package _240624;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int N = Integer.parseInt(str.split(" ")[0]); // 책의 개수
        int M = Integer.parseInt(str.split(" ")[1]); // 한번에 들 수 있는 책의 개수

        ArrayList<Integer> positiveBooks = new ArrayList<>();
        ArrayList<Integer> negativeBooks = new ArrayList<>();

        str = bufferedReader.readLine();
        String[] positions = str.split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(positions[i]);
            if (num > 0) {
                positiveBooks.add(num);
            } else {
                negativeBooks.add(Math.abs(num));
            }
        }

        Collections.sort(positiveBooks, Collections.reverseOrder()); // 양수는 내림차순 정렬
        Collections.sort(negativeBooks, Collections.reverseOrder()); // 음수는 내림차순 정렬

        int totalSteps = 0;

        // 양수 처리
        for (int i = 0; i < positiveBooks.size(); i += M) {
            totalSteps += positiveBooks.get(i) * 2;
        }

        // 음수 처리
        for (int i = 0; i < negativeBooks.size(); i += M) {
            totalSteps += negativeBooks.get(i) * 2;
        }

        // 가장 먼 거리를 한 번 빼줌 (돌아올 필요가 없으니까)
        int maxDistance = 0;
        if (!positiveBooks.isEmpty() && !negativeBooks.isEmpty()) {
            maxDistance = Math.max(positiveBooks.get(0), negativeBooks.get(0));
        } else if (!positiveBooks.isEmpty()) {
            maxDistance = positiveBooks.get(0);
        } else if (!negativeBooks.isEmpty()) {
            maxDistance = negativeBooks.get(0);
        }

        totalSteps -= maxDistance;

        System.out.println(totalSteps);
    }
}
