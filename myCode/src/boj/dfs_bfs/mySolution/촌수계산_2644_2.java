package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 촌수계산_2644_2 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    private static int dfs(int find_x, int find_y, int cnt) {
        visited[find_x] = true;
        for(int current : graph.get(find_x)){
            if(current == find_y){
                return cnt;
            }
            if(!visited[current]){
                visited[current] = true;
                int result = dfs(current, find_y, cnt+1);
                if(result != -1) return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int find_x = Integer.parseInt(st.nextToken());
        int find_y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(" ");
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            graph.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
        }

        System.out.println(dfs(find_x,find_y,1));
    }
}
