package boj.dynamic.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {

    static int size;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = longestIncreasingSubsequence();
        System.out.println("maxLength = " + maxLength);
    }

    private static int longestIncreasingSubsequence() {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
