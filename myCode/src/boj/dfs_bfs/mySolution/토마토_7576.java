package boj.dfs_bfs.mySolution;
/**
 * 구상도
 *  1. 상자와 토마토의 정보를 입력 받는다.
 *  2. 상자에 대한 BFS탐색을 수행한다.
 *  3. 익은 토마토들에 대한 정보를 저장한다.
 *  4. 익은 토마토들로부터 상/하/좌/우에 있는 토마토들이 익는데, 이 때 일수를 센다.
 *  5. 상자를 모두 탐색하면 토마토가 모두 익었다면 일수를 반환하고, 익지 않은 토마토가 있다면 -1을 반환한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_7576{
    int x, y, day;
    public Node_7576(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class 토마토_7576 {
    static int m, n;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node_7576> q = new LinkedList<>();
        int day = 0;

        //익은 토마토에 대한 정보 저장
        save_ripe_tomato(q);

        while (!q.isEmpty()){
            Node_7576 node = q.poll();

            int cur_x = node.x;
            int cur_y = node.y;
            day = node.day;

            for(int i=0; i<4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && box[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.add(new Node_7576(nx, ny, day + 1));
                }
            }
        }

        // 안 익은 토마토 있는지 확인
        if(!check_tomato()){
            return -1;
        }
        return day;
    }
    private static boolean check_tomato() {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && box[i][j]==0) return false;
            }
        }
        return true;
    }

    private static void save_ripe_tomato(Queue<Node_7576> q) {
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(box[i][j] == 1){
                    q.add(new Node_7576(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
    }
}
