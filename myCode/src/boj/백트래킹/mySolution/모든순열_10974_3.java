package boj.백트래킹.mySolution;
/**
 * 순열 연습을 위한 문제 풀이
 * 1. swap을 이용한 순열 구현 - 사전순으로 나올 수 있도록 추가해야함
 * 2. visited 배열을 이용한 dfs로 순열 구현
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열_10974_3 {

    static int N;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        setArr();
        result = new int[N];
        visited = new boolean[N];

        System.out.println("----- swap을 이용한 순열 -----");
        permutation1(0);
        System.out.println("----- dfs를 이용한 순열 -----");

        setArr();
        permutation2(0);
        System.out.println(sb);

    }

    private static void setArr() {
        for(int i=0; i<N; i++){
            arr[i] = i + 1;
        }
    }

    private static void permutation1(int depth){
        if (depth == N) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < N; i++) {
            swap(depth, i);
            permutation1(depth + 1);
            swap(depth, i);
        }
    }

    private static void swap(int depth, int i) {
        int tmp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = tmp;

        Arrays.sort(arr, depth + 1, N);
    }

    private static void permutation2(int depth) {
        if (depth == N) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation2(depth + 1);
                visited[i] = false;
            }
        }
    }
}
