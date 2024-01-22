package boj.백트래킹.otherSolution;

/**
 * 해당 문제도 백트래킹 문제로 dfs 탐색방식을 사용을 한다.
 * 다만 15650번 문제는 1부터 N까지의 수 중 오름차순이면서 M의 길이까지 나열 가능한 수열 이어야한다.
 * 이 문제는 깊이를 의미하는 변수 외에도 어디서부터 시작하는지를 의미하는 변수를 하나 더 추가해야한다.
 *
 *  https://st-lab.tistory.com/115
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M02_15650_others {
    static int[] arr;
    static int N, M;

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
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<=N; i++){
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
