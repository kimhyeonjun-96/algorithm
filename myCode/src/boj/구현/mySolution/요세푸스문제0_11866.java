package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0_11866 {

    static int n, k;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        for(int i=0; i<n; i++) q.add(i + 1);

        sb.append('<');
        while (q.size() > 1) {
            for(int i=0; i<k-1; i++){ // 1234567-> 3456712(3), 456712 -> 671245(6), 71245 -> 24571(2), 4571 -> 7145(7), 145->514(5), 14->14(1),
                int e = q.poll();
                q.add(e);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}
