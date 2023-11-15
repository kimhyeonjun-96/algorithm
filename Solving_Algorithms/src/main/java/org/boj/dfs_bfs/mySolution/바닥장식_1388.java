package org.boj.dfs_bfs.mySolution;

import java.util.Scanner;

public class 바닥장식_1388 {

    public static int N, M;
    public static char[][] graph = new char[51][51];

    private static boolean dfs(int x, int y) {
        // x, y가 범위를 넘어서지는 않는지 확인
        if(x<=-1 || x>=N || y<=-1 || y>=M)
            return false;

        // '-' 라면 같은 행으로만 확인
        if(graph[x][y] == '-'){
            graph[x][y] = '*';
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
//            System.out.println("graph[" + x + "]" + "[" + y + "]" + " : -");
        }
        // '|' 라면 같은 열로만 확인
        else if (graph[x][y] == '|') {
            graph[x][y] = '*';
            dfs(x-1, y);
            dfs(x+1, y);
            return true;
//            System.out.println("graph[" + x + "]" + "[" + y + "]" + " : |");
        }
        return false;
    }
    public static void main(String[] args) {
        // N, M을 읽어들이기 위해 준비
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        // 그래프 초기화, 띄어쓰기 없이 값을 입력
        for(int i=0; i<N; i++){
            String str = sc.nextLine();
            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        // 나무판자가 몇개인지 dfs메서드를 통하여 확인
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j))
                    count++;
            }
        }
        System.out.println(count);
    }
}
