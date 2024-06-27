package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

// BFS + no visit
public class BOJ_단지번호붙이기_1 {
    static int arr[][];
    static boolean visit[][];
    static boolean visit1[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static int N;
    static ArrayList <Integer> arrayList1 = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        arr = new int[N][N];
        visit = new boolean[N][N];
        visit1 = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = bufferedReader.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        ArrayList <Integer> arrayList = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 1 && !visit[i][j])
                {
                    int size = dfs(i,j);
                    arrayList.add(size);
                    bfs(i,j);
                }
            }
        }
        System.out.println(arrayList.size());

        Collections.sort(arrayList);
        for(int n : arrayList){
            System.out.println(n);
        }

        System.out.println(arrayList1.size());
        Collections.sort(arrayList1);
        for(int n : arrayList1){
            System.out.println(n);
        }
    }

    static int dfs(int x, int y){ // main에서 cnt 초기화 시키고 함수 호출될때마다 cnt를 증가시켜도 됨
        visit[x][y] = true;
        int cnt = 1;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 및 방문하지 않은 집이면 재귀 호출
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                    cnt += dfs(nx, ny);
                }
            }
        }
        return cnt;
    }

    static void bfs(int x, int y){
        int cnt = 1; // 처음 호출되면 새로운 단지가 만들어지므로 1로 초기화함
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visit1[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == 1 && !visit1[nx][ny]) {
                        cnt++;
                        queue.offer(new Node(nx, ny));
                        visit1[nx][ny] = true;
                    }
                }
            }
        }
        arrayList1.add(cnt);
    }

    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
