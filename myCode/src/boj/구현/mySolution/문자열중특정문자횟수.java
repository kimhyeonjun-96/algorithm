package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열중특정문자횟수 {

    static String str, target;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        target = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target.charAt(0)) {
                cnt++;
            }
        }

        System.out.println("cnt = " + cnt);
    }
}
