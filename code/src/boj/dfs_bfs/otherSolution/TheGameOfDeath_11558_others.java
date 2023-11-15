package boj.dfs_bfs.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 도움 받은 사이트 : https://soyoung-it.tistory.com/entry/%EA%B5%AC%ED%98%84-The-Game-of-Death11558JAVA
* 도움 받은 사이트 : https://blog.onigiri.kr/100
* 도움 받은 사이트 : https://comengin.tistory.com/341
*
* 해당 문제는 알고리즘 분류에서는 그래프 탐색도 있지만 먼저 생각나는대로 반복문으로 문제를 해결하려 하였다.
* 우선 문제의 조건대로 N(1 ≤ N ≤ 10,000), Ai(1 ≤ Ai ≤ N, 1 ≤ i ≤ N)이기에 배열 0번은 건너 뛰고 값을 대입하여 맞추었다.
* 그리고 1번부터 시작하여 현재의 위치의 값이 다음 값이 되어 N의 값이 나올 때까지 반복하며 K를 구하려고 했다.
* 사실 어제 17204번 문제를 풀었다. 그걸 기반으로 해서 문제를 풀었다...
* 다른 사람들도 DFS같이 탐색 알고리즘을 구현을 해서 문제를 풀기보다는 구현으로 문제를 해결하였다.
*
* */
public class TheGameOfDeath_11558_others {
    static int N, point[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            point = new int[N+1];
            visited = new boolean[N+1];

            for(int j=1; j<=N; j++){
                point[j] = Integer.parseInt(br.readLine());
            }

            int target = 1;
            int cnt = 0;
            while (!visited[target] && target!=N){
                visited[target] = true;
                target = point[target];
                cnt++;
            }

            if(target == N){
                System.out.println("cnt = " + cnt);
            }else {
                System.out.println(0);
            }
        }
    }
}
