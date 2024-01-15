package boj.greedy.oterhSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 두수의합_3273_others {
    static int N, X;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0, right = N - 1, cnt = 0;
        while (left < right){
            int sum = arr[left] + arr[right];
            if(sum == X){
                cnt++;
                left++;
                right--;
            }else if(sum > X){
                right--;
            }else {
                left++;
            }
        }
        System.out.println(cnt);
    }
}


