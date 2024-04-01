package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열에서중복을제거요소와길이를구하라 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        deleteDuplicate();

        System.out.println("중복 제거 요소 : " + Arrays.toString(arr));
        System.out.println("중복 제거 요소의 길이 : " + arr.length);

    }

    private static void deleteDuplicate() {

        int[] tmp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    tmp[j] = -1;
                }
            }
        }

        int cnt = 0;
        for (int val : tmp) {
            if(val != -1){
                cnt++;
            }
        }

        arr = new int[cnt];
        int idx = 0;
        for (int val : tmp) {
            if(val != -1) {
                arr[idx] = val;
                idx++;
            }
        }
    }

}
