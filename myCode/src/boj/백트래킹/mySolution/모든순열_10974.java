package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열_10974 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N+1];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;

                arr[depth] = i;
                dfs(depth + 1);

                visit[i] = false;
            }
        }
    }
}
