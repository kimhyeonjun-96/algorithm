package boj.구현.mySolution;

/**
 * 구상도
 *  첫째, 모든 목판을 . 으로 채운다
 *  둘쨰, 현재 위치의 값이 . 이라면 상하좌우에 맞는 선, 즉 수평 또는 수직의 선을 그린다.
 *  셋째, 만약 현재 위치의 값이 이미 수직 또는 수평의 선이 있다면 + 모양의 선을 그린다.
 *  넷째, 현재 위치에 선을 그렸다면 다음 위치까지도 선을 그린다.
 *  다섯째, 모든 로봇의 움직임에 따라 선을 그린다.
 *  여섯째, 목판을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 판화_1730 {
    static int N, x=0, y=0;
    static char[][] board;
    static char[] movement;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        // 목판 채우기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = '.';
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        movement = st.nextToken().toCharArray();

        for(int i=0; i<movement.length; i++){
            drawLine(movement[i]); // 선 그리기
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    private static void drawLine(char move) {

        if (x >= 0 && x < N && y >= 0 && y < N) { // x, y 모두 범위 안에 있는지 확인
            if (move == 'U') { // 위로 가기
                if (board[x][y] == '.' || board[x][y] == '|') board[x][y] = '|'; // . 또는 | 이라면 그냥 | 그리기
                else if (board[x][y] == '-') board[x][y] = '+'; // - 이라면 + 그리기
                x--; // 다음 칸 이동
                if (x >= 0 && x < N) { // 다음 칸 이동 가능한지 확인
                    if (board[x][y] == '.' || board[x][y] == '|') board[x][y] = '|'; // . 또는 | 이라면 그냥 | 그리기
                    else if (board[x][y] == '-') board[x][y] = '+'; // - 이라면 + 그리기
                } else {
                    x++; // 왜 했지?
                }
            } else if (move == 'D') { // 아래 가기
                if (board[x][y] == '.' || board[x][y] == '|') board[x][y] = '|';
                else if (board[x][y] == '-') board[x][y] = '+';
                x++;
                if (x >= 0 && x < N) {
                    if (board[x][y] == '.' || board[x][y] == '|') board[x][y] = '|';
                    else if (board[x][y] == '-') board[x][y] = '+';
                } else {
                    x--;
                }
            } else if (move == 'R') {
                if (board[x][y] == '.' || board[x][y] == '-') board[x][y] = '-';
                else if (board[x][y] == '|') board[x][y] = '+';
                y++;
                if (y >= 0 && y < N) {
                    if (board[x][y] == '.' || board[x][y] == '-') board[x][y] = '-';
                    else if (board[x][y] == '|') board[x][y] = '+';
                } else {
                    y--;
                }
            } else if (move == 'L') {
                if (board[x][y] == '.' || board[x][y] == '-') board[x][y] = '-';
                else if (board[x][y] == '|') board[x][y] = '+';
                y--;
                if (y >= 0 && y < N) {
                    if (board[x][y] == '.' || board[x][y] == '-') board[x][y] = '-';
                    else if (board[x][y] == '|') board[x][y] = '+';
                } else {
                    y++;
                }
            }
        }
    }
}
