package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M03_15651 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int depth) {

        if(depth == M){
            for(int val : arr){
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }

    }
}
