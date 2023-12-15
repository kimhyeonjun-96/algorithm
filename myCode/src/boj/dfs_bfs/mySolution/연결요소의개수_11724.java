package boj.dfs_bfs.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] v;

    static void dfs(int idx){
        for(int i=0; i<graph.get(idx).size(); i++){
            if(!v[graph.get(idx).get(i)]){
                v[graph.get(idx).get(i)] = true;
                dfs(graph.get(idx).get(i));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new boolean[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=m; i++){
            String[] str= br.readLine().split(" ");

            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            graph.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
        }

        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(v[i]) continue;
            dfs(i);
            cnt++;
        }

        System.out.println(cnt);
    }
}
