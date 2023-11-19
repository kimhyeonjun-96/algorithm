package boj.구현.mySolution;

/*
*   1. 풀이
*       입력은 없지만 10000까지 셀프넘버를 구해야한다.
*       먼저 셀프넘버가 아닌 수를 먼저 구하고 이를 배열에 담고 10000까지 수가 존재하는지 비교하여 값을 도출하도록 생각하여 구현하였다.
*   2. 시간 복잡도
*       음.. 내가 만들었지만 잘 모르겠음!!
*   3. 배운 것
*       해당 문제는 자바 스트림과 관련한 기능으로 인하여 해결을 하였다.
*       문제를 풀면서 '이러한 기능이 분명 있을텐데..' 라는 생각이 많아 해당 기능만 조사하며 문제를 해결하였다.
*       자바 스트림에 대해서 공부가 더 필요하다!
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 셀프넘버_4673 {
    final static int MAX_NUM = 10000;
    static int[] arr = new int[MAX_NUM+1];
    static ArrayList<Integer> stack;

    static void getSelfNumber(){
        getArr();

        for(int i=1; i<=MAX_NUM; i++) {
            int finalI = i;
            if( Arrays.stream(arr).noneMatch(element ->
                {
                    if(element == finalI){
                        return true;
                    }
                    return false;
                }
            )){
                System.out.println(i);
            }
        }

    }

    static void getDigit(int i){
        while (i > 0){
            stack.add(i%10);
            i = i / 10;
            Collections.sort(stack);
        }
    }

    static void getArr(){
        for(int i=1; i<=MAX_NUM; i++){
            stack = new ArrayList<>();
            getDigit(i);

            int sum = i;
            for(int j=0; j< stack.size(); j++){
                sum += stack.get(j);
            }
            arr[i] = sum;
        }
    }

    public static void main(String[] args) {
        getSelfNumber();
    }
}
