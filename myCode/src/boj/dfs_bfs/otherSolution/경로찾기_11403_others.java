package boj.dfs_bfs.otherSolution;

/**
 * https://sumin-kim-dev.github.io/boj/boj-silver-11403/
 * 블로그 구상도
 *  1. 각 정점마다 BFS를 적용
 *  2. 방문하는 정점은 경로가 있는 것이고 아닌 정점은 경로가 없다.
 *
 * 블로그 시간복잡도
 *  O(n^2)
 *
 *  조금 더 찾아보니 플로이드 와샬 알고리즘으로 해당 문제를 해결할 수 있다라고 한다. 다익스트라 알고리즘과 조금의 차이가 있다라고 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기_11403_others {
    static int n;
    static int[][]G;
    static boolean[] visited;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        G = new int[n][n];
        result = new int[n][n]; // 결과를 저장할 인접행렬

        // 인접행렬로 입력되는 값을 인접 리스트로 저장
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색
        for(int i=0; i<n; i++){
            bfs(i);
        }

        // 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];

        q.add(v);
        while (!q.isEmpty()){
            int idx = q.poll();

            for(int i=0; i<n; i++){
                if(!visited[i] && G[idx][i] == 1){
                    visited[i] = true;
                    q.add(i);
                    result[v][i] = 1;
                }
            }
        }
    }
}
