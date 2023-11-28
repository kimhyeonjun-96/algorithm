package boj.구현.mySolution;

/*
*   1. 풀이
*      단수인 N을 입력받아 1부터 9가지 반복하며 구구단을 출력한다.
*   2. 시간 복잡도
*       O(9) == O(1)
*       시간복잡도에서는 상수계산을 무시!!
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구구단_2739 {

    public static void main(String[] args) throws IOException {
        int N = input();
        gugudan(N);
    }
    static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
    static void gugudan(int N){
        for(int i=1; i<10; i++){
            System.out.println(N + " * " + i + " = " + N*i);
        }
    }
}
