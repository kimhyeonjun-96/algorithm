package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] root_tree_list;

    static void dfs(int start){
        visited[start] = true;

        for(int i=0; i<graph.get(start).size(); i++){
            int parent_node = graph.get(start).get(i);

            root_tree_list[start] = parent_node;
            if(!visited[parent_node]){
                visited[parent_node] = true;
                dfs(parent_node);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        root_tree_list = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(y).add(x);
            graph.get(x).add(y);
        }

        dfs(n);

        for(int i=2; i< root_tree_list.length; i++){
            System.out.println(root_tree_list[i]);
        }
    }
}

