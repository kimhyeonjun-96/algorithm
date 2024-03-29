package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 단어뒤집기_9093 {

    static int T ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            String[] strList = str.split(" ");

            for (int i = 0; i < strList.length; i++) {
                for (int j = strList[i].length()-1; j >= 0; j--) {
                    sb.append(strList[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
