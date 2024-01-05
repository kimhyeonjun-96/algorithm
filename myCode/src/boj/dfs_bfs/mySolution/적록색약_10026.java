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

    // 상하좌우를 DFS로 탐색하며 색을 확인
    // 특이점은 check !=0 이라면 greed[nx][ny]의 색이 G이라면 R로 변경되도록 작성
    private static int dfs(int check, int x, int y, char color) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            greed[nx][ny] = (check != 0) ? (greed[nx][ny] == 'G' ? 'R' : greed[nx][ny]) : greed[nx][ny];

            if(!visited[nx][ny] && color == greed[nx][ny]) {
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

        // 그리드에 색 채우기
        for(int i=0; i<n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                greed[i][j] = line[j];
            }
        }

        // 정상과 색약만큼 반복하며 각 구역의 색 구하기
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
