package boj.백트래킹.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬탈출_13459 {

    static int N, M, startX, startY;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') {
                    System.out.println(i + " " + j);
                    startX = i;
                    startY = j;
                } else if (board[i][j] == '#') {
                    visit[i][j] = true;
                }
            }
        }

        bfs()

    }
}
