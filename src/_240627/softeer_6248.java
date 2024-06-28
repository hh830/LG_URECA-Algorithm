package _240627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class softeer_6248 {
    static List<List<Integer>> arrayList = new ArrayList<>();
    static int n, m, s, t, cnt_s = 0, cnt_t = 0;
    static Set<Integer> set_s = new HashSet<>();
    static Set<Integer> set_t = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arrayList.get(a).add(b); // 단방향
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        s = Integer.parseInt(stringTokenizer.nextToken()); // 출근길
        t = Integer.parseInt(stringTokenizer.nextToken()); // 퇴근길

        bfs_s();
        //bfs_t();

        System.out.println(cnt_s + cnt_t);
    }

    static void bfs_s(){ // s->t
        Queue<Node> queue = new ArrayDeque<>();
        //queue.offer(new Node(s, 0, set));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<arrayList.get(node.x).size();i++){
                int num = arrayList.get(node.x).get(i);
                if(num == t){
                    // 목적지 도달
                    cnt_t = node.cnt;
                    return;
                } else if(num == s){
                    // 출발지 겹침
                    continue;
                }
                //queue.offer(new Node(num, node.cnt+1, set.add(num)));
                System.out.println(num + " "+node.cnt);
            }
        }
    }
        // 역방향 인접리스트 만들기
    // 정방향 인접리스트는 s에서 방문할 수 있는 정점이랑 t에서 방문할 수 있는 정점 찾는것
    // s로 도달할 수 있는 정점을 찾고 t로 도달할 수 있는 모든 정점을 찾음
    //
    static void bfs_t(){  // t->s
        Queue<Node> queue = new ArrayDeque<>();
        //queue.offer(new Node(s, 0, ));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0;i<arrayList.get(node.x).size();i++){
                int num = arrayList.get(node.x).get(i);
                if(num == s){

                    return;
                }
            }
        }
    }

    static class Node{
        int x, cnt;
        Set<Integer> set;

        public Node(int x, int cnt, Set<Integer> set) {
            this.x = x;
            this.cnt = cnt;
            this.set = set;

        }
    }
}
