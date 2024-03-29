package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열의숫자의합을구하기 {

    public static char[] numList = {'0','1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strList = br.readLine().split("");
        int sum = 0;

        for (String s : strList) {
            if (isInteger(s)) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println("sum = " + sum);
    }

    private static boolean isInteger(String s) {

        for (char c : numList) {
            if (s.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

}
