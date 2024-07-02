package _240701;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1회사 -> k회사 -> x회사에 대한 최단 경로 문제
// 회사별 이동 시간(비용) 모두  1<= bfs로도 가능 1->k, k->x
// 모든 정점에서 다른 모든 정점으로 가는 최단 경로 알고리즘 적용
// 플로이드워셜 < O(N^3) 3중 for문 <= N이 적을 때, 500 미만
// 자료구조 인접행렬 matrix는 최초 입력 테케로 초기화가 된 후, 3중 for문에 의해 최소 비용으로 갱신
public class 미래도시 {
    static final int INF = 100 * 100;
    static int n, m, x, k;
    static int[][] matrix;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken()); // 정점(도시) 수
        m = Integer.parseInt(stringTokenizer.nextToken()); // 간선(도로) 수 비용 `

        matrix = new int[n+1][n+1];

        //matrix를 모두 INF 초기화
        for(int i=1;i<=n;i++){
            Arrays.fill(matrix[i], INF); // 충분히 큰 값으로 전체 초기화
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) matrix[i][j] = 0;
            }
        }

        // m개의 간선(도로)
        for(int i=0;i<m;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        // x, k
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        x = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());


        // 플로이드워셜
        for(int k=1;k<=n;k++){ // 경유지
            for(int i = 1;i<=n;i++){ // 행
                for(int j=1;j<=n;j++) //열
                {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int distance = matrix[1][k] + matrix[k][x];

        if(distance >= INF){
            System.out.println(-1);
        } else{
            System.out.println(distance);
        }
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
3
 */