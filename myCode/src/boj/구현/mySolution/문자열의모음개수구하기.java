package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열의모음개수구하기 {

    static char[] vowelList = {'a', 'e', 'i', 'o', 'u'};
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < vowelList.length; j++) {
                if(str.charAt(i) == vowelList[j]) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println("cnt = " + cnt);
    }
}
