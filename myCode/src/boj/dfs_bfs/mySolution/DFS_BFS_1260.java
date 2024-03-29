package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_1260 {
    static int n,m,v;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(" ");

            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            graph.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));

//            graph.get(Integer.parseInt(str[0])).sort((Comparator.naturalOrder()));
//            graph.get(Integer.parseInt(str[1])).sort((Comparator.naturalOrder()));
            System.out.println("graph = " + graph);
        }
    }
    static void dfs(int idx){

        visited[idx] = true;
        System.out.print(idx + " ");

        for(int i=0; i<graph.get(idx).size(); i++){
            if( !visited[graph.get(idx).get(i)]){
                dfs(graph.get(idx).get(i));
            }
        }
    }

    static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);

        while (!q.isEmpty()){
            int cur = q.poll();

            System.out.print(cur + " ");
            for(int i : graph.get(cur)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);
    }
}
