package boj.구현.mySolution;

import java.io.*;
import java.util.StringTokenizer;

public class ACM호텔_10250 {
    static int T,H,W, N;
    static int[][] hotel;
    static boolean[][] checkIn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            hotel = new int[H+1][W+1];
            checkIn = new boolean[H+1][W+1];

            int cnt = 1;
            for(int k=1; k<=W; k++){
                for(int j=1; j<=H; j++){
                    if(cnt == N) {
                        if(k < 10){
                            bw.write(j + "0" + k);
                        }else{
                            bw.write(j + ""  + k);
                        }
                    }
                    cnt++;
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
