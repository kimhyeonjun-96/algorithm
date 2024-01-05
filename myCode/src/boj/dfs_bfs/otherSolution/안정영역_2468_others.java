package boj.dfs_bfs.otherSolution;
// https://loosie.tistory.com/297
// 아아아 브루트포스으으으으으으
/*
 * "그릿 속의 해빗" 블로그의 구상도
 *  1. 각 높이에 따라 브루트포스로 맵을 전체 탐색
 *  2. 탐색 도중 안전지역이 있으면 해당 지역을 시작으로 DFS 탐색 시작
 *  3. 안전지역 DFS 탐색이 끝났으면 cnt 증가
 *  4. height에 따라 나온 Cnt 중 최댓값을 출력
 *
 * 나의 구상도
 *  1. 지역 입력 받기
 *  2. 지역을 입력 받다 가장 높은 지역의 값을 저장
 *  3. 1부터 가장 높은 지역만만 반복을 하며 지역의 안전지역을 찾기
 *  4. 안전지역이 아니라면 cnt 증가하여 다시 탐색 시작
 *  5. cnt를 반환하여 각 강수량마다 안전지역의 개수를 저장
 *  6. 안전지역의 개수중 가장 큰 닶을 출력
 *
 * 차이
 *  블로그에서는 먼저 브루트포스와 DFS라는 두 가지의 알고리즘으로 문제를 분해를 하였다.
 *  그리고 구상도 2번을 통하여 패턴 매칭을 진행하였다.
 *  컴퓨팅 사고력이 블로그분은 빛이 나는 것 같다!!
 *  나는...개판이다!! 나 같은 경우는 무엇이 문제였을까?
 *  다들 기본적인 문제로 보고 잘들 푸는데... 허허허
 *
 * 시간복잡도
 *  O(N^2)
 *
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안정영역_2468_others {
    static int n;
    static int[][] map;
    static boolean[][] checked;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};


    static int dfs(int x, int y, int height){
        checked[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
            if(checked[nx][ny]) continue;
            if(map[nx][ny] > height) dfs(nx, ny, height);
        }
        return 1;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxHeight = 0;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }

        int max = 0;
        for(int height=0; height<maxHeight+1; height++){
            checked = new boolean[n][n];
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!checked[i][j] && map[i][j] > height){
                        cnt += dfs(i, j,height);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
