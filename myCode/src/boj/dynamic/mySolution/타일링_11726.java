package boj.dynamic.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링_11726 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        System.out.println(dp(arr, n));

    }

    private static int dp(int[] arr, int n) {

        arr[1] = 1; // 배열에 1, 2일 때의 값을 미리 넣어둔다.
        arr[2] = 2;

        for (int i = 3; i <= n; i++) { // 3부터 n까지의 값을 구한다.
            arr[i] = (arr[i-1] + arr[i-2]) % 10007; // 점화식 : D[n] = D[n-1] + D[n-2]
        }
        return arr[n];
    }
}
