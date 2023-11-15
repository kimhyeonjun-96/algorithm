package org.boj.dfs_bfs.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestGrass_6186 {
    public static int R, C;
    public static boolean[][] visited;
    public static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        graph = new char[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if (visited[i][j]) continue;
                if(dfs(i,j)) count++;
            }
        }
        System.out.println(count);
    }

    private static boolean dfs(int x, int y) {

        visited[x][y] = true;
        if( x < 0 || x >= R || y < 0 || y >= C) return false;

        if(graph[x][y] == '#'){
            // 상하
            if(x+1 < R && graph[x+1][y] == '#'){
                dfs(x+1, y);
            }
            // 좌우
            if(y+1 < C && graph[x][y+1] == '#'){
                dfs(x, y+1);
            }
            return true;
        }

        return false;
    }
}
