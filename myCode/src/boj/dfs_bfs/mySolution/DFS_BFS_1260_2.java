package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_1260_2 {


    static int N, M, V;

    static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);

            graph.get(x).sort((Comparator.naturalOrder()));
            graph.get(y).sort((Comparator.naturalOrder()));
        }
        dfs(V);
        visit = new boolean[N+1];
        System.out.println();
        bfs(V);

    }

    private static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int i=0; i<graph.get(cur).size(); i++){
                int next = graph.get(cur).get(i);
                if(!visit[next]){
                    q.add(next);
                    visit[next] = true;
                }
            }
        }
    }

    private static void dfs(int start) {

        visit[start] = true;
        System.out.print(start + " ");
        for(int i=0; i<graph.get(start).size(); i++){
            int next = graph.get(start).get(i);
            if(!visit[next]){
                dfs(next);
            }
        }
    }
}
