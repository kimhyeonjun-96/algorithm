package boj.구현.mySolution;

/*
 *   1. 풀이
 *      첫번째 풀이
 *      k와 n을 입력 받는다.  다만 현재의 코드와는 다르게 n을 getSum 메소드에서 k번 만큼 입력을 받았다. 어떻게? input 메소드를 통해서 입력 받았다.
 *      그러나 그렇게 입력을 받으면 "런타임 에러 (NumberFormat)" 오류가 발생하였다.
 *      해당 오류는 입력 타입이 잘 못되었거나 입력을 잘 못하였고 자료형의 크기보다 높은 크기를 입력 받았을 때 발생하는 오류이다.
 *
 *      두번째 풀이
 *      런타임 에러 (NumberFormat) 오류를 막기 위해 k와 n을 따로 입력을 받도록 하였고 그런 과정 중에 어쩔 수 없이 k번의 반복이 두번 발생하게 되었다.
 *   2. 시간 복잡도
 *      O(k)
 *      k가 100이라면 100, 예제에서는 10까지이고 총 10번의 반복이 된다.
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {
    static int k, n[];
    static Stack<Integer> stack = new Stack<>();

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        n = new int[k+1];
        for(int i=0; i<k; i++){
            n[i] = Integer.parseInt(br.readLine());
        }
    }

    static void getSum(int k) {
        for(int i=0; i<k; i++){
            if(n[i] == 0){
                stack.pop();
                continue;
            }else {
                stack.add(n[i]);
            }
        }
        int sum = 0;
        for(int value : stack){
            sum += value;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        input();
        getSum(k);
    }
}
