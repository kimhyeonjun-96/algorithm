package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열을단어단위로뒤집어라 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        String[] strList = str.split(" ");

        for (int i = strList.length-1; i>=0; i--) {
            String s = strList[i];
            sb.append(s).append(" ");
        }

        System.out.println(sb);
    }
}
