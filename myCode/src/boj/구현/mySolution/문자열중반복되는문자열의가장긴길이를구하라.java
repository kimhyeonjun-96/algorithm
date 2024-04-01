package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열중반복되는문자열의가장긴길이를구하라 {


    static String str;
    static int max;

    static char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};
    static int[] countList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toLowerCase();
        countList = new int[arr.length];

        for (int i = 0; i < str.length(); i++) { // ababa
            for (int j = 0; j < arr.length; j++) {
                if (str.charAt(i) == arr[j]) {
                    countList[j]++;
                }
            }
        }

        for (int cnt : countList) {
            max = Math.max(max, cnt);
        }

        System.out.println("가장 긴 반복 부분 문자열의 길이: " + max);
    }
}
