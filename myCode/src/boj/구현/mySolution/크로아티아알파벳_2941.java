package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳_2941 {
    static String[] croatia_alpabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt =0;
        int idx = 0;

        while (idx < str.length()){
            boolean found = false;

            for(String pattern : croatia_alpabet){
                if(str.substring(idx).startsWith(pattern)){
                    idx += pattern.length();
                    found = true;
                    break;
                }
            }
            if(!found) idx++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
