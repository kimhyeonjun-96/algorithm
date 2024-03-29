package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 문자열중길이가가장긴것은 {


    static ArrayList<String> strList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            strList.add(st.nextToken());
        }

        System.out.println(getMaxLengthStr());

    }

    private static String getMaxLengthStr() {

        int max = 0;
        String result = "";
        for (String s : strList) {
            if (max < s.length()) {
                max = s.length();
                result = s;
            }
        }
        return result;
    }
}
