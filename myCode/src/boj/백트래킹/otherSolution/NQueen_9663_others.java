package boj.백트래킹.otherSolution;
/**
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663_others {
    static int N;
    static boolean[][] visit;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            dfs(0, i); // 첫 번째 행부터 시작
        }

        System.out.println(sum);
    }

    private static void dfs(int row, int col) {
        // 현재 위치에 퀸을 놓을 수 있는지 확인
        if (!isAttackable(row, col)) {
            visit[row][col] = true;

            // 마지막 행까지 퀸을 놓았다면 경우의 수 증가
            if (row == N - 1) {
                sum++;
            } else {
                // 다음 행으로 이동
                for (int i = 0; i < N; i++) {
                    dfs(row + 1, i);
                }
            }

            // 백트래킹
            visit[row][col] = false;
        }
    }

    private static boolean isAttackable(int row, int col) {
        // 상하좌우 및 대각선에 퀸이 있는지 확인
        for (int i = 0; i < N; i++) {
            if (visit[i][col] || visit[row][i] ||
                    (row - i >= 0 && col - i >= 0 && visit[row - i][col - i]) ||
                    (row - i >= 0 && col + i < N && visit[row - i][col + i]) ||
                    (row + i < N && col - i >= 0 && visit[row + i][col - i]) ||
                    (row + i < N && col + i < N && visit[row + i][col + i])) {
                return true;
            }
        }
        return false;
    }
}
