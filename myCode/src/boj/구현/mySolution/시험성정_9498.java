package boj.구현.mySolution;

/*
*   1. 풀이
*       성적을 입력 받아 성적이 어느 등급에 속하는 점수인지 확인하여 등급을 반환한다.
*   2. 시간 복잡도
*       해당 문제는 입력 크기와는 상관없이 상수시간인 O(1) 이다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시험성정_9498 {
    public static void main(String[] args) throws IOException {
        int grade = input();
        System.out.println(testScore(grade));
    }
    static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
    static String testScore(int grade){

        if(90 <= grade && 100 >= grade){
            return "A";
        } else if (80 <= grade && 89 >= grade) {
            return "B";
        } else if (70 <= grade && 79 >= grade) {
            return "C";
        } else if (60 <= grade && 69 >= grade) {
            return "D";
        }else {
            return "F";
        }
    }
}
