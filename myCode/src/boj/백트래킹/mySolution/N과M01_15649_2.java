package boj.백트래킹.mySolution;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구상도
 *  1. N, M이 주어지고, 중복되는 수를 제외한 모든 경우의 수를 탐색
 *  2. 재귀를 할 때, 이미 방문한 노드라면 다음 노드를 탐색하도록 하기위해 Nzmrldml boolean 배열을 생성하고 탐색과적에서 값을 담을 int배열을 생성
 *  3. dfs에서 depth를 통해 재귀가 깊어질 때마다 depth를 1씩 증가시켜 M과 같아지면 더 이상 재귀를 호출하지 않고 탐색 과정 중 값을 감았던 arr을 출력한다.
 *
 */

public class N과M01_15649_2 {

    public static int N, M;
    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);
    }

    static void dfs(int depth) {

        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;

                dfs(depth + 1);

                visit[i] = false;
            }
        }
    }
}
