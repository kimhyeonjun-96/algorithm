package boj.dfs_bfs.mySolution;
/**
 * 구상도
 *  1. 적록색약이 아닌 사람으로 dfs 탐색 수행 후 영역의 수를 저장
 *  2. 그리드를 적록색약이 있는 사람의 것으로 변경
 *  3. 적록색약인 사람으로 bfs 탐색 수행 후 영역의 수를 저장
 *  4. 각 영역의 수를 출력
 */

import java.io.*;

public class 적록색약_10026_2 {
    static int n, rgb_cnt, rb_cnt;
    static char[][] greed;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        greed = new char[n][n];
        for(int i=0; i<n; i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                greed[i][j] = str[j];
            }
        }


        // 색약이 없는 사람의 영역 수 구하기
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                rgb_cnt += dfs(i, j, greed[i][j]);
            }
        }
        bw.write(rgb_cnt + " ");

        // 색약이 있는 사람의 그리드로 변경
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(greed[i][j] == 'G') greed[i][j] = 'R';
            }
        }

        // 색약인 사람의 영역 수 구하기
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]) continue;
                rb_cnt += dfs(i, j, greed[i][j]);
            }
        }
        bw.write(rb_cnt + " ");

        // 각 영역의 수 출력
        bw.flush();
        bw.close();
    }

    private static int dfs(int x, int y, char color) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
            if(!visited[nx][ny] && greed[nx][ny]==color){
                dfs(nx, ny, color);
            }
        }
        return 1;
    }
}
