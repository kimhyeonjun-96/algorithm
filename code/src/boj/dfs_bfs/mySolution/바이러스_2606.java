package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스_2606 {
    static int k, n;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] v;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=k; i++){
            arr.add(new ArrayList<>());
        }

        v = new boolean[k+1];

        String[] str =  new String[n+1];
        for(int i=1; i<=n; i++){
            str[i] = br.readLine();
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == Integer.parseInt(str[j].split(" ")[0])){
                    arr.get(i).add(Integer.parseInt(str[j].split(" ")[1]));;
                }
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        v[start] = true;
        int cnt = 0;

        while (!q.isEmpty()){
            int x = q.poll();
            for(int i=0; i<arr.get(x).size(); i++){
                if(!v[arr.get(x).get(i)] ){
                    v[arr.get(x).get(i)] = true;
                    q.add(arr.get(x).get(i));
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args) throws Exception {
        input();
        bfs(1);
    }
}
