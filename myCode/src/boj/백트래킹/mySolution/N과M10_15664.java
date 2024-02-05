package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M10_15664 {

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = new int[M];
        visit = new boolean[N];

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(' ');
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i=at; i<N; i++){
            if (!visit[i] && before != arr[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                before = arr[i];
                dfs(i+1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
