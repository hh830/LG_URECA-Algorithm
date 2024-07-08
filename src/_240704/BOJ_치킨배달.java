package _240704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_치킨배달 {
    static int parent[], N, result=0, arr[][], total[], distance;
    static Node chicken[];
    static Node house[];

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int idx1=0, idx2=0;
        chicken = new Node[13];
        house = new Node[2*N];

        arr = new int[N][N];
        total = new int[N];
        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] == 2) chicken[idx1++] = new Node(i, j); // 치킨집 저장
                if(arr[i][j] == 1) house[idx2++] = new Node(i,j); // 집 저장
            }
        }

    }
    // 가까운 치킨집이 어딘지 구하고
    // 모든 집의 치킨 거리의 합이 작게 되어야 함 -> 치킨집 최대 M개 고르고 나머지 폐업 -> 어떤 치킨집이 가장 멀리 있는지
    static void dfs(int x, int y, int nx, int ny){
        if(nx == N && ny == N){
            return;
        }
        if(arr[nx][ny] == 2){
            int dis = Math.abs(x-nx) + Math.abs(y-ny);
            distance = Math.min(distance, dis);
        }
    }
}
