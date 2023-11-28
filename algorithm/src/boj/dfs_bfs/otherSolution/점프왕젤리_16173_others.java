package boj.dfs_bfs.otherSolution;

/*
* 도움 받은 사이트 : https://tang25.tistory.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-16173%EB%B2%88-%EC%A0%90%ED%94%84%EC%99%95-%EC%A9%B0%EB%A6%ACSmall
*
* 음.. 우선 처음 문제를 보았을 떄는 BFS로 풀어야 한다라고 생각을 했었다.
* 이유는 현재의 구역에서 오른쪽, 아래 두 방향의 구역으로 가는 방향을 모두 찾고 그 다음 구역에서 또 찾고 해서 목적지까지 가야하는 것으로 생각을 했었다.
* 그러다 처리순서를 적던 중 이상함을 느꼈다.
* 이유는 스스로 처리순서를 작성을 하는 것이 DFS처럼 한쪽 길로 끝까지 가는 것이었다.
* 그래서 이건 DFS로 푸는 것이 더 좋겠구나 라는 생각이 들어 DFS로 문제를 풀어보려 했다.
* ( 아! 물론 BFS로도 풀수 있다고는 한다. 하지만 지금의 내가 가진 지식으로는 힘들다! )
* 접근 방법은 찾았지만 구현을 위한 논리를 어떻게 생각을 해야하는지 몰라 헤메였다.
* 내가 생각을 한 것은 크게 두 가지의 조건이다.
*   1. 오른쪽, 아래의 방향으로 이동이 가능한가?
*   2. 다음으로 이동이 가능하다면 재귀호출을 통하여 다시 한번 확인을 하여 true값이 나올 때 까지 간다.
* 하지만 위의 조건만으로는 부족함이 있었다. 위의 조건은 범위와 방문 처리만을 진행을 했을뿐이다.
* 해당 구역으로 이동을 할 수 있고 이동을 했다면 언제까지 다음 구역으로 같은 방향으로 갈지와 끝까지 간 다음 다른 방향으로 가는 로직을 구현하지 못 했다.
*
* 사실 그냥 다 못 했다!! 하하하!!
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕젤리_16173_others {
    public static int N;
    public static int[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임판 셋팅
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        // 게임 구역 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));
    }
    public static String dfs(int x, int y){
        // 방문 처리
        visited[x][y] = true;
        // 도착지에 왔는지 확인
        if(graph[x][y] == -1){
            return "HaruHaru";
        }
        // 이동할 수 있는맘큼 오른쪽, 아래로 이동하여 확인
        int move = graph[x][y];
        if( x+move < N && !visited[x+move][y] && !dfs(x+move, y).equals("Hing"))
            return "HaruHaru";
        if( y+move < N && !visited[x][y+move] && !dfs(x, y+move).equals("Hing"))
            return "HaruHaru";

        return "Hing";
    }
}
