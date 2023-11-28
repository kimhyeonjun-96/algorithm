package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BinaryTree_13237 {
    public static int n;
    public static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            nodes.add(new ArrayList<>());
            nodes.get(i).add(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<nodes.get(i).size(); j++){
                dfs(i, j, 0);
            }
        }
    }

    public static void dfs(int i, int j, int cnt){
        if(nodes.get(i).get(j) == -1){
            System.out.println(cnt);
        }else{
            cnt++;
            if(nodes.get(i).get(j) - cnt < 0){
                dfs(0, 0, cnt);
            }else {
                dfs(nodes.get(i).get(j) - cnt, j, cnt);
            }
        }
    }
}
