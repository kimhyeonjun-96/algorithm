package boj.greedy.mySolution;

/*
* 문제를 여러번 틀렸다..
* 이유는 NumberFormat...
* int형으로 했다가 long으로 바꿨는데 long n = Long.parseLong(br.readLine()); 이걸 안 바꿔서 계속 틀림..
* 미쳤나...
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long prev = 0;
        long max = prev;
        while (n > 0){
            prev += 1;
            if(n-prev < 0) break;
            n-=prev;
            max = prev;
        }
        System.out.println(max);
    }
}
