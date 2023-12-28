package boj.dfs_bfs.mySolution;

/*
* 시간복잡도 : O(N^2 logN)???
* 아... 다른 사람들거 보니까...아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ하ㅏㅎ..나는 멍청이다!!
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단지번호붙이기_2667 {
    static int N; // 입력 밭는 변수
    static int[][] map; // 지도
    static boolean[][] visited; // 방문처리
    static int[] block_list; // 집이 있는 곳의 집들의 개수를 세어 저장되는 변수

    /*
    * 해당 dfs는 파라미터로 x축과 y축 그리고 어느 단지인지 알려주는 current라는 파라미터를 입력 받는다.
    * */
    private static boolean dfs(int x, int y, int current) {
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        if(!visited[x][y] && map[x][y] == 1){
            visited[x][y] = true;
            block_list[current]++;

            dfs(x-1, y, current);
            dfs(x+1, y, current);
            dfs(x, y-1, current);
            dfs(x, y+1, current);

            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받고 지도, 방문처리, 집 개수 저장에 대한 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        block_list = new int[N*N];


        // 지도 입력
        for(int i=0; i<N; i++){
             char[] str = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = str[j]-'0';
            }
        }

        int apt_complex=0; // 전체 아파트 단지 수
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]) continue;
                if(dfs(i,j,apt_complex)){
                    apt_complex++;
                }
            }
        }
        System.out.println(apt_complex);
        Arrays.sort(block_list);
        for(int num : block_list){
            if(num == 0) continue;
            System.out.println(num);
        }
    }
}
