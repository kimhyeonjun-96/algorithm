package boj.dfs_bfs.otherSolution;

/*
* 도움 받은 사이트 : GPT ㅎㅎ
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 바이러스_2606_others {
    static int n;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(count - 1);  // 1번 컴퓨터는 제외
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);  // 양방향 그래프
        }

        bfs(1);
    }
}
