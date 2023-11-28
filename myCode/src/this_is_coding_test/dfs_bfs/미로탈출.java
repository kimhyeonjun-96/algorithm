package this_is_coding_test.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
public class 미로탈출 {

    public static int n, m;
    public static int[][] maze;

    public static int x_line[] = {-1 , 1, 0, 0};
    public static int y_line[] = {0 , 0, -1, 1};

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList();
        q.offer(new Node(x, y));

        while (!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            for(int i=0; i<4; i++){
                int nx = x + x_line[i];
                int ny = y + y_line[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maze[nx][ny] == 1){
                    maze[nx][ny] = maze[x][y] +1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return maze[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }
}
