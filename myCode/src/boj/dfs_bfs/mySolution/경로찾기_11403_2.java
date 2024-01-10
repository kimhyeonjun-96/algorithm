package boj.dfs_bfs.mySolution;

/**
 * 이전에 풀었던 것을 기반으로 구상도 다시 작성 후 코드 작성
 * 구상도
 *  1. 입력 받은 인접행렬을 저장
 *  2. 행만큼 반복하여 현재 위치가 1~N까지 모두 갈 수 있는지 BFS로 탐색
 *  3. BFS 탐색 중 정점에 대한 간선이 존재한다면  result[탐색중인 행][간선이 존재하는 정점] = 1로 값을 채운다.
 *  4. BFS 탐색이 종료되면 result를 출력
 *
 * 시간복잡도
 *  O(n^2)
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 경로찾기_11403_2 {
    static int n;
    static int[][] G;
    static boolean[] visited;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 초기화
        n = Integer.parseInt(br.readLine());
        G = new int[n][n];
        result = new int[n][n];

        // G 초기화
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                G[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 행만큼 반복하여 현재 위치가 1~N까지 모두 갈 수 있는지 BFS로 탐색
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
                    result[v][i] = 1;
                    q.add(i);
                }
            }
        }
    }
}
