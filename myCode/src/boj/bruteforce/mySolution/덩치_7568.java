package boj.bruteforce.mySolution;

/**
 * 구상도
 *  1. 처음 사람부터 모든 사람까지 본인의 덩치 등수를 구하기 위해 탐색한다.
 *  2. 탐색조건으로 본인은 제외를 하고, 몸무게 그리고 키가 본인보다 커야만 한다.
 *  3. 등수를 구했다면 출력한다.
 *
 * 시간 복잡도
 *  O(n^2)
 */

import java.io.*;

public class 덩치_7568 {

    static int n;
    static int[][] grade;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grade = new int[n][2];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");

            grade[i][0] = Integer.parseInt(str[0]);
            grade[i][1] = Integer.parseInt(str[1]);
        }

        for(int i=0;i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                if(grade[i][0] == grade[j][0] && grade[i][1] == grade[j][1]) continue;
                if(grade[i][0] < grade[j][0] && grade[i][1] < grade[j][1]){
                    rank += 1;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
    }
}
