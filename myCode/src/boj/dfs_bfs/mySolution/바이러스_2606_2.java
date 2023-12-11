package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 바이러스_2606_2 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean [] v;
    static int cnt = 0;
    static void dfs(int idx){
        v[idx] = true;

        for(int i=0; i<graph.get(idx).size(); i++){
            if( !v[graph.get(idx).get(i)]) {
                cnt++;
                v[graph.get(idx).get(i)] = true;
                dfs(graph.get(idx).get(i));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pc_num = Integer.parseInt(br.readLine());
        int pc_conn_num = Integer.parseInt(br.readLine());
        v = new boolean[pc_num+1];

        for(int i=0; i<=pc_num; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=pc_conn_num; i++){
            String[] str = br.readLine().split(" ");
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            graph.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
        }

        dfs(1);
        System.out.println(cnt);
    }
}
