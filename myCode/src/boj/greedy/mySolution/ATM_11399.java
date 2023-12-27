package boj.greedy.mySolution;

/*
* 시간복잡도 : O(nlogn)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 초기화
        int n = Integer.parseInt(br.readLine());
        int[] time_list = new int[n];
        int[] sum_list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            time_list[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(time_list);
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += time_list[i];
            sum_list[i] = sum;
        }


        System.out.println(Arrays.stream(sum_list).sum());
//        int totalSum = 0;
//        for(int i=0; i<n; i++){
//            totalSum += sum_list[i];
//        }
//        System.out.println(totalSum);
    }
}
