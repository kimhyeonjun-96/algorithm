package boj.구현.mySolution;
/**
 * 구상도
 *  1. N을 B로 나눈다. 만약 나머지가 9를 넘는다면 알맞은 알파벳으로 치환
 *  2. 몫은 B로 계속 나누기
 *  3. 몫이 0이 될 때까지 반복
 *  4. 이후에 나머지들을 역순으로 나열
 */


import boj.dfs_bfs.otherSolution.경로찾기_11403_others;

import java.io.*;
import java.util.StringTokenizer;

public class 진법변환2_11005 {

    static String digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String str = "";
        while (N>0){
            if(N%B > 9){
                str += digits.charAt(N % B - 10);
            }else{
                str += N % B;
            }
            N /= B;
        }

        char[] result = new char[str.length()];
        for(int i=str.length()-1; i>=0; i--){
            result[i] = str.charAt(i);
            bw.write(Character.toString(result[i]));
        }
        bw.flush();
        bw.close();
    }
}
