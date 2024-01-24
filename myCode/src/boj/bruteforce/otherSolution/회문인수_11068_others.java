package boj.bruteforce.otherSolution;

/**
 * 해당 코드도 백준에서는 틀렸다고 나옴
 */

import java.io.*;

public class 회문인수_11068_others {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if(isPossiblePalindrom(n)){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPossiblePalindrom(int n) {
        for (int base = 2; base <= 64; base++) {
            String conversion = Integer.toString(n, base);
            if (isPalindrom(conversion)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isPalindrom(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return str.equals(reversed.reverse().toString());
    }
}
