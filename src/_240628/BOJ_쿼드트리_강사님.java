package _240628;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_쿼드트리_강사님 {
    static int N;
    static char[][] map;
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        map = new char[N][];

        for(int i=0;i<N;i++){
            map[i] = bufferedReader.readLine().toCharArray();
        }

        divide(0,0, N);
        System.out.println(stringBuilder);
    }

    static void divide(int x, int y, int n){
        // x,y좌표를 왼쪽 위 시작점으로 하고 가로, 세로 n 길이만큼 문자가 모두 같은지 확인
        if(check(x, y, n)){
            // 모든 영역이 같은 문자
            stringBuilder.append(map[x][y]);
        } else{
            stringBuilder.append("(");
            int half = n/2;
            divide(x, y, half);
            divide(x, y+half, half);
            divide(x+half, y, half);
            divide(x+half, y+half, half);

            stringBuilder.append(")");
        }
    }

    static boolean check(int x, int y, int n){
        char ch = map[x][y];

        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(ch!=map[i][j]) return false;
            }
        }
        return true;
    }
}
