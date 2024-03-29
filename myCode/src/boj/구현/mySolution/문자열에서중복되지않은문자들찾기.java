package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열에서중복되지않은문자들찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strList = br.readLine().toLowerCase().split("");

        for (int i = 0; i < strList.length; i++) {

            String curStr = strList[i];
            if(!isDuplicattion(curStr, strList, i)){
                sb.append(curStr).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static boolean isDuplicattion(String curStr, String[] strList, int idx) {

        for(int i=0; i<strList.length; i++){
            if(i == idx) continue;
            if(curStr.equals(strList[i])){
                return true;
            }
        }
        return false;
    }
}
