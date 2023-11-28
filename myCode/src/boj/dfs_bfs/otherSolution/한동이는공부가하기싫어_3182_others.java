package boj.dfs_bfs.otherSolution;

/*
 *  도움 받은 사이트 : https://velog.io/@digh0515/%EB%B0%B1%EC%A4%80-3182%EB%B2%88-%ED%95%9C%EB%8F%99%EC%9D%B4%EB%8A%94-%EA%B3%B5%EB%B6%80%EA%B0%80-%ED%95%98%EA%B8%B0-%EC%8B%AB%EC%96%B4java
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한동이는공부가하기싫어_3182_others {
    static int[] arr;

    static boolean[] visited;

    static void dfs(int index) {
        visited[index] = true;
        while (!visited[arr[index]]) {
            dfs(arr[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        //선택한 선배마다 만날 수 있는 선배의 수 저장할 배열
        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int max = 0;
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i);
            for (int j = 1; j < N + 1; j++) {
                if (visited[j] == true)
                    cnt++;
            }
            answer[i] = cnt;
            cnt = 0;
        }
        //최댓값 찾기
        int max_index = 0;
        for (int i = 1; i < N + 1; i++) {
            if (max < answer[i]) {
                max = answer[i];
                max_index = i;
            }
        }
        System.out.println(max_index);

    }
}
