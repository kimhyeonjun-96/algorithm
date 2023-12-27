package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_5585 {
    static int[] coin_list = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pay = 1000 - Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<coin_list.length; i++){
            if(pay >= coin_list[i]){
                cnt += pay/coin_list[i];
                pay = pay%coin_list[i];
            }
        }
        System.out.println(cnt);
    }
}

//        while (pay > 0){
//            for(int i=0; i<coin_list.length; i++){
//                if(pay-coin_list[i] >= 0){
//                    pay -= coin_list[i];
//                    cnt++;
//                    break;
//                }
//            }
//        }