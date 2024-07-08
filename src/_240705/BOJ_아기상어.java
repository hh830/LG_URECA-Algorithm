package _240705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 발생했던 오류에 대한 원인
// #1 PriorityQueue? 상어 위치 ~~ 각 물고기 <= 맨하턴 거리 X 이동 불가한 지점이 포함될 수 있다.
// #2 while - if{} 에서 찾으면 바로 break <= queue 에 동등한 자격의 더 가까운 Node 가 포함될 수 있다.
public class BOJ_아기상어 {
    static int N, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visit;

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if ( n == 9 ) {
                    sy = i;
                    sx = j;
                }
                map[i][j] = n;
            }
        }

        // 시물레이션 풀이
        sSize = 2;
        // 상어는 가장 가까운 합당한 먹이를 찾고 먹는 작업을 반복(불가능할 때까지)
        while(true) {
            int cnt = bfs();
            if( cnt == 0 ) break;
            ans += cnt;
        }
        System.out.println(ans);
    }
    // 가장 가까운 합당한 먹이를 찾고 먹는 작업, 이동한 시간 (거리) 리턴, 더이상 못찾으면 -1
    static int bfs() {
        // 초기화
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;

        // visit 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }

        // 현재 상어의 위치에서 출발
        visit[sy][sx] = true;
        queue.offer(new Node(sy, sx, 0));

        while(! queue.isEmpty() ) {
            Node node = queue.poll();

            // 가지치기 오류 (고려하고 난 후에 가지치기가 필요)
//          if( node.d + 1 >= minDis ) continue;

            // 물고기 < 상어 사이즈
            if( map[node.y][node.x] < sSize && map[node.y][node.x] != 0 ) {
                // 자격이 되는 물고기를 찾음.
                if( node.d < minDis ) { // 거리가 최소거리보다 작을 때 최소거리 초기화
                    minDis = node.d;
                    minY = node.y;
                    minX = node.x;
                }else if( node.d == minDis ){ // 거리=최소거리
                    if( node.y < minY ) { // 위쪽먼저
                        minDis = node.d;
                        minY = node.y;
                        minX = node.x;
                    }else if( node.y == minY ) { // 위 좌표도 같을 때
                        if( node.x < minX ) { // 왼쪽 먼저
                            minDis = node.d;
                            minY = node.y;
                            minX = node.x;
                        }
                    }
                }
                // 이곳 break 안된다.
//              break;
            }
            // 가지치기
            if( node.d + 1 >= minDis ) continue;

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if( ny < 0 || nx < 0 || ny >= N || nx >= N
                        || visit[ny][nx] || map[ny][nx] > sSize
                ) continue;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, node.d + 1));
            }
        }

        // 이동한 거리
        if( minDis == Integer.MAX_VALUE ) return 0;
        else {
            sEatCnt++;
            if( sEatCnt == sSize ) {
                sSize++;
                sEatCnt = 0;
            }

            map[minY][minX] = 0;
            map[sy][sx] = 0;
            sy = minY;
            sx = minX;
        }
        return minDis;
    }

    static class Node{
        int y, x, d;

        Node(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
