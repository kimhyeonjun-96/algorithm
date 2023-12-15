package boj.구현.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커_1316_other {
    static boolean isGroupWord(String word){
        boolean[] v = new boolean[26];

        for(int i=0; i<word.length(); i++){
            char curChar = word.charAt(i);

            if(v[curChar-'a'] && word.charAt(i-1) != curChar){
                return false;
            }
            v[curChar-'a'] = true;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i=0; i<n; i++){
            String word = br.readLine();
            if(isGroupWord(word)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
