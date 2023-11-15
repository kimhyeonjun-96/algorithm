package org.boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GameOfDeath_17204 {
    public static int n, k;
    public static int[] arr;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;
        while (true){
            cnt++;
            if(arr[i] == k) break;
            i = arr[i];
            if(cnt > n) break;
        }
        System.out.println(cnt > n ? -1 : cnt);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//
//        arr = new int[n];
//
//        for(int i=0; i<n; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        for(int i=0; i<n; i++){
//            if(dfs(i) != -1){
//                break;
//            }
//        }
//        System.out.println(cnt);
//    }
//
//    private static int dfs(int i){
//        if(!(i+1>=n)){
//            cnt += 1;
//            if(arr[i] == k) return cnt;
//            dfs(i+1);
//            return cnt;
//        }
//
//        return cnt=-1;
//    }
}
