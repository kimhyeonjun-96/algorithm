package boj.dfs_bfs.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구상도
 *  1. 사람 수 만큼 반복을 하며 현재의 사람이 나머지 두 사람에게 몇번을 걸쳐 이어졌는지 구한다.
 *  2. 탐색을 했다면 걸린 횟수를 합친다
 *  3. 합친 수들 중 가장 작은 수를 가진 사람을 출력한다.
 *
 */

public class 케빈베이컨의6단계법치_1389 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++){
            relationship.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relationship.get(x).add(y);
            relationship.get(y).add(x);
        }


        int min = Integer.MAX_VALUE;
        int result = 0;

        // bfs 탐색
        for(int i=1; i<=n; i++){
            visited = new boolean[n + 1];
            int k = bfs(i);

            if(k<min){
                min = k;
                result = i;
            }
        }
        System.out.println(result);

    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int[] distance = new int[n+1];

        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
//                System.out.println("cur : " + cur);
                for(int next : relationship.get(cur)){
//                    System.out.println("next : " + next);
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                        distance[next] = distance[cur] + 1;
                    }
                }
            }
//            System.out.println("------------------");
        }

        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += distance[i];
        }
//        System.out.println("sum : " + sum);
//        System.out.println("=====================");
        return sum;
    }
}
