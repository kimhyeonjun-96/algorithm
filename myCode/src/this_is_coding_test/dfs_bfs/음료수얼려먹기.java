package this_is_coding_test.dfs_bfs;

/*
* 1. dfs 특징
*   dfs는 재귀 또는 스택으로 탐색을 한다. 어떤 방법을 할지 선택을 한다.
*   dfs는 반드시 탈출 조건이 필요하다. 해당 문제에서의 탈출 조건은
*   1. 주어진 N,M 범위 안에 있는가?
*   2. 방문을 했던 곳인가?
*   3. 값이 0인가?
*   위의 3개의 조건으로 탈출 조건을 만들었다.
* 2. 시간복잡도
*   O(NM)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {
    public static int N, M;
    public static int[][] frames;
    public static boolean[][] visited;

    public static boolean dfs(int x, int y){
        if( x <= -1 || x >= N || y <= -1 || y >= M) return false;

        if(frames[x][y] == 0 && !visited[x][y]){
            visited[x][y] = true;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        frames = new int[N][M];
        visited = new boolean[N][M];

        // 20번 반복
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                frames[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }

        int cnt = 0;
        // 20번 반복
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j)){
                    cnt += 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
