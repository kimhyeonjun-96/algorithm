package boj.dfs_bfs.otherSolution;
/*
 * 도움 받은 사이트 : https://read-me.tistory.com/entry/JAVABOJS3-1388-%EB%B0%94%EB%8B%A5-%EC%9E%A5%EC%8B%9D#toc-%EC%B6%9C%EB%A0%A5
 *
 * 나의 경우에는 하나의 메서드에서 -와 |를 처리하려고 하였다.
 * 하지만 "- 가 아니라면 종료한다."와 같이 종료 조건을 어떻게 주어야할지 생각이 나지않았다.
 *
 * 위의 경우에는 row라는 변수를 하나 더 만들어 나의 고민을 해결하였다.
 * 보고 배웠다...
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바닥장식_1388_others {
    static int N, M;
    static char[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        // 그래프 초기화, 띄어쓰기 없이 값을 입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        // 나무판자가 몇개인지 dfs메서드를 통하여 확인
        int count = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(visited[i][j]) continue;
                if(graph[i][j] == '-') {
                    dfs(i, j, true);
                }
                else {
                    dfs(i, j, false);
                }
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y, boolean row) {
        visited[x][y] = true;
        if(row){
            y++;
            if(y < M && graph[x][y] == '-'){
                dfs(x, y, true);
            }
        }else {
            x++;
            if (x < N && graph[x][y] != '-'){
                dfs(x, y, false);
            }
        }
    }
}
