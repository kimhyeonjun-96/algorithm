package boj.dfs_bfs.mySolution;
/**
 * 구상도
 *  1. 연구실 정보를 입력 받는다.
 *  2. 연구실 전체를 탐색하며 임의의 벽 3개를 세우고 BFS 탐색을 통하여 언전 영역의 개수를 구한다.
 *  3. 안전 영역의 개수 중 최댓값을 찾는다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static int n, m;
    static int result_safe_area = 0;
    static int[][] origin_map;
    static int[] dx = {-1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        origin_map = new int[n][m];

        // 연구실 정보를 입력 받기
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                origin_map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맵 전체를 탐색하면서 벽 3개를 세워보고 안전영역 구하기
        creatWall(origin_map);

        // 결과 출력
        System.out.println(result_safe_area);
    }

    private static int[][] copyLap(int[][] originMap) {
        int[][] arr = new int[originMap.length][originMap[0].length];

        for(int i=0; i<originMap.length; i++){
            for(int j=0; j<originMap[0].length; j++){
                arr[i][j] = originMap[i][j];
            }
        }
        return arr;
    }

    private static void creatWall(int[][] map){
        // 행 탐색
        for(int ni=0; ni<n; ni++){
            for(int nj=ni+1; nj<n; nj++){
                for(int nk=nj+1; nk<n; nk++){

                    // 열 탐색
                    for(int mi=0; mi<m; mi++){
                        if(map[ni][mi] == 0){
                            for(int mj=0; mj<m; mj++){
                                if(map[nj][mj] == 0){
                                    for(int mk=0; mk<m; mk++){
                                        if(map[nk][mk] == 0){
                                            // BFS 탐색을 통한 안전영역 구하기
                                            int[][] cloneMap = copyLap(map);

                                            cloneMap[ni][mi] = 1;
                                            cloneMap[nj][mj] = 1;
                                            cloneMap[nk][mk] = 1;

                                            bfs(cloneMap);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void bfs(int[][] cloneMap) {
        int[][] tmpMap = copyLap(cloneMap);
        Queue<int[]> q = new LinkedList<>();


        // 초기 바이러스 위치를 큐에 저장
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tmpMap[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        // 바이러스가 퍼진 후 안전영역 구하기
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(tmpMap[nx][ny] == 0){
                    tmpMap[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int safeArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tmpMap[i][j] == 0) safeArea+=1;
            }
        }
        result_safe_area = Math.max(result_safe_area, safeArea);
    }
}

