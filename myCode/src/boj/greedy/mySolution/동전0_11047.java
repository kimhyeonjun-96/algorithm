package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 동전0_11047 {

    static void reverseOrder(int n, int[] arr){
        // 선택정렬로 시간복잡도가 O(n^2)
        // 너무 느림
        for(int i=0; i<n/2; i++){
            int tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

//        reverseOrder(n, arr);
        Arrays.sort(arr, Comparator.reverseOrder());

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(k >= arr[i]){
                cnt += k / arr[i];
                k %= arr[i];
            }
        }
        System.out.println(cnt);

        // 시간 초과 ( while문 때문인것 같음..) 정렬 로직을 작성하기 싫어서 안했는데 해야하는 것 같다.
//        int cnt = 0;
//        while (k > 0){
//            for(int i=arr.length-1; i>0; i--){
//                if(k >= arr[i]){
//                    k -= arr[i];
//                    cnt++;
//                    break;
//                }
//            }
//        }
//        System.out.println(cnt);
    }
}
