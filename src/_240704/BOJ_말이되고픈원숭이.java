package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_말이되고픈원숭이 {
    static int K, W, H, cnt = 0;
    static int[][] arr;
    static boolean[][][] visit;
    static int dx[] = { 2, 1, 2, 1, -2, -1, -2, -1};
    static int dy[] = { 1, 2, -1, -2, 1, 2, -1, -2};
    static int nx[] = { 1, -1, 0, 0};
    static int ny[] = { 0, 0, -1, 1};
    static boolean flag;


    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        W = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[H][W];
        visit = new boolean[H][W][31];

        for(int i=0;i<H;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<W;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        if(H==1 && W==1) {
            cnt = 0;
        } else {
            bfs(0, 0);
        }

        if(!flag){
            System.out.println(cnt);
        } else{
            System.out.println(-1);
        }
    }

    static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y, 0, 0));
        visit[y][x][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.horse < K) {
                for (int i = 0; i < 8; i++) {
                    int new_x = node.x + dx[i];
                    int new_y = node.y + dy[i];

                    if (check(new_x, new_y)) {
                        if (new_x == W-1 && new_y == H-1) {
                            cnt = node.c + 1;
                            return;
                        }
                        if(!visit[new_y][new_x][node.horse + 1]) {
                            queue.offer(new Node(new_x, new_y, node.c + 1, node.horse + 1));
                            visit[new_y][new_x][node.horse + 1] = true;
                        }
                    }
                }
            }
            for(int i=0;i<4;i++){
                int new_x = node.x + nx[i];
                int new_y = node.y + ny[i];

                if(check(new_x, new_y)){
                    if(new_x == W-1 && new_y == H-1){
                        cnt = node.c + 1;
                        return;
                    }
                    if(!visit[new_y][new_x][node.horse]) {
                        queue.offer(new Node(new_x, new_y, node.c + 1, node.horse));
                        visit[new_y][new_x][node.horse] = true;
                    }
                }
            }
        }
        flag = true;
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= W || y >= H || arr[y][x] == 1){
            return false;
        }
        return true;
    }

    static class Node{
        int x, y, c, horse;
        Node(int x, int y, int c, int horse){
            this.x=x;
            this.y=y;
            this.c=c;
            this.horse=horse;
        }
    }
}
