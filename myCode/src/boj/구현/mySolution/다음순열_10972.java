package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다음순열_10972 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (nextPermutation()) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
        }else{
            System.out.println(-1);
        }


    }

    private static boolean nextPermutation(){
        int i = arr.length - 1;

        // 1. arr[i-1] < arr[i]를 만족하는 가장 큰 i 찾기
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i -= 1;
        }
        // i의 취이가 0이면 내림차순(즉, 마지막 순열)
        if (i <= 0) {
            return false;
        }

        // 2. j >= i이면서 arr[j] > arr[i-1]을 만족하는 가장 큰 j 찾기
        int j = arr.length-1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        //3. A[i-1]과 A[j] 를 swap 한다.
        swap(i - 1, j);

        //4. A[i] 부터 끝가지 순열을 오름차순으로 정렬한다.
        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
