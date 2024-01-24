package boj.bruteforce.otherSolution;

import java.io.*;
import java.util.Scanner;

public class 회문인수_11068_others_2 {
    static char[] arr = new char[64];

    private static boolean isPal(String str) {
        String result = new StringBuffer(str).reverse().toString();
        return str.equals(result);
    }

    private static String pal(int n, int d) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.append(arr[n % d]);
            n /= d;
        }
        return sb.reverse().toString();
    }

    private static void preprocess() {
        for(int i=0; i<64; i++){
            if(i<10) arr[i] = (char) ('0' + i);
            else if(i<36) arr[i] = (char) ('A' + i - 10);
            else if(i<62) arr[i] = (char) ('a' + i - 36);
            else if(i==62) arr[i] = '+';
            else arr[i] = '/';
        }
    }
    public static void main(String[] args) {
        preprocess();

        for (char c : arr) {
            System.out.println(c);
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            boolean found = false;
            for(int i=2; i<65; i++){
                String check = pal(n, i);

                if(isPal(check)){
                    found = true;
                    System.out.println(1);
                    break;
                }
            }
            if(!found) System.out.println(0);
        }
    }

}
