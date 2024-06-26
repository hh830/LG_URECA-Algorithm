package _240625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발2 {
    static int n, m, y, x, dir, cnt;
    static boolean[][] visit;
    static int[][] map;

    // 북->동->남->서 ( 시계방향 )
    static int dy[] = { -1, 0, 1, 0 };
    static int dx[] = { 0, 1, 0, -1 };

    // 왼쪽 회전
    static void turn_left(){
        if(--dir == -1) dir = 3;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        y = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());
        dir = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 풀이 - 시뮬레이션
        visit[y][x] = true;
        cnt = 1;
        int turn_time = 0;

        while(true){
            // 왼쪽 turn
            turn_left();

            // turn한 왼쪽으로 방문할 수 있으면 방문
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(!visit[ny][nx] && map[ny][nx] == 0){
                visit[ny][nx] = true;

                y = ny;
                x = nx;
                cnt++;
                turn_time = 0;

            } else{ // 방문할 수 없으면 다음 turn체크
                turn_time++;
            }

            // 네 방향 모두 방문할 수 없으면
            if(turn_time == 4){
                ny = y - dy[dir];
                nx = x - dx[dir];

                if(map[ny][nx] == 0){
                    // 뒤로 갈 수 있으면 이동
                    y = ny;
                    x = nx;
                } else{
                    // 뒤로 갈 수 없으면 이동 종료
                    break;
                }
                turn_time = 0;
            }
        }
        System.out.println(cnt);
    }
}
