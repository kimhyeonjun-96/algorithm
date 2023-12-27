package boj.greedy.mySolution;

/*
* 시간복잡도 : O(n)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (n > 0){
            if(n%5 == 0){
                cnt += n / 5;
                break;
            }
            n -= 3;
            cnt++;

            if( n < 0){
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
//        while (n > 0){
//            if(n>=5 && n%5==0){
//                n -= 5;
//                cnt++;
//            }else if(n>=3 && n%3==0){
//                n -=  3;
//                cnt++;
//            }else{
//                cnt = -1;
//                break;
//            }
//        }
