package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i] == arr[j]) continue;
                if((arr[i] + arr[j]) == x) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt/2);
    }
}


