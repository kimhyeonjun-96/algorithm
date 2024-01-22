package boj.백트래킹.mySolution;

/**
 * 구살도
 *  N,M이 주어졌을 때, 중복이 되어도 괜찮은 탐색을 한다.
 *  수열은 비내림차순으로 출력을 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M04_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if(depth == M){
            for(int var : arr){
                sb.append(var).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=at; i<=N; i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
