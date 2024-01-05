package boj.dfs_bfs.mySolution;

/**
 * test01
 *  5
 *  RRRBB
 *  GGBBB
 *  BBBRR
 *  BBRRR
 *  RRRRR
 *  >> 4 3
 *
 * test02
 *  3
 *  RGB
 *  GGB
 *  RRR
 *  >> 4 2
 *
 *  왜 틀리다고 나오는걸까...하아....
 */


import java.io.*;
public class 적록색약_10026 {
    static int n;
    static char[][] greed;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int dfs(int check, int x, int y, char c) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            greed[nx][ny] = (check != 0) ? (greed[nx][ny] == 'G' ? 'R' : greed[nx][ny]) : greed[nx][ny];

            if(!visited[nx][ny] && c == greed[nx][ny]) {
                dfs(check, nx, ny, greed[nx][ny]);
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        greed = new char[n][n];

        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                greed[i][j] = line[j];
            }
        }

        for(int m=0; m<2; m++){
            visited = new boolean[n][n];
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]) continue;
                    cnt += dfs(m, i, j, greed[i][j]);
                }
            }
            bw.write(cnt + " ");
        }
        bw.flush();
        bw.close();
    }
}
