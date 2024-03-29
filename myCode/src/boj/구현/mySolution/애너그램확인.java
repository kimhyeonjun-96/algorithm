package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 애너그램확인 {

    static String str1, str2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine().toLowerCase();
        str2 = br.readLine().toLowerCase();

        System.out.println(checkAnagram(str1, str2));

    }

    private static boolean checkAnagram(String str1, String str2) {


        if (str1.length() == str2.length()) {
            String[] str1List = str1.split("");
            String[] str2List = str2.split("");

            Arrays.sort(str1List);
            Arrays.sort(str2List);

            if(Arrays.equals(str1List, str2List)) return true;
        }

        return false;
    }
}
