package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* N*M 크기의 배열로 표현되는 미로
* 미로에서 1은 이동 가능, 0은 이동 불가 칸
* (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하라
*
* 정수 N, M 입력 ( 2<= N,M <= 100 )
* N개의 줄에는 M개의 정수로 미로 입력  ( 각 정수들은 붙어서 입력 )
* */

class Node_2178{
    int x, y, cnt;

    public Node_2178(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Node_2178{" +
                "x=" + x +
                ", y=" + y +
                ", cnt=" + cnt +
                '}';
    }
}
public class 미로탐색_2178 {

    static int N,M;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int x, int y){
        Queue<Node_2178> q = new LinkedList<>();

        q.offer(new Node_2178(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Node_2178 current = q.poll();
            int current_x = current.x;
            int current_y = current.y;
            int cnt = current.cnt;

            if(current_x == N-1 && current_y == M-1) return cnt;

            for(int i=0; i<4; i++){
                int next_x = current_x + dx[i];
                int nexxt_y = current_y + dy[i];

                if(next_x <= -1 || next_x >= N || nexxt_y <= -1 || nexxt_y >= M) continue;
                if( !visited[next_x][nexxt_y] && graph[next_x][nexxt_y]==1){
                    q.offer(new Node_2178(next_x, nexxt_y, cnt+1));
                    visited[next_x][nexxt_y] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<chars.length; j++){
                graph[i][j] = chars[j]-'0';
            }
        }

//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                System.out.print(graph[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(bfs(0,0));
    }
}
