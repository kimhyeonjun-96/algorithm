package boj.dfs_bfs.mySolution;
/**
 * 구상도
 *  1. 상자와 토마토들에 대한 정보를 입력 받는다.
 *  2. 상자들 만큼 반복을 하며 익은 토마토가 있다면 해당 위치부터 BFS탐색을 시작한다.
 *  3. BFS탐색을 하다 위/아래/앞/뒤/좌/우로 갔다면 하루 센다.
 *  4. 모든 박스를 탐색을 했다면 날짜를 출력한다, 단, 모든 박스를 탐색을 했음에도 익지 않은 토마토가 있다면 -1을, 모든 박스를 탐색을 했는데 모두 익어있다면 0을 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_7569{
    int h, x, y, day;

    public Node_7569(int h, int x, int y, int day) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class 토마토_7569 {
    static int n, m, h;
    static int[][][] box;
    static boolean[][][] visited;

    static int[] dh = {-1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 초기화
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        visited = new boolean[h][n][m];

        for(int height=0; height<h; height++){
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    int value = Integer.parseInt(st.nextToken());

                    box[height][i][j] = value;
                }
            }
        }
        int result = 0;
        for(int height=0; height<h; height++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(visited[height][i][j]) continue;
//                    result = bfs(height, i, j);
                    result = Math.max(result, bfs(height, i, j));
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int start_h, int start_x, int start_y) {
        Queue<Node_7569> q = new LinkedList<>();
        visited[start_h][start_x][start_y] = true;
        int day = 0;
        q.add(new Node_7569(start_h, start_x, start_y, day));

        while (!q.isEmpty()){
            Node_7569 node = q.poll();
            int cur_h = node.h;
            int cur_x = node.x;
            int cur_y = node.y;
            day = node.day;

            for(int height=0; height<3; height++){
                int next_h = cur_h + dh[height];

                if(next_h<0 || next_h>=h) continue;
                for(int i=0; i<4; i++){
                    int next_x = cur_x + dx[i];
                    int next_y = cur_y + dy[i];

                    if(next_x<0 || next_x>=n || next_y<0 || next_y>=m) continue;
                    if(!visited[next_h][next_x][next_y] && box[next_h][next_x][next_y] != -1){
                        visited[next_h][next_x][next_y] = true;
                        q.add(new Node_7569(next_h, next_x, next_y, day + 1));
                    }
                }
            }
        }
        return day;
    }
}
