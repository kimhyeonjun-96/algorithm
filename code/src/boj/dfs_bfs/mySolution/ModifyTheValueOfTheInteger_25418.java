package boj.dfs_bfs.mySolution;
/*
* 문제 풀이
* 1. A와 K를 입력 받는다.
* 2. A가 K가 아니라면 반복한다.
* 2.1. 큐를 만든다.
* 2.2. currentA 값을 큐에서 받는다.
* 2.2. plusA를 만든다.
* 2.2.1. plusA가 K와 같은지 확인한다.
* 2.2.2. 아니라면 큐에 값을 추가한다.
* 2.3. multiplyA를 만든다.
* 2.3.1. multiplyA가 K와 같은지 확인한다.
* 2.3.2. 아니라면 큐에 값을 추가한다.
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ModifyTheValueOfTheInteger_25418 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A,K));
    }
    private static int bfs(int start, int K){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        int cnt = 0;

        while (!q.isEmpty()){
            int currentA = q.poll();

            if(currentA > K) continue;
            if(currentA == K) return cnt;

            cnt++;
            int plusA = currentA+1;
            int multiplyA = currentA*2;

            if(plusA != K){
                q.offer(plusA);
            }
            if (multiplyA != K) {
                q.offer(multiplyA);
            }
            if(plusA == K || multiplyA == K) return cnt;
        }

        return cnt;
    }
}
