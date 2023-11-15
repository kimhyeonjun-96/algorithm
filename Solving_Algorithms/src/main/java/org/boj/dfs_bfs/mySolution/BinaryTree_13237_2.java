package org.boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTree_13237_2 {

    public static int n;
    public static int[] arr;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for (int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] == -1) root = i;
        }

        for(int i=1; i<=n; i++){
            dfs(i, 0);
        }

    }

    private static void dfs(int now, int cnt) {
        if(now == root && arr[now] == -1){
            System.out.println(cnt);
            return;
        }
        dfs(arr[now], cnt+1);
    }
}
