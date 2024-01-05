package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 안정영역_2468 {
    static int n, max_h=0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

//    static int dfs(int cur_h, int cnt){
//    static int dfs(int cur_h){
//        for(int i=0; i<map.length; i++){
//            for(int j=0; j<map[i].length; j++){
//                if(!visited[i][j] && map[i][j] > cur_h) {
//                    for (int k = 0; k < 4; k++) {
//                        int nx = i + dx[k];
//                        int ny = j + dy[k];
//
//                        if (nx > -1 && nx < n && ny > -1 && ny < n) {
//                            if (!visited[nx][ny] && map[nx][ny] > cur_h) {
//                                visited[nx][ny] = true;
//                                dfs(cur_h);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return 1;
//    }

//    private static int dfs(int x, int y, int h) {
//        visited[x][y] = true;
//
//        for(int i=0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
//            if(!visited[nx][ny] && map[nx][ny] > h){
//                dfs(nx, ny, h);
//            }
//        }
//        return 1;
//    }

    private static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(!visited[nx][ny] && map[nx][ny] >= h){
                dfs(nx, ny, h);
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<str.length; j++){
                int cur = Integer.parseInt(str[j]);
                map[i][j] = cur;
                if(max_h < cur){
                    max_h = cur;
                }
            }
        }

        int result = 0;
        for(int h=1; h<=max_h; h++){
            int cnt = 0;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] >= h) {
                        dfs(i, j, h);
                        cnt+=1;
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
//        int[] safe_areas = new int[max_h+1];
//
//        for(int i=1; i<=max_h; i++){
//            safe_areas[i] = dfs(i, 0);
//        }
//
//        System.out.println(Arrays.stream(safe_areas).max());
    }
}