package boj.dynamic.mySolution;

import java.io.*;

public class 파도반수열_9461 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[1001];
            bw.write(dp(arr, n) + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int dp(int[] arr, int n) {

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }

        return arr[n];
    }
}
