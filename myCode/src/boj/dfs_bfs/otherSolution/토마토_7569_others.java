package boj.dfs_bfs.otherSolution;

/**
 * 첫번째 구상도
 *  1. 익은 토마토의 위치를 알아낸다.
 *  2. 익은 토마토의 위치부터 익지 않은 토마토를 찾는다.
 *  3. 모든 박스를 탐색하며 모든 토마토가 익은 날을 세어 출력한다.
 *
 * 한계
 *  익은 토마토는 하나가 아니라 여러개이다. 그렇기에 익은 토마토들을 먼저 큐에 담고 차례로 익은 토마토가 영향력을 끼치게 되는 날을 구해야했다..
 *  그리고 아래와 같은 소스로 변경을 하였을 때...한참을 정상 작동하지 않았다. 계속 +2의 날짜가 나왔다..
 *  왜그런지 몰랐는데...
 *  q.add(new Node_7569_others(next_h, cur_x, cur_y, day+=1));으로 해서 day가 계속 더해져 저장되었다...아나...
 *
 * 두번째 구상도
 *  1. 익은 토마토들을 모두 저장한다.
 *  2. 익은 토마토들이 저장된 큐가 모두 빌 떄까지 BFS 탐색을 하여 모든 상자를 탐색한다.
 *  3. 모든 상자를 탐색을 하여 걸린 날을 세어 반환한다. 이때, 익지 않은 토마토가 있다면 -1을 반환한다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_7569_others {
    int h, x, y, day;

    public Node_7569_others(int h, int x, int y, int day) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class 토마토_7569_others {
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

        // 탐색 시작
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node_7569_others> q = new LinkedList<>();
        int day = 0;

        // 익은 토마토들을 모두 큐에 넣어야 한다.
        for(int height=0; height<h; height++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(box[height][i][j] == 1){
                        visited[height][i][j] = true;
                        q.add(new Node_7569_others(height, i, j, day));

                    }
                }
            }
        }

        // 탐색 수행
        while (!q.isEmpty()) {
            Node_7569_others node = q.poll();
            int cur_h = node.h;
            int cur_x = node.x;
            int cur_y = node.y;
            day = node.day;


            // 높이 BFS 탐색
            for (int height = 0; height < 2; height++) {
                int next_h = cur_h + dh[height];
                if (next_h < 0 || next_h >= h) continue;


                if (!visited[next_h][cur_x][cur_y] && box[next_h][cur_x][cur_y] == 0) {
                    visited[next_h][cur_x][cur_y] = true;
                    q.add(new Node_7569_others(next_h, cur_x, cur_y, day+1));
                }
            }

            // 상,하,좌,우 BFS 탐색
            for(int i=0; i<4; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if(next_x<0 || next_x>=n || next_y<0 || next_y>=m) continue;

                if(!visited[cur_h][next_x][next_y] && box[cur_h][next_x][next_y] == 0){
                    visited[cur_h][next_x][next_y] = true;
                    q.add(new Node_7569_others(cur_h, next_x, next_y, day+1));
                }
            }
        }

        // 익지 않은 토마토가 남아있는지 확인
        for(int height=0; height<h; height++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(box[height][i][j] == 0 && !visited[height][i][j]) {
                        return -1;
                    }
                }
            }
        }
        return day;
    }
}

//            for(int height=0; height<2; height++){
//                int next_h = cur_h + dh[height];
//                if(next_h<0 || next_h>=h) continue;
//
//                for(int i=0; i<4; i++){
//                    int next_x = cur_x + dx[i];
//                    int next_y = cur_y + dy[i];
//
//                    if(next_x<0 || next_x>=n || next_y<0 || next_y>=m) continue;
//
//                    if(!visited[next_h][next_x][next_y] && box[next_h][next_x][next_y] == 0){
//                        System.out.println("next_h=" + next_h + ", next_x=" + next_x + ", next_y=" + next_y);
//                        visited[next_h][next_x][next_y] = true;
//                        q.add(new Node_7569_others(next_h, next_x, next_y, day += 1));
////                        System.out.println(day + "일에 익는 토마토 위치 -> {" + "h=" + next_h + ", x=" + next_x + ", y=" + next_y +"}");
//                    }
//                }
//            }