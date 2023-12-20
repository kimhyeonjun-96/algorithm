package boj.dfs_bfs.mySolution;
/*
* BFS 최단거리 알고리즘 ( 다익스트라 알고리즘 )
*   동작과정
*       출발 노드를 설정
*       최단 거리 테이블 초기화
*       방문하지 않은 노드 중에서 최단 거리(가중치)가 가장 짧은 노드 선택
*       해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
*       위 과정에서 3, 4번 반복
*   특징
*     최단 경로를 구하는 과정에서 각 노드에 대한 현재까지의 최단 거리 정보를 항상 1차원의 리스트에 저장하며 리스트를 계속 갱신
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 촌수계산_2644 {

    static int n, m;
    static ArrayList<ArrayList<Integer>> people = new ArrayList<>();
    static boolean[] v;
    static int[] dist;

    static int bfs(int start, int end){
        Queue<Integer> q = new LinkedList();
        v[start] = true;
        dist[start] = 0;

        q.add(start);
        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next : people.get(cur)){
                if(!v[next]){
                    dist[next] = dist[cur] + 1;
                    if(next == end) return dist[next];
                    q.offer(next);
                    v[next] = true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 셋팅
        n = Integer.parseInt(br.readLine());
        v = new boolean[n+1];
        dist = new int[n+1];
        for(int i=0; i<=n; i++){
            people.add(new ArrayList<Integer>());
        }
        String[] str = br.readLine().split(" ");
        int find_x = Integer.parseInt(str[0]);
        int find_y = Integer.parseInt(str[1]);

        m = Integer.parseInt(br.readLine());
        for(int i=1; i<=m; i++){
            str = br.readLine().split(" ");

            people.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
            people.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
        }

        System.out.println(bfs(find_x, find_y));
    }
}

/*static int bfs(int x, int y){
    Queue q = new LinkedList();
    q.add(people.get(x));
    v[x] = true;
    int cnt = 0;

    while (!q.isEmpty()){
        ArrayList<Integer> curList = (ArrayList) q.poll();
        for(int i : curList){
            if(i == y)return cnt+1;
            if(!v[i]){
                v[i] = true;
                q.add(people.get(i));
                cnt++;
            }
        }
    }
    return -1;
}*/
