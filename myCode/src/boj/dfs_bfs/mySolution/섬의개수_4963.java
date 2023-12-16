package boj.dfs_bfs.mySolution;

import java.io.*;

public class 섬의개수_4963 {
    static int w,h;
    static int[][] map;
    static boolean[][] v;

    static boolean dfs(int x, int y){

        if(x <= -1 || x >= h || y <= -1 || y >= w) return false;
        if(!v[x][y] && map[x][y] == 1){
            v[x][y] = true;

            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            dfs(x-1, y-1);
            dfs(x-1, y+1);
            dfs(x+1, y-1);
            dfs(x+1, y+1);

            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String[] str = br.readLine().split(" ");
            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);

            // 테스트케이스 종료
            if(w ==0 && h == 0){
                break;
            }

            // 지도 초기화
            map = new int[h][w];
            for(int i=0; i<h; i++){
                str = br.readLine().split(" ");
                for(int j=0; j<str.length; j++){
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            // 방문여부 초기화
            v = new boolean[h][w];

            // 지도 확인
            /*for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }*/

            // 섬의 개수 구하기
            int cnt = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(v[i][j]) continue;
                    if( dfs(i, j) ) cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}
