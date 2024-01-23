package boj.백트래킹.mySolution;
/**
 * 구상도
 *  1. N이 주어진다.
 *  2. 1번 퀸이 체스판에 어딘가에 놓인다면, 이동되는 칸을 파악한다.
 *  3. 1번 퀸이 이동 되지 않는 칸에 2번 퀸을 놓는다.
 *  4. 이렇게 N번 퀸까지 반복을 하다 N번 퀸이 놓인다면 개수를 센다.
 *
 * 하아....진짜 어렵네...
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {
    static int N;
    static int[][] chessBoard;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상하좌우 및 대각선 행 이동
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1}; // 상하좌우 및 대각선 열 이동
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessBoard = new int[N][N];

        for(int i=0; i<N; i++){
            visit = new boolean[N][N];
            System.out.println("i = " + i);
            System.out.println("--------------------");
            dfs(i);
        }

        System.out.println(sum);
    }

    private static void dfs(int depth) {
        if(depth == N){
            sum++;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(visit[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("====================");
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<dr.length; k++){
                    int nx = i + dr[k];
                    int ny = j + dc[k];

                    if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                    if(!visit[nx][ny]){
                        visit[nx][ny] = true;
                        dfs(depth+1);
                    }
                }
            }
        }
    }
}
