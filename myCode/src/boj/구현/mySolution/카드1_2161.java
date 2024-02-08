package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1_2161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            // 맨위 카드를 버린다.
            sb.append(q.poll()).append(' ');

            // 다음 위치의 카드를 맨 뒤로 보낸다.
            int next = q.poll();
            q.add(next);
        }
        sb.append(q.poll());

        System.out.println(sb);
    }
}
