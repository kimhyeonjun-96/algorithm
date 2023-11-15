package org.boj.dfs_bfs.otherSolution;

/*
* 도움 받은 사이트 : https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-25418-%EC%A0%95%EC%88%98-a%EB%A5%BC-k%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-java
* 도움 받은 사이트 : https://nahwasa.com/entry/BFS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%84%88%EB%B9%84-%EC%9A%B0%EC%84%A0-%ED%83%90%EC%83%89-%EB%B0%B0%EC%97%B4-BFS-%EA%B7%B8%EB%9E%98%ED%94%84-BFS
* 도움 받은 사이트 : https://velog.io/@morning-la/%EB%B0%B1%EC%A4%80-25418-%EC%A0%95%EC%88%98-a%EB%A5%BC-k%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-JAVA
* 도움 받은 사이트 : https://bacchus-lover.tistory.com/351
*
* 휴아,,, DFS, BFS는 꼭 방문체크를 해야한다!!!!
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ModifyTheValueOfTheInteger_25418_others {
    public static void main(String[] args) throws Exception {
        new ModifyTheValueOfTheInteger_25418_others().bfs();
    }

    private static void bfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[k+1];

        q.add(new int[]{a, 0});
        v[a] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == k){
                System.out.println(cur[1]);
                return;
            }

            if(cur[0]*2 <= k){
                v[cur[0]*2] = true;
                q.add(new int[]{cur[0]*2, cur[1]+1});
            }
            if(!v[cur[0]+1]){
                q.add(new int[]{cur[0]+1, cur[1]+1});
            }
        }
    }
}
