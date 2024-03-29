package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열에서_특정값을_찾아라 {

    static int N, target, x, y;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        int idx = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j] = idx++;
                if(arr[i][j] == target) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println("(" + x + ", " + y + ")");
    }
}
