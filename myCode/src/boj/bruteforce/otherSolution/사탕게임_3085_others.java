package boj.bruteforce.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임_3085_others {
    static int N, resultMax = 0;
    static char[][] arr;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N]; // 사탕들을 저장

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 서로 다른 색의 사탕이 인접한 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽으로 교환
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    countCandies();
                    swap(i, j, i, j + 1); // 원복
                }

                // 아래로 교환
                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    countCandies();
                    swap(i, j, i + 1, j); // 원복
                }
            }
        }

        System.out.println(resultMax+1);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    static void countCandies() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[i][j] == arr[nx][ny]) {
                        int count = 1;
                        while (nx + dx[k] >= 0 && nx + dx[k] < N && ny + dy[k] >= 0 && ny + dy[k] < N
                                && arr[nx][ny] == arr[nx + dx[k]][ny + dy[k]]) {
                            nx += dx[k];
                            ny += dy[k];
                            count++;
                        }
                        resultMax = Math.max(resultMax, count);
                    }
                }
            }
        }
    }
}
