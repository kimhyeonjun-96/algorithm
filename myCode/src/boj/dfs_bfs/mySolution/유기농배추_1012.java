package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node1012{
    int x, y;

    public Node1012(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 유기농배추_1012 {

    static int t, m, n, k, cnt;
    static int[][] graph;
    static boolean[][] v;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs(int y, int x){
        Queue<Node1012> q = new LinkedList();
        q.add(new Node1012(y, x));
        v[y][x] = true;

        while (!q.isEmpty()){
            Node1012 node = q.poll();
            x = node.x;
            y = node.y;

            for(int i=0; i<4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if( next_x >= m && next_x <= -1 && next_y >= n && next_y <= -1 ) continue;
                if( !v[next_y][next_x] && graph[next_y][next_x] == 1 ){
                    q.add(new Node1012(next_y, next_x));
                    v[next_y][next_x] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int l=0; l<t; l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            v = new boolean[n][m];
            cnt = 0;

            for(int i=0; i<k; i++){
                String[] str = br.readLine().split(" ");
                graph[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }

            // 그래프 확인
/*            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    System.out.print(graph[i][j]);
                }
                System.out.println();
            }*/

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(graph[i][j] == 1 && !v[i][j]){
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
