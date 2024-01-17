package boj.백트래킹.otherSolution;

/**
 * https://fbtmdwhd33.tistory.com/37
 *
 * 15649번 문제는 순열을 출력하는 문제, 15650번 문제는 조합을 출력하는 문제
 * 순열과 조합 문제는 DFS를 이용해 구현하면서, 순열의 경우에는 순열의 끝을 기준으로 재귀 호출을 종료하며,
 * 조합의 경우에도 재귀 호출을 종료하는 조건은 같지만 중간 처리 부분에서 하나의 인지가 더 필요하다는 것을 알 수 있다.
 *
 * 순열은 매 순간마다 1부터 끝 숫자까지 탐색
 * 조합은 (1,2) 또는 (2,1)을 같은 경우로 보기 때문에 매 순간마다 1부터 볼 필요가 없기에 반복문의 시작 부분을 변경하여 탐색
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N과M02_15650_others_2 {
    static int N, M;
    static int list[], check[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        check = new int[9];
        list = new int[9];

        dfs(0, 0);
    }

    private static void dfs(int idx, int cnt) { // idx=at , cnt=depth
        if(cnt == M){
            for(int i=0; i<M; i++){
                System.out.print(list[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=idx+1; i<=N; i++){
            if(check[i] != 1){
                check[i] = 1;
                list[cnt] = i;

                dfs(i, cnt + 1);
                check[i] = 0;
            }
        }
    }
}
