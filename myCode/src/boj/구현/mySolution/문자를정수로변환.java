package boj.구현.mySolution;

import java.util.Scanner;

public class 문자를정수로변환 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 정수/음수 판단
        boolean sign = true;
        int result = 0;
        String str = sc.nextLine();

        for (int i = 0; i < str.length(); i++) {
            // 문자를 하나씩 확인
            char ch = str.charAt(i);
            if (ch == '-') { // 음수라면 sign을 false로 변경
                sign = false;
            } else {
                result = result * 10 + (ch - '0'); // 문자를 숫자고 변환
            }
        }

        result = sign ? 1*result : -1*result; // 부호에 따라 결과 값 변경
        System.out.println("result = " + result);
    }
}
