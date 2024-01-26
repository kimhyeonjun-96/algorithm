package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M06_105655 {static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;

    private static void dfs(int at, int depth) {
        if(depth == M){
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visit[i]){
                visit[i] = true;

                result[depth] = arr[i];
                dfs(at+1, depth+1);

                visit[i] = false;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(1, 0);
        System.out.println(sb);
    }
}
