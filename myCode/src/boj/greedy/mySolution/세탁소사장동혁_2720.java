package boj.greedy.mySolution;

import java.io.*;

public class 세탁소사장동혁_2720 {

    static int[] coin_list = {25, 10, 5, 1};
    static void change_back(int money, int[] count_list){

        for(int i=0; i<count_list.length; i++){
            count_list[i] = money/coin_list[i];
            money %= coin_list[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int C = Integer.parseInt(br.readLine());
            int [] count_list = new int[4];
            change_back(C, count_list);

            for(int j=0; j< count_list.length; j++){
                bw.write(count_list[j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
