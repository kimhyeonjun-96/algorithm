package boj.greedy.oterhSolution;

/*
* https://st-lab.tistory.com/104
* 카운팅 정렬
*   정렬 알고리즘 중 시간복잡도가 O(n)으로 엄청난 성능을 보여주는 알고리즘이다.
*   퀵정렬, 힙정렬, 합병정렬 등이 있는데 이들의 평균 시간복잡도는 O(nlogn)이다.
*   기본적으로 정렬은 데이터끼리 직접 비교를 하는데, 데이터끼리 비교를 하면 시간복잡도가 O(nlogn)보다 작아질 수 없다.
*
*   카운팅 정렬의 정렬 방법
*       과정1.
*           데이터의 값이 몇번 나왔는지를 센다
*           예를 들어 arr = { 7, 2, 3 ,5 , 7, 1, 4, 6, 7, 5, 0 ,1 } 이라면 각 데이터의 idx에 데이터가 몇번 나왔는지 세어 저장한다.
*           count_arr = { 1, 2, 1, 1, 1, 2, 1, 3 }
*               0의 개수 : 1개
*               1의 개수 : 2개
*               2의 개수 : 1개 ...
*       과정2.
*           카운팅 배열의 각 값을 누적합으로 변환한다
*       과정3.
*           카운팅 배열의 각 값은 대응되는 결과 배열의 위치에 배정한다.
*           배정할 때, 값 -1을 위치에 배정한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM_11399_others {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1001];

        // counting sort
        while (n-- > 0){
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int prev = 0;
        int sum = 0;

        for(int i=0; i<1001; i++){
            while (arr[i]-- > 0){
                sum += (i + prev);
                prev += i;
            }
        }
        System.out.println(sum);
    }
}
