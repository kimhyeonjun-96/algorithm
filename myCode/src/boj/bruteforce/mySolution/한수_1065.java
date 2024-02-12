package boj.bruteforce.mySolution;

/**
 * X의 각 자리가 등차수열을 이룬다면 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 차이가 일정한 수열을 말한다.
 * N이 주어졌을 때, 1보다 크거나 같고 N보다 작거나 같은 한수의 개수를 출력하라.
 *
 * N이 주어진다면 1부터 N만큼 반복한다. ( N은 1000 이하의 수! )
 * 반복하면서 해당 정수가 한수라면 개수를 센다.
 *  한수인지 파악하기 위해서 먼저 주어진 정수가 두 자리수 이하인지 확인한다. 두 자리수라면 무조건 한수이다.
 *  정수가 세 자리수라면 각 자리의 있는 수를 배열에 저장한다.
 *  그리고 arr[0] - arr[1] == arr[1] - arr[2] 맞는지 확인한다.
 * 개수를 출력한다.
 *
 * 어,, 그런데 런타임 에러가 발생하네..?음.. 틀렸네..
 * 이유는 1000이 들어왔을 때 기대했던 값과는 다르게 출력이 된다.
 *----------------------------------------------------------------------------------------------------------------------
 * 찾아보니 등차수열의 특징으로 문제를 해결을 많이 함..
 * 각 자리수를 변수로 받는다. 그리고 가운데 숫자에 2를 곱하면 직전과 직후 숫자의 합과 동일 하다. 이러한 특징을 이용하여 문제를 해결해야한다.
 *
 * 아.. 제출 양식 다르게 해서 한번 더 틀렸다..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수_1065 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if(newCheckHansu(i)){
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }

    static boolean newCheckHansu(int num) {

        if(num<100) return true;

        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 10;

        if (ten * 2 != hundred + one) {
            return false;
        }
        return true;
    }

    static boolean checkHansu(int num) {

        if (num < 100) return true;

        int[] arr = new int[4];
        int idx = 0;
        while (num > 0) {
            arr[idx++] = num % 10;
            num /= 10;
        }

        return arr[0] - arr[1] == arr[1] - arr[2];
    }
}
