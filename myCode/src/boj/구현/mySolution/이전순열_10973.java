package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이전순열_10973 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prevPermutation()) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
        }else{
            System.out.println(-1);
        }
    }

    private static boolean prevPermutation() {

        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
