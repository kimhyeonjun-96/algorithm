package boj.dfs_bfs.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_14502_2 {
    static int N, M;
    static int[][] lab;
    static List<Point> emptySpace = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0){
                    emptySpace.add(new Point(i, j));
                }
            }
        }

        combination(0, 0, new int[3]);
        System.out.println(max);

    }

    private static void combination(int start, int cnt, int[] selected) {
        if(cnt == 3){
            check_safe_area(selected);
            return;
        }

        for(int i=start; i<emptySpace.size(); i++){
            selected[cnt] = i;
            combination(i+1, cnt+1, selected);
        }
    }

    private static void check_safe_area(int[] selected) {
        int[][] tmpLab = new int[N][M];

        for(int i=0; i<N; i++){
            tmpLab[i] = Arrays.copyOf(lab[i], M);
        }

        for(int idx : selected){
            Point wall = emptySpace.get(idx);
            tmpLab[wall.x][wall.y] = 1;
        }

        int safeAreaCnt = bfs(tmpLab);

        max = Math.max(max, safeAreaCnt);
    }

    private static int bfs(int[][] tmpLab) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpLab[i][j] == 2){
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Point cur = q.poll();

            for(int d=0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && tmpLab[nx][ny] == 0 && !visited[nx][ny]){
                    q.offer(new Point(nx, ny));
                    tmpLab[nx][ny] = 2;
                    visited[nx][ny] = true;
                }
            }
        }

        int safeArea = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpLab[i][j] == 0){
                    safeArea++;
                }
            }
        }

        return safeArea;
    }


}
