package boj.dfs_bfs.mySolution;
/**
 * 이전에 풀었던 것을 기반으로 구상도 다시 작성 후 코드 작성
 * 구상도
 *  1. 1부터 N번 사람까지 반복하며 현재의 사람이 나머지 두 사람에 대한 단계를 BFS로 탐색하고 케빈베이컨의 수를 구한다.
 *  2. 케빈베이컨의 수가 가장 적은 사람을 구한다.
 *  3. 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법치_1389_2 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min_bacon = Integer.MAX_VALUE;
        int result = 0;

        // BFS 탐색
        for(int i=1; i<=n; i++){
            visited = new boolean[n + 1];
            int bacon = bfs(i);

            if(bacon < min_bacon){
                min_bacon = bacon;
                result = i;
            }
        }
        System.out.println(result);
    }

    private static int bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        int[] distance = new int[n + 1];

        while (!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int cur = q.poll();
                for(int next : graph.get(cur)){
                    if(!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                        distance[next] = distance[cur] + 1;
                    }
                }
            }
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += distance[i];
        }
        return sum;
    }
}