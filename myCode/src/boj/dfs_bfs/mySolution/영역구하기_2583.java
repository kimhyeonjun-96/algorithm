package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node_2538{
    int x, y;

    public Node_2538(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 영역구하기_2583 {

    static int n,m,k;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // m, n, k 값 입력 받기
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        graph = new int[n][m];
        visited = new boolean[n][m];
        // 그래프 입력
        // k개의 직사각형의 범위에는 -1 값으로 입력
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int xr = Integer.parseInt(st.nextToken());
            int yr = Integer.parseInt(st.nextToken());

            for(int j=x; j<=(xr-1); j++){
                for(int l=y; l<=(yr-1); l++){
                    graph[j][l] = -1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList(); // 각 영역의 모눈종이 칸의 개수를 저장
        int sector = 0; // 영역의 개수를 저장
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j] != -1) {
                    result.add(bfs(i, j));
//                    System.out.println("graph["+i+"]["+j+"] : " + graph[i][j] + ", cnt : " + bfs(i, j));
                    sector++;
                }
            }
        }

        Collections.sort(result);
        System.out.println(sector);
        for(int cnt : result){
            if(cnt != 0 ) System.out.print(cnt + " ");
        }

    }

    private static int bfs(int x, int y){
        Queue<Node_2538> q = new LinkedList<>();

        q.add(new Node_2538(x, y));
        visited[x][y] = true;
        int cnt = 1;

        while (!q.isEmpty()){
            Node_2538 node = q.poll();
            x = node.x;
            y = node.y;

            for(int i=0; i<dx.length; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(!visited[nx][ny] && graph[nx][ny] == 0){
                    visited[nx][ny] = true;
                    cnt++;
                    q.add(new Node_2538(nx, ny));
                }
            }
        }
        return cnt;
    }
}

//    private static int dfs(int x, int y, int cnt) {
//        visited[x][y] = true;
//
//        for(int i=0; i<4; i++){
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//
//            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
//            if(!visited[nx][ny] && graph[nx][ny] != -1){
//                return dfs(nx, ny, cnt+=1);
//            }
//        }
//        return cnt;
//    }