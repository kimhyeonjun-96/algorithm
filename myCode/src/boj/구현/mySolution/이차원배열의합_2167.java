package boj.구현.mySolution;

import java.io.*;
import java.util.StringTokenizer;

public class 이차원배열의합_2167 {

    static int N, M, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int moveX = i - 1; moveX < x; moveX++) {
                for (int moveY = j - 1; moveY < y; moveY++) {
                    sum += arr[moveX][moveY];
                }
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
