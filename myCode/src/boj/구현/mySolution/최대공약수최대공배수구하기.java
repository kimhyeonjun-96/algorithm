package boj.구현.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대공약수최대공배수구하기 {

    static int n, m, gcd, lcm;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        gcd = getGcd(n, m);
        lcm = n * m / gcd;

        System.out.println("gcd = " + gcd);
        System.out.println("lmc = " + lcm);
    }

    private static int getGcd(int n, int m) {

        int a = Math.max(n, m); // 큰 수
        int b = Math.min(n, m); // 작은 수

        while (b > 0) {
            int tmp = a; // 임시 변수에 a 저장
            a = b; // a에 b 저장
            b = tmp % b; // b에 a를 b로 나눈 나머지 저장
         }
        return a;
    }
}
