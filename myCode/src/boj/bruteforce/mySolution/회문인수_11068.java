package boj.bruteforce.mySolution;

/**
 * 구상도
 *  1. 테스트케이스(T)가 주어지면 테스트케이스만큼 반복한다.
 *  2. 각 테스트케이스마다 주어지는 정수가 주어진다.
 *  3. 해당 정수를 2진법부터 62진법까지 해당 수를 변환을 한다.
 *  4. 변환된 해당 정수가 회문이라면 더 이상의 진법변환을 종료하고 1을 출력한다.
 *  5. 만약 64진법까지 정수가 회문이 아니라면 0을 출력한다.
 */

import java.io.*;

public class 회문인수_11068 {

    static String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for(int i=2; i<=64; i++){
                String conversion = baseConversion(n, i);
                if(isPalindrome(conversion)) {
                    bw.write("1" + '\n');
                    break;
                }
                if(i == 64){
                    bw.write("0" + '\n');
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static String baseConversion(int n, int base){
        StringBuilder str = new StringBuilder();
        while (n>0){
            if(n%base > 9){
                str.append(digits.charAt(n % base - 10));
            }else{
                str.append(n % base);
            }
            n /= base;
        }
        return str.reverse().toString();
    }

    static boolean isPalindrome(String str){
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        return str.equals(reversed.toString());
    }
}
