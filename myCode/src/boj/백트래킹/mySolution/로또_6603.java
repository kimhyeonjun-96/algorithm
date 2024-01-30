package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_6603 {
    static int K;
    static int[] S;
    static int[] result;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){ // 0이 입력되기 전까지 반복
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            S = new int[K];
            for(int i=0; i<K; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            result = new int[6];

            dfs(0, 0);
            System.out.println();
            sb.append("\n");
        }
        // 결과 출력
        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        // 깊이가 6개의 숫자가 된다면 그만
        if(depth == 6){
            for (int val : result) {
                sb.append(val).append(" ");;
            }
            sb.append("\n");
            return;
        }

        // 재귀를 통한 조합 가능한 순열 탐색
        for(int i=at; i<K; i++){
            result[depth] = S[i];
            dfs(i+1, depth + 1);
        }
    }
}
