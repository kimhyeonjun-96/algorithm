package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차이를최대로_10819 {

    static int N, max;
    static int[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            visited[i] = true;
            max = Math.max(dfs(1,A[i]), max);
            visited[i] = false;
        }
        System.out.println(max);
    }

    private static int dfs(int depth, int prev) {

        if (depth == N) {
            int tmp = 0;
            for(int i=0; i<N-1; i++){
                tmp += Math.abs(A[i] - A[i + 1]);
            }
            return tmp;
        }

        int result = 0;
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                result = Math.max(result, dfs(depth + 1, A[i]));
                visited[i] = false;
            }
        }
        return result;
    }


}
