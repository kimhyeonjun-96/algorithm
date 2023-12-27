package boj.greedy.oterhSolution;

/*
* 해당 문제에서.. 분명 b배열은 건들이지 말라는 조건이 있었는데...
* 하지만 건들이지 않고서 문제를 해결하기가 어려웠다..
* 생각을 해보자...
*
* 시간복잡도 : O(nlogn) ( 정렬 때문에 )
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보물_1026_others {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());

        int s = 0;
        for(int i=0; i<n; i++){
            s += a[i] * b[i];
        }
        System.out.println(s);
    }
}
