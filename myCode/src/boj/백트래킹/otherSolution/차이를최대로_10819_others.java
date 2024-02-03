package boj.백트래킹.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819_others {

    static int N, max=Integer.MIN_VALUE;
    static int[] A;
    static int[] result;
    static boolean[] visited;

    private static void dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = A[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        result = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }

}
