package _240625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class game {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int arr[][];
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int M = Integer.parseInt(str.split(" ")[1]);

        str = bufferedReader.readLine();
        int A = Integer.parseInt(str.split(" ")[0]);
        int B = Integer.parseInt(str.split(" ")[1]);
        int d = Integer.parseInt(str.split(" ")[2]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            str = bufferedReader.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int x = A, y = B, cnt = 0, tmp = 0;
        int dt;
        while(true){
            dt = turn(d);

            int nx = x + dx[dt];
            int ny = y + dy[dt];

            if(arr[nx][ny] == 0 && !visited[nx][ny]){
                // 육지이고 방문한 적 없는 곳
                tmp = 0;
                x = nx;
                y = ny;
                visited[nx][ny] = true;
                cnt++;
            } else{
                tmp++;
                if(tmp == 4){
                    // 바라보는 방향을 유지한 채로 뒤로 가기
                    nx = x - dx[dt];
                    ny = y - dy[dt];

                    if(arr[nx][ny] == 1){
                        break;
                    } else{
                        x = nx;
                        y = ny;
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static int turn(int d){
        switch (d){
            case 0: // 북 -> 서
                d = 3;
                break;
            case 1: // 동 -> 북
                d--;
                break;
            case 2: // 남 -> 동
                d--;
                break;
            case 3: // 서 -> 남
                d--;
                break;
        }
        return d;
    }
}
