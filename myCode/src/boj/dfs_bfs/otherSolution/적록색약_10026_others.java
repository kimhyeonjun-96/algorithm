package boj.dfs_bfs.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://loosie.tistory.com/304
 * 그릿 속의 해빗 블로그에 작성된 구상
 *  1. map을 두 가지 케이스로 (R,G,B)맵을 입력 받아 DFS탐색을 통해 해당 영역이 몇 개의 영역으로 나누어져있는지 조사
 *  2. 1번의 그래프를 (R==G,B)맵으로 바꿔주고 해당 맵을 다시 DFS탐색을 통해 조사한다.
 */

public class 적록색약_10026_others {

    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        checked = new boolean[n][n];

        int cnt = 0;
        int rgCnt = 0;


        // 색을 입력받아 R=1, G=2, B=3으로 치환하여 맵에 저장
        for(int i=0; i<n; i++){
            String[] color = br.readLine().split("");
            for(int j=0; j<n; j++){
                if(color[j].equals("R")) map[i][j] = 1;
                else if (color[j].equals("G")) map[i][j] = 2;
                else map[i][j] = 3;
            }
        }

        // 정상적인 사람의 구역 구하기
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=1; k<4; k++){
                    if(!checked[i][j] && map[i][j] == k){
                        dfs(i, j, k);
                        cnt++;
                    }
                }
            }
        }

        // 맵 변경
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    map[i][j] = 2;
                }
            }
        }

        // 바뀐 맵으로 색약의 구역 구하기
        checked = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=2; k<4; k++){
                    if(!checked[i][j] && map[i][j] == k){
                        dfs(i,j,k);
                        rgCnt++;
                    }
                }
            }
        }

        System.out.println(cnt + " " + rgCnt);

    }

    private static void dfs(int x, int y, int color) {
        checked[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
            if(checked[nx][ny]) continue;

            if(map[nx][ny] == color){
                dfs(nx, ny, color);
            }
        }
    }
}
