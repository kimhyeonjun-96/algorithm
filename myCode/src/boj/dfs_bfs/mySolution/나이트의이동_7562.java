package boj.dfs_bfs.mySolution;
/**
 * 구상도
 *  1. 테스트케이스만큼 반복한다.
 *  2. 시작위치 부터 목적지까지 이동하는 방법을 BFS로 탐색한다.
 *  3. 목적지까지 이동하였다면 이동한 횟수를 반환한다.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_7562{
    int x, y, cnt;
    public Node_7562(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class 나이트의이동_7562 {
    static int t, l;
    static int start_x, start_y, dest_x, dest_y;

    static int[][] board;
    static boolean[][] visited;
    static int[][] moved = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        // 테스트케이스만큼 반복
        while (t-- > 0){
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dest_x = Integer.parseInt(st.nextToken());
            dest_y = Integer.parseInt(st.nextToken());

            // 시작위치 부터 목적지까지 가는 이동 횟수를 구하여 저장
            bw.write(bfs(start_x, start_y) + "\n");
        }

        // 결과 출력
        bw.flush();
        bw.close();
    }

    private static int bfs(int startX, int startY) {
        Queue<Node_7562> q = new LinkedList<>();
        int cnt = 0;

        q.add(new Node_7562(startX, startY, cnt));
        visited[startX][startY] = true;

        while (!q.isEmpty()){
            Node_7562 cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            cnt = cur.cnt;

            if(x == dest_x && y == dest_y) return cnt;

            for(int i=0; i<moved.length; i++){
                int nx = x + moved[i][0];
                int ny = y + moved[i][1];

                if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Node_7562(nx, ny, cnt + 1));
                }
            }
        }
        return cnt;
    }
}

// 확인
//        int x = Integer.parseInt(st.nextToken());
//        int y = Integer.parseInt(st.nextToken());
//
//        System.out.println("x : " + x + ", y : " + y);
//
//        for(int i=0; i<moved.length; i++){
//            System.out.println("현재 이동 x값 : " + moved[i][0] + ", 현재 이동 y값 " + moved[i][1]);
//            System.out.println( (x+moved[i][0]) + ", " + (y+moved[i][1]) );
//            System.out.println("=======================================================================");
//        }
