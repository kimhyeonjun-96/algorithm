package boj.dfs_bfs.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    private int x;
    private int y;
    private int cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getCnt(){
        return cnt;
    }
}
public class BucketBrigade_17198_others {

    static char[][] graph;
    static int[] x_line = {-1, 1, 0, 0};
    static int[] y_line = {0, 0, -1, 1};
    static int startX, startY, endX, endY;
    static boolean[][] visited;

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            int cur_cnt = node.getCnt();

            if(x == startX && y == startY){
                System.out.println(cur_cnt-1);
                break;
            }

            for(int j=0; j<4; j++){
                int nx = x + x_line[j];
                int ny = y + y_line[j];

                if(nx > -1 && nx < 10 && ny > -1 && ny < 10 &&  graph[nx][ny] != 'R'){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, cur_cnt+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new char[10][10];
        visited = new boolean[10][10];

        for(int i=0; i<graph.length; i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<graph[i].length; j++){
                if(str[j] == 'L'){
                    startX = i;
                    startY = j;
                }
                if (str[j] == 'B') {
                    endX = i;
                    endY = j;
                }
                graph[i][j] = str[j];
            }
        }
        bfs(endX,endY);
    }
}
