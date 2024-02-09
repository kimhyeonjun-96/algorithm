package boj.구현.otherSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 에라토스테네스의체_2960_others {
    static int N, K, cnt, result;
    static boolean[] isRemoved;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isRemoved = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (!isRemoved[i]) {
                removeMultiples(i);
            }
        }

        // 여기서 result 변수에 K번째로 제거된 값을 찾음
        for (int i = 2; i <= N; i++) {
            if (isRemoved[i]) {
                cnt++;
                if (cnt == K) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void removeMultiples(int p) {
        System.out.println("p = " + p);
        System.out.println("result = " + result);

        for (int i = p; i <= N; i += p) {
            if (!isRemoved[i]) {
                isRemoved[i] = true;
                cnt++;
                if (cnt == K) {
                    result = i;
                    break;
                }
            }
        }
    }
}
