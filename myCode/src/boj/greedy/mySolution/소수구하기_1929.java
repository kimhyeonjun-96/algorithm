package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {

    static int M, N;
    static boolean[] isPrime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N + 1];
        findPrime();

        for(int i = M; i <= N; i++) {
            if(!isPrime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    private static void findPrime() {

        // true = 소수아님 , false = 소수
        isPrime[0] = isPrime[1] = true;

        for(int i=2; i<=Math.sqrt(isPrime.length); i++){
            if(isPrime[i]) {continue;}
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}
