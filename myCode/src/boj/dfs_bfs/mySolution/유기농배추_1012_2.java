package boj.dfs_bfs.mySolution;

import java.io.*;
import java.util.StringTokenizer;

public class 유기농배추_1012_2 {
    static int t, m, n, k;
    static int[][] grahp;
    static boolean[][] v;

    static boolean dfs(int x, int y){

        if(x <= -1 || x >= m || y <= -1 || y >= n) return false;
        if( grahp[x][y] == 1 && !v[x][y]){
            v[x][y] = true;

            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);

            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            // 데이터 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grahp = new int[m][n];
            v = new boolean[m][n];

            // 그래프 초기화
            for(int j=0; j<k; j++){
                String[] str = br.readLine().split(" ");
                grahp[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
            }

            // 그래프 확인
            /*for(int j=0; j<m; j++){
                for(int l=0; l<n; l++){
                    System.out.print(grahp[j][l]);
                }
                System.out.println();
            }*/

            // 배추흰지렁이 마리 수 구하기
            int cnt=0;
            for(int j=0; j<m; j++){
                for(int l=0; l<n; l++){
                    if(v[j][l]) continue;
                    if( dfs(j,l) ){
                        cnt+=1;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
