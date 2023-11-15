package org.boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGameOfDeath_11558 {
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int K = 1;
            arr = new int[N+1];

            for(int j=1; j<=N; j++){
                arr[j] = Integer.parseInt(br.readLine());
            }
/*
            처음 풀었을 때
            while (arr[K]!=N){
                K++;
                if(K>N) {
                    K=0;
                    break;
                }
            }
*/
//          두번째 풀었을 떄
            int current_idx = 1;

            while (true){
                  if(arr[current_idx] == N) break;
                  K++;
                  current_idx = arr[current_idx];
                  if(K>N) {
                      K=0;
                      break;
                  }
              }
            System.out.println(K);
        }
    }
}
