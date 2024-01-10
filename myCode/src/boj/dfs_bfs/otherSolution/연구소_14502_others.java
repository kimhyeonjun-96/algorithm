package boj.dfs_bfs.otherSolution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소_14502_others {
    static int N, M;
    static int[][] originalLab;
    static int maxSafeArea = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        originalLab = new int[N][M];

        // 연구소 초기 상태 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                originalLab[i][j] = sc.nextInt();
            }
        }

        buildWallsAndCalculateSafeArea(originalLab);

        System.out.println(maxSafeArea);
    }

    static void buildWallsAndCalculateSafeArea(int[][] lab) {
        for (int i = 0; i < N * M; i++) {
            int x1 = i / M;
            int y1 = i % M;
            if (lab[x1][y1] == 0) {
                for (int j = i + 1; j < N * M; j++) {
                    int x2 = j / M;
                    int y2 = j % M;
                    if (lab[x2][y2] == 0) {
                        for (int k = j + 1; k < N * M; k++) {
                            int x3 = k / M;
                            int y3 = k % M;
                            if (lab[x3][y3] == 0) {
                                int[][] clonedLab = deepCopy(lab);
                                clonedLab[x1][y1] = 1;
                                clonedLab[x2][y2] = 1;
                                clonedLab[x3][y3] = 1;

                                calculateSafeArea(clonedLab);
                            }
                        }
                    }
                }
            }
        }
    }

    static void calculateSafeArea(int[][] lab) {
        int[][] tempLab = deepCopy(lab);
        Queue<int[]> queue = new LinkedList<>();

        // 초기 바이러스 위치 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS로 바이러스 퍼뜨리기
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역 크기 계산
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        // 최대 안전 영역 업데이트
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    static int[][] deepCopy(int[][] original) {
        int[][] result = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[0].length);
        }
        return result;
    }
}
