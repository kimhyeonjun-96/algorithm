package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - 구상도
 *     1. N과 M을 입력 받는다.
 *     2. dfs를 통해서 깊이가 M과 같아지면 배열을 출력하고 종료한다.
 *     3. 깊이와 함께 어디서부터 시작하는지를 의미하는 변수를 통해서 dfs의 재귀되는 범위를 지정한다.
 * - 시간복잡도
 *
 */

public class N과M02_15650_2 {

    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(1, 0);
    }

    private static void dfs(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
