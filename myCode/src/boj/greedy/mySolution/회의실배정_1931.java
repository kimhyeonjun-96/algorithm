package boj.greedy.mySolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays.*;


class Node_1931 implements Comparable<Node_1931>{
    int start, end;

    public Node_1931(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Node_1931{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Node_1931 o) {
        return Integer.compare(this.end, o.end);
    }
}
public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Node_1931> arr = new ArrayList<>();

        // 데이터 입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr.add(new Node_1931(start, end));
        }

        // 종료 시간으로 데이터 정렬
        Collections.sort(arr);

        int cnt = 0;
        int prev_end = 0;

        // 이전 종료시간이 현재의 시작 시간보다 작거나 같다면 회의 개수를 센다.
        for(Node_1931 node : arr){
            if(prev_end <= node.start){
                prev_end = node.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}