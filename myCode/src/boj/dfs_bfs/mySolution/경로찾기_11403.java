package boj.dfs_bfs.mySolution;

/**
 * 내 구상도
 *  1. 행만큼 반복을 한다.
 *  2. i번째 행에서 열만큼 반복
 *  3. G[i][j] == 1이라면 bfs 탐색
 *  4. bfs에서도 또 다시...열만큼 반복....어라..?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기_11403 {
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
