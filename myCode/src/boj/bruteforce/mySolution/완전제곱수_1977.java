package boj.bruteforce.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 완전제곱수_1977 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0; // 완전제곱수의 총 합
        int min = 0; // 완전제곱수 중 최솟값

        for(int i=1; i<=n; i++){
            int num = i*i; 

            if(num >= m && num <= n){
                sum += num;
                if(min == 0) min = num;
                if( min > num ){
                    min = num;
                }
            }
        }

        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}
